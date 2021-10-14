package a5;

public class A {
	
	public int field1;
	int field2;
	private int field3;
	
	public A() {
		field1 = 10;
		field2 = 20;
		field3 = 30;
		System.out.println(method1());
		System.out.println(method2());
		System.out.println(method3());
	}
	
	public int method1() {
		return field3;
	}
	
	int method2() {
		return field2;
	}
	
	private int method3() {
		return field3;
	}
}




