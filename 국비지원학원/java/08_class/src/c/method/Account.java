package c.method;

public class Account {
	// 최소 예금액
	int minDeposit; // 따로 초기화 하지않아도 기본값을 가짐
	// 최대 예금액
	int maxDeposit = 1000000; 
	// 잔고
	int balance; // 얘네는 어디서든 사용가능 하니 전역변수 !! 
	//예금
	void deposit(int amount) {
		if(amount > maxDeposit || amount < minDeposit) {
			System.out.println("예금할 수 있는 금액이 아닙니다.");
		}else {
			balance += amount;
		}
	}
	//출금 //amount는 매개변수지만 지역변수이다
	void withdraw(int amount) {
		int result = (balance - amount);
		if (result < 0) {
			System.out.println("출금 할 수 있는 금액이 아닙니다.");
		}else {
			balance -= amount;
		}
	}
	public static void main(String[] args) {

	}

}
