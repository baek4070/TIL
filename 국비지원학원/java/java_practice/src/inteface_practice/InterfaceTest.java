package inteface_practice;

class A {
//	public void method(B b) { // B -> C 로 변경하려면 이부분도 변경해야함
	public void method(I i) { // 인터페이스 I를 구현한 넘들만 들어와라
		i.method();
	}
}
interface I {
	void method();
}


class B implements I{
	public void method() {
		System.out.println("B클래스의 메서드");
	}
}

class C implements I{
	public void method() {
		System.out.println("C클래스의 메서드");
	}
}


public class InterfaceTest {

	public static void main(String[] args) {
//		A a = new A();
//		a.method(new A()); // A 가 B를 사용 (의존)
		A a = new A();
		a.method(new B()); // B 대신 C 로 변경 해도 class A는 변경할 필요없다
	}

}
