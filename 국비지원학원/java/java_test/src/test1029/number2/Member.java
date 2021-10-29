package test1029.number2;

public class Member {

	private String id;
	private String password;
	private String name;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {
			Member member =(Member)obj;
			if(member.getId().equals(this.id) && member.getPassword().equals(this.password)) {
				return true;
			}
		}
		return false;
	}
	
	
}
