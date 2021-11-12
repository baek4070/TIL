package t07_thread_group;

public class ThreadGroupExample {

	public static void main(String[] args) {
		ThreadGroup group = new ThreadGroup("MyGroup");
		Thread threadA = new WorkThread(group, "WorkThreadA");
		Thread threadB = new WorkThread(group, "WorkThreadB");
		Thread threadC = new Thread(group,new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("ThreadCC thread Interrupted");
						break;
					}
				}
				System.out.println("ThreadCC 종료");
			}
		}); //Thread c 정의 End
		
		threadA.start();
		threadB.start();
		threadC.start();
		
		System.out.println("[ main thread그룹 list 정보]");
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		//ThreadGroup의 리스트 정보를 출력하는 method
		mainGroup.list();
		
		System.out.println("[ MyGroup 그룹 list 정보]");
		group.list();
		System.out.println();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		
		System.out.println("MyGroup 스레드 그룹 interrupt()호 출");
//		group.interrupt();
		mainGroup.interrupt();//main 그룹에 소속된 모든걸 다 interrupt 시키고싶다 
	}

}
