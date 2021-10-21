package java_practice_1019;

public class StudentExample {

	public static void main(String[] args) {
		Student.school = "koreaTE";
		Student kim = new Student();
		kim.grade = 4;
		kim.name = "김유신";
		System.out.println(kim.school);
		System.out.println(kim.grade);
		System.out.println(kim.name);
		System.out.println("------------");
		Student hong = new Student(2, "홍길동");
		System.out.println(hong.school);
		System.out.println(hong.grade);
		System.out.println(hong.name);
		System.out.println("------------");
		Student choi = new Student(1, "최기근");
		System.out.println(choi.school);
		System.out.println(choi.grade);
		System.out.println(choi.name);
	}

}
