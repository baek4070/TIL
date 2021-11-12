package t01_create_thread;

import java.awt.Toolkit;

public class SingleThread {
	
	// Main Thread - 생성
	public static void main(String[] args) {
		System.out.println("Main 시작");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		toolkit.beep();
		
		for(int i=0; i<5; i++) {
			System.out.println("띵!");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
		
		System.out.println("========================");
		
		for(int i=0; i<5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
		System.out.println("Main 종료");
	}
	// Main Thread - 종료
}



