package a.object.clone;
					// Cloneable 은 기능이 하나도 없음 클론 허용용 마크용 인터페이스
public class Member implements Cloneable{

	public String name;
	
	public int age;
	
	public int[] score;
	
	public Car car;
	
	public Member(String name, int age, int[] score, Car car) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
		this.car = car;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", score=" + score + ", car=" + car + "]";
	}
	
	public Member getMember() {
		Member cloned = null;
		try {
			
			cloned = (Member)super.clone();
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return cloned;
	}
	
}
