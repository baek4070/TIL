package mysql.b_book.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mysql.b_book.BookVO;
import mysql.dao.BookDAO;

public class BookPSTMTDAOImpl implements BookDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	
	
	
	
	public BookPSTMTDAOImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/smart",
					"smart", "12345");
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {}
	}

	@Override
	public int insert(BookVO book) {
		return 0;
	}

	@Override
	public ArrayList<BookVO> select() {
		return null;
	}

	@Override
	public int update(BookVO book) {
		return 0;
	}

	@Override
	public BookVO selectBook(int num) {
		return null;
	}

	@Override
	public int delete(int num) {
		return 0;
	}

}
