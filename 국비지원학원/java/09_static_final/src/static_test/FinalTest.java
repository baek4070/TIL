package static_test;

public class FinalTest {

	int a = 10; // 인스턴스 멤버 ~ 
	
	final int b = 10;
	
	final int c;
	
	// 값이 변경되면 안되면서 동시에 어디서도 사용이 가능한
	// 아래 녀석들을 상수 라고 합니다
	// 키워드 순서는 바뀌어도 상관이 x 
	static final double PI = 3.14; 		
	final static int MAX_NUMBER = 25;	
	
	FinalTest() {
		c = 100; //이라인을 주석처리하면 초기화 되지 않은 파이널 필드가 존재한다고 알려준다
	}
	
	public static void main(String[] args) {
		FinalTest finalTest = new FinalTest();
		finalTest.a = 30;
		System.out.println(finalTest.a);
		//finalTest.b = 40; 변경이 불가능 하다 ~, 재할당 불가 ! 
		System.out.println(finalTest.b);
		
		final int v;
		v = 100;
		System.out.println(v);
		//v = 101;  //값 변경불가 ~ 
		final int b = 100;
		System.out.println(b);
		System.out.println(PI);
		System.out.println(FinalTest.PI);
//		Math.PI = 100; // 당연히 안됩니다 
		System.out.println(Math.PI);
		//static int a;
	}
	
}
