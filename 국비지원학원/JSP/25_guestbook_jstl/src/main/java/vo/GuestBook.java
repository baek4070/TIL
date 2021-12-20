package vo;

public class GuestBook {
	private int id;
	private String guestName;
	private String password;
	private String message;
	
	// useBean 용
	public GuestBook() {
	}
	// List 용
	public GuestBook(int id, String guestName, String password, String message) {
		this.id = id;
		this.guestName = guestName;
		this.password = password;
		this.message = message;
	}
	//getter & setter &toString
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
		return "GuestBook [id=" + id + ", guestName=" + guestName + ", password=" + password + ", message=" + message
				+ "]";
	}


}


