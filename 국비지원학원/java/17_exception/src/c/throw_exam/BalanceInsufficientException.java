package c.throw_exam;

// 통장 잔고 부족 예외						//Exception 상속받음
public class BalanceInsufficientException extends Exception{
	public BalanceInsufficientException() {}
	public BalanceInsufficientException(String message) {
		super(message);
	}
}
