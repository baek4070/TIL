package dao;

import java.util.ArrayList;

import util.Criteria;
import vo.CommentVO;

public class CommentDAOImpl implements CommentDAO {

	@Override
	public boolean insertComment(CommentVO vo) {
		return false;
	}

	@Override
	public int getCommentTotalCount(int qna_num) {
		return 0;
	}

	@Override
	public ArrayList<CommentVO> getCommentList(int qna_num, Criteria cri) {
		return null;
	}

	@Override
	public boolean deleteComment(int comment_num, String id) {
		return false;
	}

}
