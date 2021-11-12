package t04_synchronized;

class User1Thread extends Thread{
	private Calcurator calc;
	public void setCalcurator(Calcurator calc) {
		this.calc = calc;
	}
	
	public void run() {
		calc.setMemory(50);
	}
}

class User2Thread extends Thread{
	private Calcurator calc;
	public void setCalcurator(Calcurator calc) {
		this.calc = calc;
	}
	
	public void run() {
		calc.setMemory(100);
	}
}

public class SynchronizedTest {

	public static void main(String[] args) {
		 Calcurator calc = new Calcurator();
		 User1Thread u1 = new User1Thread();
		 u1.setCalcurator(calc);
		 User2Thread u2 = new User2Thread();
		 u2.setCalcurator(calc);
		 
		 u1.start();
		 u2.start();
		 // 여러 스레드가 동일 객체를 공유할떄 이렇게 중간값이 변경될 위험이 있다
		 // 그래서 동기화가 필요하다
	}

}
