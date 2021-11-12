package t05_control_method.join;

public class JoinExample {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		Thread t1 = new SumThread("SumThread-1");
		t1.start();
		
		Thread t2 = new Thread(()->{
			String name = Thread.currentThread().getName();
			System.out.println(name+" 시작");
			for(int i=1; i<=100; i++) {
				System.out.println(name+" 실행 : " + i);
				
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {}//얘를 주석처리하면 순서대로댐
				
			}
			System.out.println(name+" 종료");
		});
		t2.start();
		
		try {
			t2.join();
		} catch (InterruptedException e) {}
		
		System.out.println("Main 종료");
	}
}