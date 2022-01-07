package vo;

import java.util.Date;

public class BoardVO {
	private int qna_num;				//글번호
	private String qna_name;			//작성자
	private String qna_title;			//글제목
	private String qna_content;			//글내용
	private String qna_file;			//저장된 파일 이름
	private String  qna_file_origin;	//원본 파일 이름
	private int qna_re_ref;				//원본 글 번호
	private int qna_re_lev;				//답변글 view 번호
	private int qna_re_seq;				//답변글 정렬 번호
	private int qna_writer_num;			//글 작성자 번호 FOREIGN KEY(qna_writer_num) REFERENCES mvc_member(num)
	private int qna_readcount;			//조회수
	private String qna_delete;			//삭제 여부
	private Date qna_date;				//작성 시간
	
	// getter setter toString
	
	public int getQna_num() {
		return qna_num;
	}
	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}
	public String getQna_name() {
		return qna_name;
	}
	public void setQna_name(String qna_name) {
		this.qna_name = qna_name;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public String getQna_file() {
		return qna_file;
	}
	public void setQna_file(String qna_file) {
		this.qna_file = qna_file;
	}
	public String getQna_file_origin() {
		return qna_file_origin;
	}
	public void setQna_file_origin(String qna_file_origin) {
		this.qna_file_origin = qna_file_origin;
	}
	public int getQna_re_ref() {
		return qna_re_ref;
	}
	public void setQna_re_ref(int qna_re_ref) {
		this.qna_re_ref = qna_re_ref;
	}
	public int getQna_re_lev() {
		return qna_re_lev;
	}
	public void setQna_re_lev(int qna_re_lev) {
		this.qna_re_lev = qna_re_lev;
	}
	public int getQna_re_seq() {
		return qna_re_seq;
	}
	public void setQna_re_seq(int qna_re_seq) {
		this.qna_re_seq = qna_re_seq;
	}
	public int getQna_writer_num() {
		return qna_writer_num;
	}
	public void setQna_writer_num(int qna_writer_num) {
		this.qna_writer_num = qna_writer_num;
	}
	public int getQna_readcount() {
		return qna_readcount;
	}
	public void setQna_readcount(int qna_readcount) {
		this.qna_readcount = qna_readcount;
	}
	public String getQna_delete() {
		return qna_delete;
	}
	public void setQna_delete(String qna_delete) {
		this.qna_delete = qna_delete;
	}
	public Date getQna_date() {
		return qna_date;
	}
	public void setQna_date(Date qna_date) {
		this.qna_date = qna_date;
	}
	@Override
	public String toString() {
		return "BoardVO [qna_num=" + qna_num + ", qna_name=" + qna_name + ", qna_title=" + qna_title + ", qna_content="
				+ qna_content + ", qna_file=" + qna_file + ", qna_file_origin=" + qna_file_origin + ", qna_re_ref="
				+ qna_re_ref + ", qna_re_lev=" + qna_re_lev + ", qna_re_seq=" + qna_re_seq + ", qna_writer_num="
				+ qna_writer_num + ", qna_readcount=" + qna_readcount + ", qna_delete=" + qna_delete + ", qna_date="
				+ qna_date + "]";
	}
	
}
