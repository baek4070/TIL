package t05_control_method.notify_wait;

public class ThreadB extends Thread{
	private WriteObject obj;

	public ThreadB(WriteObject obj) {
		this.obj = obj;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			obj.methodB();
		}
	}

}