package f.diamond;

public interface B {
	default void methodA() {
		System.out.println("B methodA ");
	}
	void methodB();
}
