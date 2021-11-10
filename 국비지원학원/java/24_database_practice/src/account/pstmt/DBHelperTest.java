package account.pstmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import util.DBHelper;

public class DBHelperTest {

	public static void main(String[] args) throws SQLException {
		Connection conn = DBHelper.getConnection();
		System.out.println("연결 성공 : " +conn);
		Connection conn2 = DBHelper.getConnection();
		System.out.println("연결 성공 : " +conn2);
		//한개의 커넥션 객체를 공유하는걸 확인 !!!  그러므로 DAO 클래스를 생성하더라도 Helper 클래스로 정보만 받아오면 된다 
		Statement stmt = conn.createStatement();
		PreparedStatement pstmt = conn.prepareStatement("");
		DBHelper.close(stmt,pstmt,conn2);
		
//		DBHelper.close(pstmt);
//		DBHelper.close(stmt);
//		DBHelper.close(conn2);
		
		try {
			if(conn2 != null) {
				conn2.close();
			}
		} catch (SQLException e) {}
	}

}
