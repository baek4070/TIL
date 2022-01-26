package net.koreate.comment.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.koreate.comment.dao.CommentDAO;
import net.koreate.comment.vo.CommentVO;
import net.koreate.mvc.common.util.Criteria;
import net.koreate.mvc.common.util.PageMaker;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Inject
	CommentDAO dao;

	@Override
	public List<CommentVO> commentList(int bno) throws Exception {
		return dao.commentList(bno);
	}

	@Override
	public String addComment(CommentVO vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateComment(CommentVO vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteComment(int cno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentVO> commentListPage(int bno, Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageMaker getPageMaker(Criteria cri, int bno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
