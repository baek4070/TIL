package net.koreate.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @Controller : Presentation Layer에서 Controller를 명시함.
 * @Service	   : Business Layer의 Service를 명시함.
 * @Repository : Persistence Layer의 Database Access Object 를 명시
 * @Component
 */
@Controller
public class HomeController {
	
	@RequestMapping("doA")
	public void doA() {}
	/*
	public String doA() {
		System.out.println("doA Call");
		// request.getReqeustDispatcher(WEB-INF/views/doA.jsp);
		// request.forward(request,response);
		return "doA";
	}
	*/
	
	@RequestMapping("doB")
	public String doB() {
		return "home";
	}
	
	@RequestMapping("doC")
	public String doC(Model model) {
		model.addAttribute("msg","model로 전달된 데이터");
		return "result";
	}
	/*
	public String doC(HttpServletRequest request){
		request.setAttribute("msg", "1도 모르겠다.");
		return "result";
	}
	*/
	
	@RequestMapping(value="doD", method=RequestMethod.GET)
	public String doD(
			//@RequestParam(name="msg",required = true) String message,
			String msg,
			Model model) {
			System.out.println("message : " + msg);
			model.addAttribute("msg",msg);
		return "result";
	}
	
	@RequestMapping(value="doD", method=RequestMethod.POST)
	public String doD(String msg,int age,Model model) {
		System.out.println(msg);
		System.out.println(age);
		model.addAttribute("msg","doD : "+msg+ "age : "+age);
		return "result";
	}
}





















