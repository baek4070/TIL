package vo;

import java.util.Date;

public class TestBoardVO {
	private String board_name;
	private String board_pass;
	private String board_title;
	private String board_content;
	private int board_readcount;
	private Date board_date;
	
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getBoard_pass() {
		return board_pass;
	}
	public void setBoard_pass(String board_pass) {
		this.board_pass = board_pass;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public int getBoard_readcount() {
		return board_readcount;
	}
	public void setBoard_readcount(int board_readcount) {
		this.board_readcount = board_readcount;
	}
	public Date getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}
	@Override
	public String toString() {
		return "TestBoardVO [board_name=" + board_name + ", board_pass=" + board_pass + ", board_title=" + board_title
				+ ", board_content=" + board_content + ", board_readcount=" + board_readcount + ", board_date="
				+ board_date + "]";
	}
	
	
}
