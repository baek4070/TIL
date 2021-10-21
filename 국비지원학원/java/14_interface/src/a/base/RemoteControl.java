package a.base;

public interface RemoteControl {
	public static final int MAX_VALUE = 10;
	int MIN_VALUE = 0; // 인터페이스에서는 public static final 이 붙은것과 마찬가지로 상수가된다
	
	public abstract void turnOff();
	public abstract void turnOn();
	void setValue(int value);
//	public void setValue(int value) {}// 일반 메소드를 정의하니 오류발생
}
