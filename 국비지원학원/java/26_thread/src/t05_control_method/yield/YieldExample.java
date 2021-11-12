package t05_control_method.yield;
class ThreadA extends Thread{
	boolean stop = true;
	boolean work= true;
	public void run() {
		while (stop) {
			try {
				Thread.sleep(500);
				if (work) {
					System.out.println("Thread A 작업");
				}else {
					// 우선수누이가 동일한 스레드에 실행을  양보
					Thread.yield();
				}
			} catch (InterruptedException e) {}
		}
		System.out.println("Thread A 작업 완료");
	}
	
}
class ThreadB extends Thread{
	boolean stop = true;
	boolean work= true;
	public void run() {
		while (stop) {
			try {
				Thread.sleep(500);
				if (work) {
					System.out.println("Thread B 작업");
				}else {
					// 우선수누이가 동일한 스레드에 실행을  양보
					Thread.yield();
				}
			} catch (InterruptedException e) {}
		}
		System.out.println("Thread B 작업 완료");
	}
	
}

public class YieldExample {

	public static void main(String[] args) throws InterruptedException {
		ThreadA a = new ThreadA();
		ThreadB b = new ThreadB();
		a.start();
		b.start();
		
		Thread.sleep(2000);
		
		a.work = false;
		
		Thread.sleep(2000);
		
		a.work = true;
		b.work = false;
		
		Thread.sleep(2000);
		
		a.stop = false;
		b.stop = false;
		
		System.out.println(Thread.currentThread().getName()+"종료");
	}
}
