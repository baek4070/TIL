package g.abstract1;

public class AnimalTest {

	public static void main(String[] args) {
//		Animal animal = new Animal();
		Animal animal = new Cat();
		animal.breath();
		animal.sound();
		
		animal = new Dog();
		animal.breath();
		animal.sound();
		
		// 추상클래스를 이용해 인스턴스를 생성하려하면 정의되지않은 메소드를 직접 정의해줘야됨
		// dog 나 cat 처럼 이름이 없는 클래스다 해서 이걸 익명 클래스라고 부름
		Animal tiger = new Animal() {
			
			@Override
			public void sound() {
				System.out.println("냐옹 어흥");
			}
		};
		tiger.kind = "호랑이";
		tiger.breath();
		tiger.sound();
	}

}
