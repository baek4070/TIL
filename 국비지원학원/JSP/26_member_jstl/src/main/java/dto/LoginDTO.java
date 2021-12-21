package dto;

public class LoginDTO {

	private String u_id;
	private String u_pass;
	private String login;
	
	// getter & setter & toString 
	
	
	@Override
	public String toString() {
		return "LoginDTO [u_id=" + u_id + ", u_pass=" + u_pass + ", login=" + login + "]";
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_pass() {
		return u_pass;
	}

	public void setU_pass(String u_pass) {
		this.u_pass = u_pass;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	
}
