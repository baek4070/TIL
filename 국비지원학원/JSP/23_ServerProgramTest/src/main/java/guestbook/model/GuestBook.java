package guestbook.model;

public class GuestBook {

	private String guestName;
	private String password;
	private String message;
	
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "GuestBook [guestName=" + guestName + ", password=" + password + ", message=" + message + "]";
	}
	
	
}
