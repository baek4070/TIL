package static_test;

public class FinalTest {

	int a = 10; // 인스턴스 멤버 ~ 
	
	final int b = 10;
	
	final int c;
	
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
	}
	
}
