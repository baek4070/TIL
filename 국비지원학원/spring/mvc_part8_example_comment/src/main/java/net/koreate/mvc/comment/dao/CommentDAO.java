package net.koreate.mvc.comment.dao;

import java.util.List;
import java.util.Map;

import net.koreate.mvc.comment.vo.CommentVO;

public interface CommentDAO {
	// 댓글 삽입
	int addComment(CommentVO vo) throws Exception;
	
	// 댓글 삭제
	int delete(int cno)throws Exception;

	// 게시물 번호가 일치하는 댓글의 전체 개수
	int listCount(int bno)throws Exception;
	
	// 페이징 처리된 해당 번호의 게시물 댓글 리스트
	// map에는 게시글 번호와 Criteria 객체가 저장
	List<CommentVO> listPage(Map<String,Object> map) throws Exception;
}





