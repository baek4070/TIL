package f.polymorphism;


public class PersonExample {

	public static void main(String[] args) {
		Bank bank = new Bank();
		System.out.println(bank.toString());
		
		Person person = new Person("최기근", 26, 184);
		System.out.println(person.toString());
		System.out.println("====================");
		System.out.println(bank);
		System.out.println(person);
		Bank badBank = null;
		System.out.println(badBank);
		
		Person s = new Student("이순신", 500, 185, "3반", "45번", "2");
		System.out.println(s);
		//s.study();
		
		Person choi = new Teacher("최기근", 26, 184, "ESD-84", "체육", "2");
		System.out.println(choi);
		Teacher t = (Teacher)choi;
		t.teach();//타입변환 해야 teacher에 정의된 메소드 사용가능!
		
//		Teacher t2 = (Teacher)s;//Student를 Teacher로 강제로 형변환 : Class Cast Exception 오류발생 ! 
//		t2.teach();
		
		Teacher t2 = null;
		if(s instanceof Teacher) {
			System.out.println("Teacher Type");
			t2 = (Teacher)s;
			t2.teach();
		}else {
			System.out.println("Teacher Type이 아닙니다");
		}
		
	}

}
