package f.polymorphism;


	//각은행의 이자율
class Bank{
	
	double getInterestRate() {
		return 0.0;
	}
}

class BadBank extends Bank{
	double getInterestRate() {
		return 10.0;
	}
}

class NormalBank extends Bank{
	@Override
	double getInterestRate() {
		return 5.0;
	}
}

class GoodBank extends Bank{
	@Override
	double getInterestRate() {
		return 2.0;
	}
}

public class BankExam {

	public static void main(String[] args) {
		Bank bank = new Bank();
		System.out.println("bank 의 이자율 : " + bank.getInterestRate());
		Bank badBank = new BadBank();
		System.out.println("badBank의 이자율 : "+badBank.getInterestRate());
		Bank normalBank = new NormalBank();
		System.out.println("normalBank의 이자율 : "+ normalBank.getInterestRate());
		Bank goodBank = new GoodBank();
		System.out.println("goodBank의 이자율 : " + goodBank.getInterestRate());
	}

}
