package t07_thread_group;

public class WorkThread extends Thread{

	public WorkThread(ThreadGroup group,String treadName) {
		super(group,treadName);
	}
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(getName()+"- interrupted!!");
				break;
			}
//			System.out.println("Work Thread");
		}
		System.out.println(getName()+" 종료");
	}
}
