package d.phone;

public class DMBPhone extends Phone{

	int channel;

	public DMBPhone() {
		super();//Phone 이 가지고 있는 기본생성자를 호출 ( 하지만 Phone 에는 기본 생성자가 없으면 오류발생)
	}
	
	public DMBPhone(String model, String color, int channel) {
		super(model,color);
		/*
		super.model = model;
		super.color = color;
		this.channel = channel;
		*/
	}
	
	void changeChannel(int channel) {
		this.channel = channel;
		System.out.println("채널이 : "+ channel+ "로 변경되었습니다.");
	}
	
	void turnOnDMB() {
		System.out.println("DMB를 겹니다.");
	}
	
	void turnOffDMB() {
		System.out.println("DMB를 끕니다.");
	}
}
