package c.method;

public class AccountExample {

	public static void main(String[] args) {
		Account ac = new Account();
		ac.deposit(10000);
		System.out.println("예금 : "+ ac.balance);
		ac.deposit(2000000);
		System.out.println("예금 : "+ ac.balance);
		ac.deposit(1000000);
		System.out.println("예금 : "+ ac.balance);
		ac.withdraw(30000);
		System.out.println("잔고 : "+ ac.balance);
		ac.withdraw(1000000);
		System.out.println("잔고 : "+ ac.balance);
	}

}
