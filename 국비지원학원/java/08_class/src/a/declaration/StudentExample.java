package a.declaration;

//클래스 밖에는 package 와 import, subClass 말고는 정의가 안된다
//main method 가 존재하는 실행 class
public class StudentExample {

	public static void main(String[] args) {
		Student s1; //선언
		s1 = new Student();
		System.out.println("Student class 를 참조하여 s1 객체 생성" + s1);
		Student s2 = new Student();
		System.out.println("Student class 를 참조하여 s2 객체 생성" + s2);
		//s1, s2에 생성된 주소값이 저장됨 
		Bus bus = null;
//		bus = new Student(); 참조할수 없다
		bus = new Bus();
		System.out.println(bus);
		System.out.println(s1 == s2);
	}

}
