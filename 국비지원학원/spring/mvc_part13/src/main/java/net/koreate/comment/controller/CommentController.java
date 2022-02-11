package net.koreate.comment.controller;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.koreate.comment.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	@Inject
	CommentService cs;
	
	//댓글 목록 출력
	//int bno, int page
	//comments/bno/page
	//commets/1/1
	//commets/2/1
	@GetMapping("/{bno}/{page}")
	public ResponseEntity<Map<String,Object>> listPage(
				@PathVariable("bno") int bno,
				@PathVariable("page") int page
			){
		ResponseEntity<Map<String,Object>> entity = null;
		
		try {
			Map<String,Object> map = cs.listPage(bno, page);
			entity = new ResponseEntity<>(map,HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
}
