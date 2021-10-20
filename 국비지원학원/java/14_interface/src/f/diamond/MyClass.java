package f.diamond;

public class MyClass //extends Test // 상속 하는 놈이 같은 메소드를 가지고있으면 자식이 재정의하는거나 마찬가지
implements A, B{
	//여러 인터페이스사이 메소드간의 충돌이 일어나면
	//무조건 실행객체에서 재정의 해줘야한다
	@Override
	public void methodA() {
		System.out.println("다무시하고 다시재정의");
	}

	@Override
	public void methodB() {
	}
	
	public static void main(String[] args) {
		MyClass methodA = new MyClass();
		methodA.methodA();
				
	}
	
}
