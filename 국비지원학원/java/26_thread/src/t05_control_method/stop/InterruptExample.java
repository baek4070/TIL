package t05_control_method.stop;

class InterruptThread extends Thread{
	
	public void run() {
		while (true) {
			if (Thread.interrupted()) { //인터럽트가 호출되었는지 여부 ! 
				break;
			}
			System.out.println("실행중");
		}
		System.out.println("자원해제");// while문이 끝날수 없으니 아래쪽은 실행될수없다고 붉은줄
		System.out.println("실행종료");
	}
	
//	public void run() {
//		while (true) {
//			System.out.println("실행중");
//			try {
//				Thread.sleep(1); //대기상태를 줌으로서 interrupt가 걸리게끔 조작
//			} catch (InterruptedException e) {
//				System.out.println("Thread 종료");
//				break;
//			}
//		}
//		System.out.println("자원해제");
//		System.out.println("실행종료");
//	}
}

public class InterruptExample {

	public static void main(String[] args) {
		InterruptThread t = new InterruptThread();
		t.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
		t.interrupt();//스레드가 실행중이 아닌 대기상태일떄마나 예외를 발생 시킨다.
		//계속 돌고있는동안 인터럽트 해봐야 오류발생이 안된다
		
	}

}







