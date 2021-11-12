package t05_control_method.join;

public class SumThread extends Thread{
	private int sum;
	
	public SumThread(String name) {
		setName(name);
	}
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name+" 시작");
		for(int i=1; i<=100; i++) {
			sum +=i;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
			System.out.println(name+" sum : " + sum);
		}
		System.out.println(name+" 종료");
	}
	
}
