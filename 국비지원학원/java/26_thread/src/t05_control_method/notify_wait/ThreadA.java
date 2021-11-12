package t05_control_method.notify_wait;

public class ThreadA extends Thread{
	private WriteObject obj;

	public ThreadA(WriteObject obj) {
		this.obj = obj;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			obj.methodA();
		}
	}

}
