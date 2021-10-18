package f.polymorphism;


public class PersonExample {

	public static void main(String[] args) {
		Bank bank = new Bank();
		System.out.println(bank.toString());
		
		Person person = new Person("최기근", 26, 184);
		System.out.println(person.toString());
		System.out.println("====================");
		System.out.println(bank);
		System.out.println(person);
		Bank badBank = null;
		System.out.println(badBank);
	}

}
