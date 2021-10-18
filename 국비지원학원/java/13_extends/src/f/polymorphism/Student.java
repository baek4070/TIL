package f.polymorphism;

public class Student extends Person{

	String classRoom;
	String studentNum;
	String grade;
	
	
	
	public Student(
			String name, 
			int age, 
			int height, 
			String classRoom, 
			String studentNum, 
			String grade) {
		super(name, age, height);
		this.classRoom = classRoom;
		this.studentNum = studentNum;
		this.grade = grade;
	}



	public void study() {
		System.out.println(name + "학생은" + grade+"학년"+studentNum+"에서 공부합니다");
	}



	@Override
	public String toString() {
		return super.toString()+"Student [classRoom=" + classRoom + ", studentNum=" + studentNum + ", grade=" + grade + "]";
	}
	
}
