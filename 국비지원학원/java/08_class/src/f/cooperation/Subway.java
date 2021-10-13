package f.cooperation;

public class Subway {
	
	String lineNumber; 		// 지하철 노선
	
	int passengerCount;		// 승객 수
	
	int money; 				// 수입
	
	// 지하철 노선 초기화
	Subway(String lineNumber){
		this.lineNumber = lineNumber;
	}
	
	void take(int money) {
		this.money += money;
		passengerCount++;
	}
	
	void showInfo() {
		System.out.println(
				lineNumber+"의 승객은"+passengerCount+"명이고, 수입은"+money+"입니다.");
	}
}
