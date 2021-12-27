package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.LoginDTO;
import vo.MemberVO;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		String encoding = config.getInitParameter("encoding");
		System.out.println("encoding : " + encoding);
		super.init(config);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String encoding 
			= getServletConfig().getInitParameter("encoding");
		request.setCharacterEncoding(encoding);
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String login = request.getParameter("login");
		LoginDTO dto = new LoginDTO();
		dto.setId(id);
		dto.setPass(pass);
		dto.setLogin(login);
		System.out.println(dto);
		
		ServletContext application = getServletContext();
		List<MemberVO> memberList
			= (ArrayList<MemberVO>)application.getAttribute("memberList");
		MemberVO loginMember = null;
		if(memberList != null && !memberList.isEmpty()) {
			for(MemberVO m : memberList) {
				if(m.getId().equals(id) 
						&&
				   m.getPass().equals(dto.getPass())) {
					loginMember = m;
					break;
				}
			}
		}
		
		if(loginMember != null) {
			// 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			response.sendRedirect("main.jsp");
		}else {
			// 로그인 실패
			response.sendRedirect("login.jsp");
		}
		
		
		
	}
	
	
	
	

}
