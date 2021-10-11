package c.method;
//객체의 동작- 기능들을 정의
public class Method {
	// 메소드의 이름은 유일해야한다
	// 반환형 메소드 이름(매개변수들...){실행문들..}
	void methodA(){
		System.out.println("반환하는 값은 없고 기능만 수행");
	}
	
	int methodB() {
		System.out.println("int type의 값을 반환");
		return 0; // 반환되는 값에 맞제 리턴문 뒤에 작성해야함
//		System.out.println("aaaaa"); // 리턴문 이후에 별다른 분기없이 실행문 넣으면 오류발생~
	}
	
	double methodC(int x,int y) {
		return x / y; 
	}
	int methodC(double x,int y) {
		return (int)x / y; 
	}
	
	String methodD(char a,char b,char c) {
		return a+":"+b+":"+c;
	}
	public static void main(String[] args) {
		Method m1 = new Method();
//		int a = m1.methodA();//반환하는 값이 없는데 리턴하려하니 오류발생
		m1.methodA();
		int result = m1.methodB();
		System.out.println(result);
//		String s = m1.methodB(); // String s = 0; 와 다름없다 그러므로 오류 
		double r = m1.methodC(10,30);
		System.out.println(r);
		int t = m1.methodC(10.0,30);
		System.out.println(t);
		String s = m1.methodD('심', '현', '석');
		System.out.println(s); // println( 왜 매개변수를 타입과 관계없이 다받냐?) 바로 메소드 오버로딩! ! 
		//오버로딩 이해는 되는데 그럼 리턴타입도 다르게끔 오버로딩 가능한가 ?? 
		
	}
}

