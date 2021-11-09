package mysql.b_book.stmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import mysql.b_book.BookVO;
import mysql.dao.BookDAO;

public class BookSTMTDAOImpl implements BookDAO {
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public BookSTMTDAOImpl() {
		// connection 연결 정보 초기화
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/smart",
					"smart","12345");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 정보 없음");
		} catch (SQLException e) {
			System.out.println("연결정보 오류 : " + e.getMessage());
		}
	}

	@Override
	public int insert(BookVO book) {
		int result = 0;
		
		try {
			stmt = conn.createStatement();
			String sql = "INSERT INTO tbl_book(title,author) "
					+ " VALUES('"+book.getTitle()+"','"+book.getAuthor()+"')";
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("query 오류 : " + e.getMessage());
		} finally {
			try {
				if(stmt != null) stmt.close();
			} catch (SQLException e) {}
		}
		return result;
	}

	@Override
	public ArrayList<BookVO> select() {
		ArrayList<BookVO> books = new ArrayList<>();
		
		try {
			stmt = conn.createStatement();
			String sql ="SELECT * FROM tbl_book ORDER BY num DESC";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String author = rs.getString("author");
				Date regdate = rs.getTimestamp("regdate");
				BookVO book = new BookVO(num,title,author,regdate);
				books.add(book);
			}
		} catch (SQLException e) {
			System.out.println("query 오류");
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			} catch (SQLException e) {}
		}
		return books;
	}

	@Override
	public int update(BookVO book) {
		int result = 0;
		
		try {
			stmt = conn.createStatement();
			String sql = "UPDATE tbl_book SET "
					+ " title = '"+book.getTitle()+"' ,"
					+ " author = '"+book.getAuthor()+"' "
					+ " WHERE num = "+book.getNum();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("query 오류");
		} finally{
			try {
				if(stmt != null) stmt.close();
			} catch (SQLException e) {}
		}
		return result;
	}

	@Override
	public BookVO selectBook(int num) {
		BookVO book = null;
		
		try {
			stmt = conn.createStatement();
			String sql ="SELECT * FROM tbl_book WHERE num = "+num;
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				book = new BookVO(
							rs.getInt(1),		//num
							rs.getString(2),	//title
							rs.getString(3),	//author
							rs.getTimestamp(4)	//regdate
						);
			}
		} catch (SQLException e) {
			System.out.println("query 오류");
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			} catch (SQLException e) {}
		}
		return book;
	}

	@Override
	public int delete(int num) {
		int result = 0;
		try {
			String sql = "DELETE FROM tbl_book WHERE num="+num;
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("query 오류 : " + e.getMessage());
		} finally {
			try {
				if(stmt!=null) stmt.close();
			} catch (SQLException e) {}
		}
		return result;
	}

}




