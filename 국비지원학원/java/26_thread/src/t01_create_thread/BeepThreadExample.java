package t01_create_thread;

public class BeepThreadExample {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		// Thread를 상속받아 run() method 를 재정의
		Thread t = new BeepThread();
		t.start();// Thread를 생성하는 메소드
		//t.run(); // Thread 생성이 아님 run이라는 메소드를 실행
		
		Runnable runnable = new PrintTask();
		Thread t1 = new Thread(runnable);
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<5; i++) {
					System.out.println("t2 print");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {}
				}
			}
		});
		t2.start();
		
		Thread t3 = new Thread(()->{
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {}
			System.out.println("t3 작업 종료");
		});
		t3.start();
		
//		for(int i=0; i<5; i++) {
//			System.out.println("Main Thread :"+i);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {}
//		}
		System.out.println("Main 종료");
	}

}





