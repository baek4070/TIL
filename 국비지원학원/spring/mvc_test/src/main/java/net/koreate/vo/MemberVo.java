package net.koreate.vo;

import java.util.Date;

import lombok.Data;
@Data
public class MemberVo {

	private String userid;
	private String userpw;
	private String username;
	private String emeil;
	private Date regdate;
	private Date updatedate;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmeil() {
		return emeil;
	}
	public void setEmeil(String emeil) {
		this.emeil = emeil;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	@Override
	public String toString() {
		return "MemberVo [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", emeil=" + emeil
				+ ", regdate=" + regdate + ", updatedate=" + updatedate + "]";
	}
	
	
}
