package d.phone;

public class PhoneExample {

	public static void main(String[] args) {
		Phone phone = new Phone("걸리버", "silver");
		phone.powerOn();
		phone.bell();
		phone.take();
		phone.sendVoice("여보세욧!!!");
		phone.receiveVoice("이번에 저희 회사에서 좋은 보험이 나와서...");
		phone.sendVoice("죄송합니다.");
		phone.hangUp();
		phone.powerOff();
		
		DMBPhone dmbPhone = new DMBPhone("가로본능", "WHITE", 11);
		System.out.println(dmbPhone.color);
		System.out.println(dmbPhone.model);
		System.out.println(dmbPhone.channel);
		dmbPhone.powerOn();
		dmbPhone.turnOnDMB();
		dmbPhone.changeChannel(8);
		dmbPhone.turnOffDMB();
		dmbPhone.powerOff();
		
	}

}
