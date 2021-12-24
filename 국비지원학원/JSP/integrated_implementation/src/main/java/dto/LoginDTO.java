package dto;

public class LoginDTO {

	private String id;
	private String pass;
	private String login;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	@Override
	public String toString() {
		return "LoginDTO [id=" + id + ", login=" + login + "]";
	}
	
	
}
