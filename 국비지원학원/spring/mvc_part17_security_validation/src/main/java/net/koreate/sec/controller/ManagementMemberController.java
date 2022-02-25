package net.koreate.sec.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.koreate.sec.service.MemberService;
import net.koreate.sec.vo.ValidationMemberVO;

@Controller
@RequestMapping("/mngt/*")
public class ManagementMemberController {
	
	@Inject
	MemberService ms;
	
	@GetMapping("main")
	public void main(Model model) throws Exception {
		List<ValidationMemberVO> memberList
			= ms.getMemberList();
		model.addAttribute("memberList",memberList);
	}
}








