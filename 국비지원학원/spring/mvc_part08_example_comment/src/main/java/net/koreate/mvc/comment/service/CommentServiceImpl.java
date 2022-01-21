package net.koreate.mvc.comment.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.koreate.mvc.comment.dao.CommentDAO;
import net.koreate.mvc.comment.vo.CommentVO;
import net.koreate.mvc.common.util.Criteria;
import net.koreate.mvc.common.util.PageMaker;

@Service
public class CommentServiceImpl implements CommentService<CommentVO,PageMaker,Criteria> {

	@Inject
	CommentDAO dao;
	
	@Override
	public String addComment(CommentVO vo) throws Exception {
		int result = dao.addComment(vo);
		System.out.println(result);
		return result > 0 ? "SUCCESS" : "FAIL";
	}

	@Override
	public String delete(int cno) throws Exception {
		return null;
	}

	@Override
	public PageMaker getPageMaker(Criteria cri, int bno) throws Exception {
		return null;
	}

	@Override
	public List<CommentVO> commentListPage(int bno, Criteria cri) throws Exception {
		Map<String,Object> map = new HashMap();
		map.put("bno", bno);
		map.put("cri", cri);
		List<CommentVO> list = dao.listPage(map);
		
		return list;
	}

}
