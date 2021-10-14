package a5;

public class B {
	
	public B() {
		A a = new A();
		a.field1 = 10;	// public
		a.field2 = 20;	// default
//		a.field3 = 30;  // private
		
		System.out.println(a.method1()); // public
		System.out.println(a.method2()); // defualt
//		System.out.println(a.method3()); // private
	}
	
}








