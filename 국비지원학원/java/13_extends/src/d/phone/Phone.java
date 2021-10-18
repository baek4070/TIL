package d.phone;

public class Phone {

	String model;
	String color;
	
	public Phone() {
	}
	// alt + s + a 
	public Phone(String model, String color) {
		super();
		this.model = model;
		this.color = color;
	}
	
	void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	
	void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	
	void bell() {
		System.err.println("벨이 울립니다.");
	}
	
	void take() {
		System.out.println("전화를 받습니다.");
	}
	
	void hangUp() {
		System.out.println("전화를 끊습니다.");
	}
	
	void sendVoice(String message) {
		System.out.println("나 : "+message);
	}
	
	void receiveVoice(String message) {
		System.out.println("상대방 : "+message);
	}

}

