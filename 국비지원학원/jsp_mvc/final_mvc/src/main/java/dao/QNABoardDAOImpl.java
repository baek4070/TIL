package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.Criteria;
import util.DBCPUtil;
import vo.BoardVO;

public class QNABoardDAOImpl implements QNABoardDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	@Override
	public int getTotalCount() {
		return 0;
	}

	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		return null;
	}

	@Override
	public void boardWrite(BoardVO vo) {
		conn = DBCPUtil.getConnection();
		String sql = "INSERT INTO qna_board "
				+ "VALUES(null,?,?,?,?,?,0,0,0,?,0,'N',now())";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getQna_name());
			pstmt.setString(2, vo.getQna_title());
			pstmt.setString(3, vo.getQna_content());
			pstmt.setString(4, vo.getQna_file());
			pstmt.setString(5, vo.getQna_file_origin());
			pstmt.setInt(6, vo.getQna_writer_num());
			
			pstmt.executeUpdate();
			
			sql = "SELECT LAST_INSERT_ID()";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int qna_num = 0;
			if(rs.next()) {
				qna_num = rs.getInt(1);
			}
			System.out.println("qna_num : " + qna_num);
			
			sql = "UPDATE qna_board SET qna_re_ref = ? WHERE qna_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qna_num);
			pstmt.setInt(2, qna_num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBCPUtil.close(rs,pstmt,conn);
		}

	}

	@Override
	public BoardVO getBoardVO(int qna_num) {
		return null;
	}

	@Override
	public void updateReadCount(int qna_num) {

	}

	@Override
	public void boardReplySubmit(BoardVO board) {

	}

	@Override
	public boolean boardUpdate(BoardVO vo) {
		return false;
	}

	@Override
	public boolean boardDelete(int qna_num, int qna_writer_num) {
		return false;
	}

}
