package net.koreate.controller.doCon;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DoController {
	
	public DoController() {
		System.out.println("DoController 생성");
	}
	
	@RequestMapping("main.do")
	public void main(){
		System.out.println("main.do 요청");
	}
	
}






