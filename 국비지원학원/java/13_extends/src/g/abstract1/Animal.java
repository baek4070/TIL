package g.abstract1;

public abstract class Animal {
	
	// 분류
	String kind;
	
	public void breath() {
		System.out.println(kind + "가 숨을 쉰다.");
	}
	
	public abstract void sound(); // 추상 메소드를 하나라도 들고있으면 해당클래스는 추상클래스가 된다
	
}
