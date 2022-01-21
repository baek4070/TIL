package net.koreate.mvc.comment.controller;


import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.koreate.mvc.comment.service.CommentService;
import net.koreate.mvc.comment.vo.CommentVO;
import net.koreate.mvc.common.util.Criteria;
import net.koreate.mvc.common.util.PageMaker;

@Controller
@RequestMapping("/comment")
public class CommentController {
	@Inject
	CommentService<CommentVO,PageMaker,Criteria> service;
	
	@PostMapping("/addComment")
	public String addComment(
			int bno,
			CommentVO vo,
			RedirectAttributes rttr)throws Exception{
		// 삽입 성공 여부 전달
		System.out.println(vo);
		String result = service.addComment(vo);
		System.out.println(result);
		rttr.addFlashAttribute("result",result);
		rttr.addAttribute("bno",bno);
		return "redirect:/comment/commentList";
	}
	
	@GetMapping("/commentList")
	public String commentList(int bno, Criteria cri, Model model)throws Exception{
		model.addAttribute("list",service.commentListPage(bno, cri));
		model.addAttribute("pm",service.getPageMaker(cri, bno));
		return "/comment/commentList";
	}
	
	@PostMapping("/commentDelete")
	public String commentDelete(int bno, int  cno,
			RedirectAttributes rttr)throws Exception{
		// 댓글 삭제
		// 삭제 성공 여부 전달
		return "redirect:/comment/commentList";
	}
	
}






