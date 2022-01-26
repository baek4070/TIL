package net.koreate.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import net.koreate.comment.vo.CommentVO;
import net.koreate.mvc.common.util.Criteria;

public interface CommentDAO {
	
	@Select("SELECT * FROM tbl_comment WHERE bno = #{bno}")
	List<CommentVO> commentList(int bno)throws Exception;
	
	int add(CommentVO vo)throws Exception;
	
	int update(CommentVO vo) throws Exception;
	
	int delete(int cno) throws Exception;
	
	List<CommentVO> listPage(
			@Param("bno") int bno, 
			@Param("cri") Criteria cri) throws Exception;
}












