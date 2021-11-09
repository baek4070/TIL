package mysql.b_book;

import java.util.Date;

public class BookVO {
	
	public BookVO() {
	}
	// 등록용
	public BookVO(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}
	// 수정용
	public BookVO(int num, String title, String author) {
		this.num = num;
		this.title = title;
		this.author = author;
	}
	// 검색용
	public BookVO(int num, String title, String author, Date regdate) {
		this.num = num;
		this.title = title;
		this.author = author;
		this.regdate = regdate;
	}


	// 도서관리번호
	private int num;
	// 제목
	private String title;
	//작성자
	private String author;
	// 도서 등록일 java.util.Date
	private Date regdate;
	
	//getter & setter & toString
	// alt+ s + r     alt + s+ s+ s
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public Date getRegdate() {
		return regdate;
	}
}
