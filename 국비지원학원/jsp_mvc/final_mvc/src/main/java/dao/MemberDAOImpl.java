package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBCPUtil;
import vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	@Override
	public boolean memberJoin(MemberVO member) {
		conn = DBCPUtil.getConnection();
		String sql = "INSERT INTO mmvc_member(id,pass,name,age,gender) "
				   + " VALUES(?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPass());
			pstmt.setString(3, member.getName());
			pstmt.setInt(4, member.getAge());
			pstmt.setString(5, member.getGender());
			if(pstmt.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.close(pstmt,conn);
		}
		return false;
	}

	@Override
	public MemberVO memberLogin(String id, String pass) {
		MemberVO member = null;
		conn = DBCPUtil.getConnection();
		String sql = "SELECT * FROM mvc_member "
				   + " WHERE id = ? AND pass = ? AND joinYN != 'N' ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new MemberVO(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getInt(5),
					rs.getString(6),
					rs.getString(7),
					rs.getTimestamp(8),
					rs.getTimestamp(9)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCPUtil.close(rs,pstmt,conn);
		}
		
		
		return member;
	}

	@Override
	public boolean memberUpdate(MemberVO member) {
		return false;
	}

	@Override
	public MemberVO getMemberById(String id) {
		return null;
	}

	@Override
	public void withDrawMember(int num) {

	}

	@Override
	public boolean checkMember(String id, String name) {
		return false;
	}

	@Override
	public void addPassCode(String id, String code) {

	}

	@Override
	public boolean checkPassCode(String id, String code) {
		return false;
	}

	@Override
	public void changePass(String id, String pass) {

	}

}
