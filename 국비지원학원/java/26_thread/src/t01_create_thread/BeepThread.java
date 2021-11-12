package t01_create_thread;

import java.awt.Toolkit;

public class BeepThread extends Thread {
	
	// 스레드가 시작되면 동작할 실행문을 정의
	@Override
	public void run() {
		Toolkit tool = Toolkit.getDefaultToolkit();
		for(int i=0; i<5; i++) {
			System.out.println("BeepThread ");
			tool.beep();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}
}









