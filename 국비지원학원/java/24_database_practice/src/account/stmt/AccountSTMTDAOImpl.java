package account.stmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import account.Account;
import dao.AccountDAO;

// Account
// Statement
// Database Access Object
public class AccountSTMTDAOImpl implements AccountDAO{
	// DBMS 연결 객체
	private Connection conn;
	// 연결정보를 가지고 질의를 실행하는 객체
	private Statement stmt;
	// 검색질의의 결과를 전달받는 객체
	private ResultSet rs;
	
	public AccountSTMTDAOImpl () {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/smart";
			String user = "smart";
			String password = "12345";
//			conn = DriverManager.getConnection(url, user, password);
//			conn = DriverManager.getConnection(url+"?user="+user+"&password="+password);
			Properties prop = new Properties();
			prop.setProperty("user", user);
			prop.setProperty("password", password);
			conn = DriverManager.getConnection(url,prop);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver class를 찾을수 없음");
		} catch (SQLException e) {
			System.out.println("연결 정보 오류 : "+ e.getMessage());
		}
	}
	// account 의 정보를 tbl_accounst table에 삽입
	@Override
	public void insert(Account account) {
		
		try {
			stmt = conn.createStatement();
			String sql="INSERT INTO tbl_account "
					+"VALUES('"+ account.getAno()+"','"
					+account.getOwner()+"',"
					+account.getBalance()+",'"
					+account.getPassword()+"')";
			stmt.execute(sql);
		} catch (SQLException e) { 
			System.out.println("query 오류 : " + e.getMessage());
		} finally {
			try {
				if (stmt != null) stmt.close();
			} catch (SQLException e) {}
				
		}
		
	}
	//계좌번호가 일치하느 계좌주의
	// 잔고를 수 정
	// UPDATE tbl_account SET balance = 값 WHERE ano = '계좌번호'
	@Override
	public int update(Account account) {
		int result = 0;
		
		try {
			String sql = "UPDATE tbl_account SET balance ="+account.getBalance()+" WHERE ano = '"
					+account.getAno()+"'";
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Query 오류: "+ e.getMessage());
		} finally {
			try {
				if (stmt != null) stmt.close();
			} catch (SQLException e) {}
		}
		
		return result;
	}
	// SELECT * FROM tbl_account WHERE ano = '계좌번호';
	@Override
	public Account selectAccount(String ano) {
		Account acc = null;
		String sql ="SELECT * FROM tbl_account WHERE ano = '"+ano+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				acc = new Account(
						rs.getString(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getString(4)
						);
			}
		} catch (SQLException e) {
			System.out.println("Query 오류 :"+ e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
			} catch (SQLException e) {}
		}
		return acc;
	}
	//SELECT * FROM tbl_account
	// WHERE ano ='계좌번호' AND password = '비밀번호';
	@Override
	public Account selectAccount(String ano, String password) {
		Account acc = null;
		String sql = "SELECT * FROM tbl_account WHERE ano ='"+ano+"' AND password = '"+password+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				acc = new Account(
						rs.getString("ano"),
						rs.getString("owner"),
						rs.getInt("balance"),
						rs.getString("password")
						);
			}
		} catch (SQLException e) {
		}finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
			} catch (SQLException e) {}
		}
		return acc;
	}
	
	

}
