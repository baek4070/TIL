package f.polymorphism;

public class Teacher extends Person{
	
	String tNumber; //교번
	String subject; //담당 교과목
	String grade; 	//담당 학년
	public Teacher(
			String name, 
			int age, 
			int height, 
			String tNumber, 
			String subject, 
			String grade) {
		super(name, age, height);
		this.tNumber = tNumber;
		this.subject = subject;
		this.grade = grade;
	}
	
	public void teach() {
		System.out.println(super.name+"은 "+this.subject+"를 가르칩니다.");
	}

	@Override
	public String toString() {
		return "Teacher [tNumber=" + tNumber + ", subject=" + subject + ", grade=" + grade + ", name=" + name + ", age="
				+ age + ", height=" + height + "]";
	}
	
	
}
