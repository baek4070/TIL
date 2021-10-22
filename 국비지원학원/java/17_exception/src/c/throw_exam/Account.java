package c.throw_exam;

public class Account {
	//잔고
	private long balance;
	
	public long getBalance() {
		return this.balance;
	}
	public void deposit(int money) {
		balance += money;
	}							 		// 발생된 오류를 호출한곳에서 처리해라고 던짐
	public void withdraw(int money) throws BalanceInsufficientException {
		if (balance < money) {
			String message ="잔고 부족 오류 : "+(money - balance)+"원 모자람";
			throw new BalanceInsufficientException(message);
		} //throws 예외를 떠넘기는거고 throw 예외를 발생시키는것
		balance -= money;
	}
	
	
}
