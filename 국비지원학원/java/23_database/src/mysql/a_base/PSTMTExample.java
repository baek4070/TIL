package mysql.a_base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PSTMTExample {

	public static void main(String[] args) {
		String driver ="com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/smart";
		String user = "smart";
		String password = "12345";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결 성공 ");
			
			String sql = "INSERT INTO student(stuName,stuDept,stuGrade) "
						+" VALUES(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "최기근");
			pstmt.setString(2, "Developer");
			pstmt.setInt(3, 4);
			
			int result = pstmt.executeUpdate();
			System.out.println(result+"명의 정보 추가");
			
			pstmt.close();
			// import java.util.Scanner;
			Scanner sc = new Scanner(System.in);
			System.out.println("검색할 학생의 번호를 입력하세요.");
			int no = sc.nextInt();
			sql = "SELECT * FROM student WHERE stuNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("검색된 행의 결과가 존재하면");
				String stuName = rs.getString("stuName");
				String stuDept = rs.getString("stuDept");
				int stuGrade = rs.getInt("stugrade");
				char stuGender = rs.getString("stuGender").charAt(0);
				System.out.println(
					stuName+"-"+stuDept+"-"+stuGrade+"-"+stuGender
				);
			}
			
			
			
			
			
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER class를 찾지 못함");
		} catch (SQLException e) {
			System.out.println("연결 정보 오류 :" +e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
		
	}

}





