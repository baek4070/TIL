package a6;

import a5.A;

public class C {
	
	public C() {
		A a = new A();
		a.field1 = 50;
//		a.field2 = 30;	// default
//      a.field3 = 40;  // private
		System.out.println(a.method1());
//		System.out.println(a.method2());
//		System.out.println(a.method3());
	}
	
}









