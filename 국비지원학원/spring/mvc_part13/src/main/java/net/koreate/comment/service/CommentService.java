package net.koreate.comment.service;

import java.util.Map;

import net.koreate.comment.vo.CommentVO;

public interface CommentService {
	
	// 댓글 삽입
	void addComment(CommentVO vo) throws Exception;
	
	// 댓글 리스트 및 페이징 정보
	// List<CommentVO> PageMaker
	// 상세보기 페이지 갔을떄 해당되는 게시물의 번호를 (필요)알아야 한다
	// 그래서 매개변수로 어떤 게시물인지 페이지인지 로 설정
	Map<String,Object> listPage(int bno, int page) throws Exception;
	
	//댓글 수정
	void modifyComment(CommentVO vo) throws Exception;
	
	// 댓글 삭제
	void removeComment(int cno) throws Exception;
}
