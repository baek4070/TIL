package c2_set;

public class Member {

	
	private String name;
	private int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {
			Member m = (Member)obj;
			if (m.name.equals(this.name)) {
				return true;
			}
			
		}
		return false;
	}

	@Override
	public int hashCode() {
		return age;
	}
	
}
