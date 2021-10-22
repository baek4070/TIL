package c.throw_exam;

public class AccountExam {

	public static void main(String[] args) {
		Account account = new Account();
		account.deposit(10000);
		System.out.println("잔고 : "+ account.getBalance());
		//여기서 예외처리해줌~ 
		try {
			account.withdraw(15000);
		} catch (BalanceInsufficientException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
