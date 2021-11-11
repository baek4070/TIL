package member;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.MemberDAO;
import util.DBHelper;

public class MemberDAOImpl implements MemberDAO {

	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	CallableStatement cstmt;
	ResultSet rs;
	
	// Member 정보를 넘겨받아서 회원가입을 진행하고
	// 가입된 회원의 정보를 Member type으로 반환
	@Override
	public Member join(Member member) {
		Member m = null;
		
		conn = DBHelper.getConnection();
		try {
//			String sql = "INSERT INTO tbl_member(mName,mId,mPw,reg) "
//					+" VALUES(?,?,?,?)";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, member.getmName());
//			pstmt.setString(2, member.getmId());
//			pstmt.setString(3, member.getmPw());
//			pstmt.setLong(4, System.currentTimeMillis());
//			pstmt.executeUpdate();
//			
//			// LAST_INSERT_ID() -- 가장 최근에 등록된 기본 키값
//			sql = "SELECT * FROM tbl_member WHERE mNum = LAST_INSERT_ID()";
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
//			if(rs.next()) {
//				int mNum = rs.getInt(1);
//				String mName = rs.getString(2);
//				String mId = rs.getString(3);
//				String mPw = rs.getString(4);
//				long reg = rs.getLong(5);
//				m = new Member(mNum,mName,mId,mPw,reg);
//			}
			//프로시저를 통해 위의 코드를 통합 ! 
			cstmt = conn.prepareCall("CALL insert_member(?,?,?,?)");
			cstmt.setString(1, member.getmName());
			cstmt.setString(2, member.getmId());
			cstmt.setString(3, member.getmPw());
			cstmt.setLong(4, System.currentTimeMillis());
			rs = cstmt.executeQuery();
			if (rs.next()) {
				m = new Member(
					rs.getInt(1),		//mNum
					rs.getString(2),	//mName
					rs.getString(3),	//mId
					rs.getString(4),	//mPw
					rs.getLong(5)		//reg
					);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			DBHelper.close(rs,stmt,pstmt);
			DBHelper.close(rs,cstmt);
		}
		return m;
	}
	// 로그인 - id 와 pw 가 일치하는 사용자 일시 정보 전달
	@Override
	public Member selectMember(String mId, String mPw) {
		Member member = null;
		String sql = "SELECT * FROM tbl_member WHERE mId = ? AND mPw = ?";
		conn = DBHelper.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setString(2, mPw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member(
							rs.getInt("mNum"),
							rs.getString("mName"),
							rs.getString("mId"),
							rs.getString("mPw"),
							rs.getLong("reg")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, pstmt);
		}
		return member;
	}
	// 회원번호로 회원 정보 검색
	@Override
	public Member selectMember(int mNum) {
		Member member = null;
		
		String sql = "SELECT * FROM tbl_member WHERE mNum = ?";
		conn = DBHelper.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new Member();
				member.setmNum(rs.getInt(1));
				member.setmName(rs.getString(2));
				member.setmId(rs.getString(3));
				member.setmPw(rs.getString(4));
				member.setReg(rs.getLong(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs,pstmt);
		}
		return member;
	}

	// 기존에 동일한 아이디가 존재하는지 확인
	// true 사용가능 - 아이디가 존재하지 않으면
	// false 사용불가 - 아이디가 존재하면
	@Override
	public boolean selectMember(String mId) {
		boolean isChecked = true;
		conn = DBHelper.getConnection();
		try {
			pstmt = conn.prepareStatement(
						"SELECT * FROM tbl_member WHERE mId = ?"
					);
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();
			if(rs.next()) isChecked = false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs,pstmt);
		}
		return isChecked;
	}
	// 전체 회원 목록을 ArrayList에 담아서 반환
	
	@Override
	public ArrayList<Member> select() {
		ArrayList<Member> members = new ArrayList<>();
		conn = DBHelper.getConnection();
		String sql = "SELECT * FROM tbl_member ORDER BY mNum DESC";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Member member = new Member(
							rs.getInt("mNum"),
							rs.getString("mName"),
							rs.getString("mId"),
							rs.getString("mPw"),
							rs.getLong("reg")
						);
				members.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt);
		}
		return members;
	}
	//mNum 일치하는 사용자의 회원이름 정보 수정
	@Override
	public int update(Member member) {
		int result = 0;
		String sql = "UPDATE tbl_member SET mName = ? WHERE mNum = ?";
		conn = DBHelper.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getmName());
			pstmt.setInt(2, member.getmNum());
			result = pstmt.executeUpdate(); //수정된 행의갯수 반환
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
		}
		return result; // 항상 첫번째로 반환값에 대해서 생각하자
	}
	// 회원 탈퇴 - 정보 삭제
	@Override
	public int delete(int mNum) {
		int result = 0;
		
		conn = DBHelper.getConnection();
		
		Member member = selectMember(mNum);
				
//		String sql = "INSERT INTO back_up_member(mNum,mName,mId,mPw,reg) VALUES(?,?,?,?,?)";
		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, member.getmNum());
//			pstmt.setString(2, member.getmName());
//			pstmt.setString(3, member.getmId());
//			pstmt.setString(4, member.getmPw());
//			pstmt.setLong(5, member.getRealReg());
//			pstmt.executeUpdate();
//			DBHelper.close(pstmt);
			
			String sql = "DELETE FROM tbl_member WHERE mNum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mNum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
		}
		return result;
	}

}

