package static_test;

public class StaticTest {
	
	static int a; // <------------------------------집중 static
	
	public static void main(String[] args) {
		
		System.out.println(a); // <-----------------집중 main 메소드는 static 입니다
		
		Student.school = "한국기술교육직업전문학교";
		
		Student stu1 = new Student();
		stu1.age = 26;
		stu1.grade = "A등급";
		stu1.name = "최기근";
		//인스턴스 멤버를 거쳐서 스태틱에 접근하는건 비효율적이라 경고문구가 뜨는것
		System.out.println(stu1.school); 
		Student stu2 = new Student();
		stu2.age= 78;
		stu2.grade = "F등급";
		stu2.name = "심현석";
		System.out.println(stu2.school);
		Student stu3 = new Student();
		// static 키워드가 없는 인스턴스 멤버는
		// heap instance 영역에 공간이 생성됨으로
		// class로 접근 불가 - 인스턴스가 생성되어야
		// 접근 가능한 인스턴스 멤버
		// Student.age;
		stu3.name = "김재관";
		stu3.school = "부산교도소"; // 여기서 변경해도 모두가 공유한다는 말임 
		System.out.println(Student.school);
		System.out.println(stu1.school);
		System.out.println(stu2.school);
		System.out.println(stu3.school);
		
		double d = Math.max(10.0, 20.0); // static 메소드 의 일반적인 예 
		System.out.println(d);
	}

}
