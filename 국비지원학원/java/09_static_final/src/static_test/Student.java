package static_test;

public class Student {

	static String school;
	
	String name;
	int age;
	String grade;
	
	static void setGrade(String grade) {
//		this.grade= grade;   // this 라는건 instance가 생성되어야 하는데 
							 // static 메소드로 사용하려하니 오류발생 !!!!
	}
	
	void setSchool(String school) {
		this.school = school; // 바보같은 행동이긴 하지만 가능하긴 하다 
	}
	
	static String getSchool(String school) {
		return Student.school; // 이렇게 쓰는거 맞습니다
	}
	
	static int sum(int x , int y) { //주어진 매개변수만으로 함수가 구성되어있으면
		return x+y;					// static 으로 하는게 좋다 는 말씀입니다
	}
	
	//이경우는 그냥 그대로 이렇게 쓰자 
	int result;
	
	void sum(int x, int y, String message) {
		result = x + y;
		System.out.println(message);
	}
}
