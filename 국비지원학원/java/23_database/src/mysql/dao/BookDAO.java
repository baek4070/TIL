package mysql.dao;

import java.util.ArrayList;

import mysql.b_book.BookVO;

// DataBase Access Object
public interface BookDAO {
	// 도서 삽입
	int insert(BookVO book);
	
	// 도서 목록
	ArrayList<BookVO> select();
	
	// 도서 정보 수정
	int update(BookVO book);
	
	// 책번호 Book 정보를 검색
	BookVO selectBook(int num);
	
	// 삭제
	int delete(int num);
}









