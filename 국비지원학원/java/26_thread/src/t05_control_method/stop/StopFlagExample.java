package t05_control_method.stop;

class PrintThread1 extends Thread{
	public boolean isRun = true;
	
	public void setIsRun(boolean isRun) {
		this.isRun=isRun;
	}
	
	public void run() {
		while (isRun) {
			System.out.println("실행중");
		}
		System.out.println("자원정리");
		System.out.println("실행종료");
	}
}

public class StopFlagExample {

	public static void main(String[] args) {
		PrintThread1 t = new PrintThread1();
		t.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
//		t.stop();
		t.setIsRun(false); // 스탑보단 플래그를 이용하는게 더 안전한(?)종료
	}

}
