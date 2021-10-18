package e.protected1.b;

import e.protected1.a.*; // a.* 에있는 모든 클래스

public class D extends A//B = final 이기때문에 상속 불가 
{
	A a1 =new A();
	public D() {
//		a1.a = 100;
		super.a = 100;
//		a1.methodA();
		// 부모의 method A()
		super.methodA();
		// 자기자신의 오버라이딩된 method A()
		methodA();
		// 자기자신의 오버라이딩된 method A()
		this.methodA();
		
		super.methodB();
	}
	// final 키워드가 붙어있는 부모 메소드는
	// 자식 객체에서 재정의 불가
//	protected void methodB() {}
	
	@Override
	protected void methodA() {
		System.out.println("D class의 methodA");
	}
	
	public static void name(String[] arg) {
	new D();
	}
}
