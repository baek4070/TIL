package mysql.b_book;

import java.util.Date;

// Book Value Object
public class BookVO {
	
	// 도서관리번호
	private int num;
	// 제목
	private String title;
	// 작성자
	private String author;
	// 도서 등록일 java.util.Date
	private Date regdate;
	
	public BookVO() {}
	// 등록용
	public BookVO(String title, String author) {
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

	// getter & setter & toString
	// alt + s + r       alt+s+s+s 
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "BookVO [num=" + num + ", title=" + title + ", author=" + author + ", regdate=" + regdate + "]";
	}
}
