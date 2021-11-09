package mysql.a_base;

import java.sql.*;

public class DataBaseExample {
	
	public int a;
	
	static {
		System.out.println("1 static 블럭 실행");
	}
	
	{
		a = 100; 
		System.out.println("3 실행 블럭 run");
	}
	
	DataBaseExample(){
		System.out.println("4 a : "+a);
	}
	
	public static void main(String[] args) {
		System.out.println("2 Main 시작");
		new DataBaseExample();
		
		// DB 연결 정보 - Java DataBase Connectivity
		// Driver Class 위치 정보
		// 사용할 DB와 Schema 정보
		// 사용자 계정 정보
		String driver = "com.mysql.cj.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/smartWeb";
		String username = "root";
		String password = "12345";
		// import java.sql.*;
		// database와 연결된 정보를 가진 객체
		Connection conn = null; 
		//연결 정보를 가지고 질의 전송을 도와주는 객체
		Statement stmt = null;	
		
		try {
			//Class.forName(driver);
			System.out.println("Driver Load 완료");
			conn = DriverManager.getConnection(
							url, username, password
						);
			System.out.println("DB 연결 완료 : " + conn);
			
			stmt = conn.createStatement();
			
			String sql ="SELECT * FROM emp";
			// 매개변수로 넘겨받은 질의를 실행
			// ResultSet 검색 질의에 대한 결과를 저장하는 객체
			ResultSet rs = stmt.executeQuery(sql);
			// rs.next() 행단위로 이동
			// 이동할 행이 존재하지않으면 false
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString(2);
				String job = rs.getString(3);
				int mgr = rs.getInt(4);
				java.util.Date hiredate = rs.getTimestamp(5);
				int sal = rs.getInt(6);
				int comm = rs.getInt(7);
				int deptno = rs.getInt(8);
				System.out.println(empno+":"+ename);
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}





