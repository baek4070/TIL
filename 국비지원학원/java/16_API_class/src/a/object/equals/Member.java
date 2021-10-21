package a.object.equals;

public class Member {
	
	private String id;
	
	public Member (String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {
			Member m = (Member)obj;
			if (this.id.equals(m.id)) {
				return true;
			}
		}
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	

}
