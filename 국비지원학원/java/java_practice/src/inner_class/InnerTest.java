package inner_class;

class A{ //A 는 B의 외부 클래스
	int i = 100;
	B b = new B();
	
	class B { //B 는 A의 내부 클래스 , A클래스의 멤버처럼 다뤄짐 그래서 멤버끼리의 접근가능
		void method() {
//			A a = new A();
//			System.out.println(a.i);
			System.out.println(i); // 객체 생성 없이 외부 클래스 접근가능
		}
	}
}


class C {
//	B b = new B(); //  B 클래스는 A내부에서만 사용가능
}

public class InnerTest {

	public static void main(String[] args) {
//		B b = new B(); // B 클래스는 더이상 독립적인 클래스가 아니기떄문에 사용불가
//		b.method();
		
	}

}
