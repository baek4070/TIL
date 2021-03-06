package net.koreate.controller.home;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.koreate.dao.TestDAO;
import net.koreate.service.TestService;
import net.koreate.vo.ProductVO;




@Controller
public class HomeController {
	
	@Autowired(required = false)
	TestService ts;
	
	@Autowired
	TestDAO dao;
	
	@Inject
	ProductVO product;
	
	
	@RequestMapping("doA")
	public void doA() {
		System.out.println("doA 호출");
		System.out.println(product);
		
		if(dao != null) {
			dao.testDAO("homeController ");
		}else {
			System.out.println("homeController dao is null");
		}
		
		if(ts != null) {
			ts.testService("HomeController");
		}else {
			System.out.println("HomeController dao is null");
		}
	}
	
	@RequestMapping("doB")
	public String doB() {
		return "home";
	}
	
	@RequestMapping("doC")
	public String doC(Model model) {
		model.addAttribute("msg","model로 전달된 데이터");
		//<h3>${requestScope.msg}</h3>
		return "result";
	}
	
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
