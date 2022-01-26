package net.koreate.comment.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.koreate.comment.service.CommentService;
import net.koreate.comment.vo.CommentVO;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	@Inject
	CommentService cs;
	
	// comments/all/bno
	@GetMapping("/all/{bno}")
	public ResponseEntity<List<CommentVO>> list(
			@PathVariable(name="bno") int bno){
		ResponseEntity<List<CommentVO>> entity = null;
		System.out.println("bno : " + bno);
		try {
			List<CommentVO> list = cs.commentList(bno);
			entity = new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
}










