package t06_daemon;

public class DaemonExample {

	public static void main(String[] args) {
		AutoSaveThread t = new AutoSaveThread();
		t.setDaemon(true);
		t.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		
		ParentThread p = new ParentThread(new ChildThread());
		p.start();
		
		System.out.println("Main Thread 종료");
	}

}





