package net.koreate.mvc.comment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.koreate.mvc.comment.vo.CommentVO;
import net.koreate.mvc.common.util.Criteria;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	
	
	@PostMapping("/addComment")
	public String addComment(
			int bno,
			CommentVO vo,
			RedirectAttributes rttr)throws Exception{
		// 삽입 성공 여부 전달
		return "redirect:/comment/commentList?${bno}";
	}
	
	@GetMapping("/commentList")
	public String commentList(int bno, Criteria cri)throws Exception{
		// 댓글 목록 및 페이지 블럭 정보
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






