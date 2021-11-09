package mysql.b_book;

import java.util.ArrayList;
import java.util.Scanner;

import mysql.b_book.pstmt.BookPSTMTDAOImpl;
import mysql.dao.BookDAO;

public class BookManagement {
	// 문자열 입력
	Scanner scLine = new Scanner(System.in);
	// 선택번호 입력
	Scanner scInt = new Scanner(System.in);
	// 프로그램 실행 종료
	boolean isRun = true;
	// 선택번호 저장
	int selectNo;
	
	BookDAO dao;
	
	BookManagement(BookDAO dao){
		this.dao = dao;
		run();
	}
	
	public void run() {
		while(isRun) {
			System.out.println("=========================================");
			System.out.println("1.도서등록|2.도서목록|3.도서수정|4.도서삭제|5.종료");
			System.out.println("=========================================");
			selectNo = getNum("번호를 입력하세요 > ");
			switch(selectNo) {
				case 1 : 
					System.out.println("1. 도서등록");
					registerBook();
					break;
				case 2 : 
					System.out.println("2. 도서목록");
					selectBook();
					break;
				case 3 : 
					System.out.println("3. 도서수정");
					updateBook();
					break;
				case 4 : 
					System.out.println("4. 도서삭제");
					deleteBook();
					break;
				case 5 : 
					System.out.println("5. 종료");
					isRun = false;
					break;
				default :
					System.out.println("선택하신 번호는 없습니다.");
			}
		}
	}
	
	private void registerBook() {
		String title = getData("등록할 도서의 책제목을 입력해주세요 > ");
		String author = getData("등록할 도서의 저자를 입력해주세요 > ");
		/*
		BookVO vo = new BookVO();
		vo.setTitle(title);
		vo.setAuthor(author);
		int result = dao.insert(vo);
		*/
		int result = dao.insert(new BookVO(title,author));
		if(result > 0) {
			System.out.println("등록완료");
		}else {
			System.out.println("등록실패");
		}
	}
	
	private void selectBook() {
		ArrayList<BookVO> books = dao.select();
		for(BookVO b : books) {
			System.out.println(b);
		}
	}
	
	private void updateBook() {
		int bookNum = getNum("수정하실 도서의 관리번호를 입력하세요.");
		BookVO b = dao.selectBook(bookNum);
		if(b == null) {
			System.out.println("입력하신 번호의 책이 존재하지 않습니다.");
			return;
		}
		
		boolean isUpdate = true;
		while(isUpdate) {
			System.out.println("==========================");
			System.out.println("1.제목수정|2.저자수정|3.수정완료");
			System.out.println("==========================");
			
			selectNo = getNum("번호 입력 > ");
			switch(selectNo) {
				case 1:
					System.out.println("제목 수정");
					String title = getData("제목 입력>");
					b.setTitle(title);
					break;
				case 2:
					System.out.println("저자 수정");
					String author = getData("저자 입력>");
					b.setAuthor(author);
					break;
				case 3:
					System.out.println("수정완료");
					dao.update(b);
					isUpdate = false;
					break;
			}
			
		} // while 종료
	}
	
	private void deleteBook() {
		int bookNum = getNum("삭제할 도서의 관리번호를 입력해 주세요.");
		int result = dao.delete(bookNum);
		if(result > 0) {
			System.out.println("삭제 완료");
		}else {
			System.out.println("입력하신 관리번호의 책이 존재하지않습니다.");
		}
	}
	
	public String getData(String message) {
		System.out.println(message);
		return scLine.nextLine();
	}
	
	// message를 전달 받아 출력하고
	// 사용자에게 정수를 입력 받아 반환
	public int getNum(String message) {
		System.out.println(message);
		if(!scInt.hasNextInt()) {
			scInt.next();
			return 0;
		}
		return scInt.nextInt();
	}
	
	public static void main(String[] args) {
		//new BookManagement(new BookSTMTDAOImpl());	
		new BookManagement(new BookPSTMTDAOImpl());
	}
}












