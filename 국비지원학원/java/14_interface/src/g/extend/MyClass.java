package g.extend;
//C인터페이스가 인터페이스 A,B를 상속받으면 A,B 추상메소드 까지 다 실행클래스에서 구현해야함
public class MyClass implements C{

	@Override
	public void printA() {
	}

	@Override
	public void printB() {
	}

	@Override
	public void printC() {
	}
	
	public static void main(String[] args) {
		A a = new A() {
			//A라는 인터페이스의 구현객체를 여기에 직접 작성하는것과 마찬가지
			//구현객체가 이름이 없는것과 마찬가지다 해서 익명 구현객체 라고 부른다
			//이짓거리를 좀 편하게 하기위해서 나온것이 람다식 !! 
			@Override
			public void printA() {
				System.out.println("기능~!");
			}
		};
		// 똑같은 A인터페이스를 구현하는것이지만 구현객체가 있냐 없냐 차이
		A a1 = new Aclass();
		a1.printA();
 	}
}
