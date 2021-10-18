package d.phone;

public class AndroidPhone extends DMBPhone{
	String url;

	public AndroidPhone(
			String model, 
			String color, 
			int channel, 
			String url) {
		super(model, color, channel);
		this.url = url;
	}
	
	//메소드 재정의 override
	void sendVoice(String message) {
		super.sendVoice(message);
	}
	
	@Override // 부모가 가진 메소드를 재정의 하는걸 알려줌
	void receiveVoice(String message) {
		super.receiveVoice(message);
	}
	
	
	
}
