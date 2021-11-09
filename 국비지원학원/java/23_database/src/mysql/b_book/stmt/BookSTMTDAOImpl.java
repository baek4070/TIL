package mysql.b_book.stmt;

import java.util.ArrayList;

import mysql.b_book.BookVO;
import mysql.dao.BookDAO;

public class BookSTMTDAOImpl implements BookDAO {

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
