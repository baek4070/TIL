package net.koreate.mvc.comment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.koreate.mvc.comment.vo.CommentVO;

@Service
public interface CommentService<M,P,C> {
	
	// 댓글 삽입
	String addComment(M commentVO) throws Exception;
	
	// 댓글 삭제
	String delete(int cno)throws Exception;

	// 게시물 번호가 일치하는 댓글 페이지 블럭 정보
	P getPageMaker(C cri, int bno)throws Exception;
	
	// 페이징 처리된 해당 번호의 게시물 댓글 리스트
	List<CommentVO> commentListPage(int bno, C cri) throws Exception;
}












