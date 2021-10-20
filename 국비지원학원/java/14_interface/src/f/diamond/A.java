package f.diamond;

public interface A {
	//디폴트 메소드 하나, 추상메소드 하나 가 있는 경우
	default void methodA() {
		System.out.println("A method A");
	}
	void methodB();
}
