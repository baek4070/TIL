package com.ana.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.logging.Log;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.UserOperations;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.ana.service.UserService;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/user/*")
@AllArgsConstructor
@SessionAttributes("user")

public class LoginController {

	@Autowired
	UserService service;

	@Autowired
	private FacebookConnectionFactory connectionFactory;
	
	@Autowired
	private OAuth2Parameters oAuth2Parameters;
	
	
	// login ????????? ????????????
	/*
	 * @GetMapping("/login") public String showLoginPage() { return "/user/login"; }
	 */

	// welcome ????????? ???????????? ??????
	@GetMapping("/welcome")
	public ModelAndView showWelcome(Model model, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/user/welcome");
		return mv;
	}

	// excuteLogin??? get?????? mapping??? ?????????????????? ????????????
	@GetMapping("/executeLogin")
	public String executeLogin() {
		return "/error/error";
	}


	
	@RequestMapping(value = "/user/login", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView join(HttpServletRequest request, HttpServletResponse response, Model model) {
        
		log.info("request.getRequestURI(): "+request.getRequestURI());
		log.info("referer: "+ request.getHeader("referer"));
		
        OAuth2Operations oauthOperations = connectionFactory.getOAuthOperations();
        String facebook_url = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, oAuth2Parameters);
    
        model.addAttribute("facebook_url", facebook_url);
        System.out.println("/facebook" + facebook_url);
 
        String url= "/user/login?url="+  request.getHeader("referer");
        String url2 = url.substring(url.lastIndexOf("/") -4, url.length()); // => acm/list
        log.info("url2: "+url2);
        
        String here= url+ url2;
        
        ModelAndView mv= new ModelAndView();
        mv.addObject("requestFrom", url2);
        mv.setViewName("/user/login");
        
        return mv;
	}
	
	 @RequestMapping(value = "/facebookSignInCallback", method = { RequestMethod.GET, RequestMethod.POST })
	    public String facebookSignInCallback(@RequestParam String code) throws Exception {
	 
	        try { 
	             String redirectUri = oAuth2Parameters.getRedirectUri();
	            System.out.println("Redirect URI : " + redirectUri);
	            System.out.println("Code : " + code);
	 
	            OAuth2Operations oauthOperations = connectionFactory.getOAuthOperations();
	            AccessGrant accessGrant = oauthOperations.exchangeForAccess(code, redirectUri, null);
	            String accessToken = accessGrant.getAccessToken();
	            System.out.println("AccessToken: " + accessToken);
	            Long expireTime = accessGrant.getExpireTime();
	        
	            
	            if (expireTime != null && expireTime < System.currentTimeMillis()) {
	                accessToken = accessGrant.getRefreshToken();
	               
	            };
	            
	        
	            Connection<Facebook> connection = connectionFactory.createConnection(accessGrant);
	            Facebook facebook = connection == null ? new FacebookTemplate(accessToken) : connection.getApi();
	            UserOperations userOperations = facebook.userOperations();
	            
	            try
	 
	            {            
	                String [] fields = { "id", "email",  "name"};
	                User userProfile = facebook.fetchObject("me", User.class, fields);
	                System.out.println("??????????????? : " + userProfile.getEmail());
	                System.out.println("?????? id : " + userProfile.getId());
	                System.out.println("?????? name : " + userProfile.getName());
	                
	            } catch (MissingAuthorizationException e) {
	                e.printStackTrace();
	            }
	 
	        
	        } catch (Exception e) {
	 
	            e.printStackTrace();
	 
	        }
	        return "redirect:/acm/list";
	 
	    }

	
	// ?????? ?????????
	private static final HttpTransport transport = new NetHttpTransport();
	private static final JsonFactory jsonFactory = new JacksonFactory();
	private static final String MY_APP_GOOGLE_CLIENT_ID = "942421543250-i3vvb6s828smd122lqcdr0buvjg2p6ui.apps.googleusercontent.com";

	@RequestMapping(value = "/login/tokenSignIn", method = RequestMethod.POST)
	@ResponseBody
	public void executeGoogleLogin(@RequestParam MultiValueMap<String, String> body, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws IOException, GeneralSecurityException {

		System.out.println("id Token: " + body.getFirst("idToken"));
		String idTokenString = body.getFirst("idToken");
		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
				// Specify the CLIENT_ID of the app that accesses the backend:
				.setAudience(Collections.singletonList(MY_APP_GOOGLE_CLIENT_ID))
				// Or, if multiple clients access the backend:
				// .setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
				.build();

// (Receive idTokenString by HTTPS POST)
//String idTokenString= request.getParameter("idToken");
		System.out.println("idTokenString: " + idTokenString.toString());
		GoogleIdToken idToken = verifier.verify(idTokenString);
		int result = 0;
		JSONObject jso = new JSONObject();
		if (idToken != null) {
			Payload payload = idToken.getPayload();

			// Print user identifier
			String userId = payload.getSubject();
			System.out.println("User ID: " + userId);

			// Get profile information from payload
			String email = payload.getEmail();
			boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
			String name = (String) payload.get("name");
			String pictureUrl = (String) payload.get("picture");
			String locale = (String) payload.get("locale");
			String familyName = (String) payload.get("family_name");
			String givenName = (String) payload.get("given_name");

			// Use or store profile information
			// ...
			System.out.println("email:" + email);
			System.out.println("emailVerified :" + emailVerified);
			System.out.println("name:" + name);
			System.out.println("familyName:" + familyName);
			System.out.println("givenName:" + givenName);

			result = service.executeGoogleLogin(email, familyName, givenName, session);

			jso.put("result", result);
			log.info("%%%%%%%%%%result: "+ result);
			PrintWriter out = response.getWriter();
			out.print(jso);
			
			StringBuffer contextPath = request.getRequestURL();
			String Referer= request.getHeader("referer");
			log.info("Referer: "+ Referer);
			log.info("ContextPath: " + contextPath);
		}

		else {
			System.out.println("Invalid ID token.");
			jso.put("result", result);
			PrintWriter out = response.getWriter();
			out.print(jso);
		}
		

	}

	// ????????? ????????????
	@RequestMapping(value = "/executeLogin", method = RequestMethod.POST)
	@ResponseBody
	public void executeLogin(String email, String pwd, HttpSession session, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes rttr, Model model) throws IOException {
		System.out.println("executeLogin");
		JSONObject jso = new JSONObject();
		log.info("login email: " + email);
		log.info("login pwd: " + pwd);
		String user_check = request.getParameter("remember_email");
		log.info("remember_email checked: " + user_check);
		
		//?????? ??????????????? ??????????????? ??????
		StringBuffer contextPath = request.getRequestURL();
		String Referer= request.getHeader("referer");
		log.info("Referer: "+ Referer);
		log.info("ContextPath: " + contextPath);
		log.info("RequestURI(): " + request.getRequestURI());
		
		// ???????????? ???????????? ????????? ????????? ??????
		int result = service.executeLogin(email, pwd, user_check, response, session);
		jso.put("msg", result);
		PrintWriter out = response.getWriter();
		out.print(jso);

	}

	// ??????????????? ?????? ??????(=???????????? user??? ???????????? ??????)
	@GetMapping("/logout")
	public String logout(SessionStatus status, HttpSession session, HttpServletRequest request) {
		log.info("session ??????: " + status);
		log.info("session??? ??????? :"+ session.toString());

		session = request.getSession(false);
	    if (session != null) {
	        session.invalidate();
	        log.info("session?????????");
	    }
		
		log.info("session??? ????????? ??????? :"+ session);

		// session??? ?????? ?????????
		status.setComplete();
		

		// ?????? ?????????????????? ??? ??? ??????????????? ????????? jsp??? ????????? ???????????? ???????????????(7/13)
		StringBuffer contextPath = request.getRequestURL();
		String Referer= request.getHeader("referer");
		log.info("Referer: "+ Referer);
		log.info("ContextPath: " + contextPath);

		// ???????????? ?????? ???????????? ??????????????? ????????? ?????????
		if (status.isComplete() == true) {
			log.info("Session removed successfully");
		}
		// ????????? acm/list ???????????? ??????
		// ????????? ?????? ???????????? ???????????? ??????????????? ??? ????????? ???????????? ?????? ?????? ????????????...(???????????????!!)
		return "/acm/list";
	}

}
