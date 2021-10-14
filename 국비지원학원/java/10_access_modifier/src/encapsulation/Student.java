package encapsulation;

public class Student {
	public String name;	//이름
	private int age;			//나이
	private int grade;		//학년
	
	
	
	public Student() {
		super();
	}

	public void setAge(int age) {
		if (age < 1) {
			this.age = 1;
			return;
		}
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public String toString() {
		return "Student [name=" + name + ",  age=" + age + ", grade=" + grade + "]";
	}
	
}
	


