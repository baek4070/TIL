package t01_create_thread;
// Thread의 생성자를 통해서 
// Thread 실행 시 실행될 작업을 전달하는 함수형 인터페이스 Runnable
public class PrintTask implements Runnable{
	@Override
	public void run() {
		for(int i=0; i<5; i++){
			System.out.println("PrintTask :  띵!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}
}




