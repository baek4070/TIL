package t05_control_method.notify_wait;

public class WriteObject {

	public synchronized void methodA() {
		System.out.println("methodA 사용");
		notify(); // 일시정지 상태의 스레드 중 한개를 깨움
		try {
			wait();
		} catch (InterruptedException e) {}
	}
	
	public synchronized void methodB() {
		System.out.println("methodB 사용");
		notify(); // 일시정지 상태의 스레드 중 한개를 깨움
		try {
			wait();
		} catch (InterruptedException e) {}
	}
}
