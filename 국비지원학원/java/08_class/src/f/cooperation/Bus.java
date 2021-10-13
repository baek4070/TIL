package f.cooperation;

public class Bus {
	
	int busNumber; 		// 버스 번호
	
	int passengerCount;	// 승객 수

	int money;			// 버스의 수입
	
	// 버스 번호를 매개변수로 넘겨받는 생성자
	Bus(int busNumber){
		this.busNumber = busNumber;
	}
	
	// 승객을 태우고 지불한 금액을 받음
	void take(int money) {
		this.money += money;	// 버스의 수입을 증가
		passengerCount++;		// 승객 수 증가
	}
	
	void showInfo() {
		System.out.printf(
				"버스 %d 번의 승객은 총 %d 명이고, 수입은 %d입니다. \n",
				busNumber,
				passengerCount,
				money);
	}
}
