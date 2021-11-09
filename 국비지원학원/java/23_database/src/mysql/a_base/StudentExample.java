package mysql.a_base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentExample {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/smart";
		String user = "smart";
		String password ="12345";
		
		Connection conn = null;
		Statement stmt = null; // SQL문 전달
		ResultSet rs = null;// 행단위로 결과값으 전달
		// 예외 처리할 block 지정후
		// alt + s + w 
		try {
			Class.forName(driver);
			System.out.println("드라이버 클래스 로드 완료");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB연결 성공");
			
			// Connection 객체를 통해 질의를 전송하는 stmt 객체생성
			stmt = conn.createStatement();
//			String sql ="INSERT INTO student(stuName,stuDept,stuGrade,stuClass,stuGender) "
//					+ " VALUES('심현석','컴퓨터정보',1,'B','F')";
//			int result = stmt.executeUpdate(sql);
//			System.out.println("실행된 행의 개수 : " + result);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("이름을 입력해주세요 > ");
			String stuName = sc.next();
			
			System.out.println("학과를 입력해주세요 > ");
			String stuDept = sc.next();
			
			System.out.println("학년을 입력해주세요 > ");
			int stuGrade = sc.nextInt();
			
			String sql = "INSERT INTO student(stuName,stuDept,stuGrade)"
					+"VALUES('"+stuName+"','"+stuDept+"',"+stuGrade+")";
			System.out.println(sql);
			
			int result = stmt.executeUpdate(sql);
			System.out.println(result+"명의 학생정보가 추가되었습니다.");
			
			sql = "UPDATE student SET stuName = '홍길동' " + "WHERE stuNo = 2";
			result = stmt.executeUpdate(sql);
			System.out.println(result+"명의 정보가 수정되었습니다.");
			
			sql = "DELETE FROM student";
			result = stmt.executeUpdate(sql);
			System.out.println(result+"명의 정보가 삭제 되었습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver class가 존재하지 않음");
		} catch (SQLException e) {
			System.out.println("DB 연결 정보 오류"+e.getMessage());
		}
		
	}

}