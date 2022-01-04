package service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QNABoardDAO;
import dao.QNABoardDAOImpl;
import util.Criteria;
import vo.BoardVO;

public class QNABoardServiceImpl implements QNABoardService {
	
	QNABoardDAO dao = new QNABoardDAOImpl();

	@Override
	public ArrayList<BoardVO> getBoardList(HttpServletRequest request) {
		String page = request.getParameter("page");
		int paramPage = 1;
		if(page != null) {
			paramPage = Integer.parseInt(page);
		}
		// qna_board 전체 게시물 수 검색
		int totalCount = dao.getTotalCount();
		System.out.println("totalCount : " + totalCount);
		
		Criteria cri = new Criteria(paramPage, 10);
		ArrayList<BoardVO> list = dao.getBoardList(cri);
		return list;
	}

	@Override
	public void boardWrite(HttpServletRequest request) {
		String qna_name = request.getParameter("qna_name");
		int qna_writer_num = Integer.parseInt(
			request.getParameter("qna_writer_num")
		);
		String qna_title = request.getParameter("qna_title");
		String qna_content = request.getParameter("qna_content");
		
		BoardVO board = new BoardVO();
		board.setQna_name(qna_name);
		board.setQna_writer_num(qna_writer_num);
		board.setQna_title(qna_title);
		board.setQna_content(qna_content);
		
		dao.boardWrite(board);
	}

	@Override
	public void boardWriteFile(HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

	@Override
	public BoardVO getBoardVO(HttpServletRequest request) {
		int qna_num 
		= Integer.parseInt(request.getParameter("qna_num"));
		return dao.getBoardVO(qna_num);
	}

	@Override
	public void updateReadCount(HttpServletRequest request) {
		int qna_num 
		= Integer.parseInt(request.getParameter("qna_num"));
		dao.updateReadCount(qna_num);
	}

	@Override
	public void fileDown(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public BoardVO boardReply(HttpServletRequest request) {
		int qna_num = 
			Integer.parseInt(request.getParameter("qna_num"));
		return dao.getBoardVO(qna_num);
	}

	@Override
	public BoardVO boardReplySubmit(HttpServletRequest request) {
		int qna_writer_num = Integer.parseInt(
			request.getParameter("qna_writer_num")
		);
		String qna_name = request.getParameter("qna_name");
		String qna_title = request.getParameter("qna_title");
		String qna_content = request.getParameter("qna_content");
		int qna_re_ref = Integer.parseInt(
				request.getParameter("qna_re_ref")
			);
		int qna_re_lev = Integer.parseInt(
				request.getParameter("qna_re_lev")
			);
		int qna_re_seq = Integer.parseInt(
				request.getParameter("qna_re_seq")
			);
		BoardVO board = new BoardVO();
		board.setQna_name(qna_name);
		board.setQna_title(qna_title);
		board.setQna_content(qna_content);
		board.setQna_re_ref(qna_re_ref);
		board.setQna_re_lev(qna_re_lev);
		board.setQna_re_seq(qna_re_seq);
		board.setQna_writer_num(qna_writer_num);
		System.out.println(board);
		dao.boardReplySubmit(board);
		return null;
	}

	@Override
	public BoardVO getBoardVOByUpdate(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void boardUpdate(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void boardDelete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
