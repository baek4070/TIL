package t05_control_method.notify_wait;

public class NotifyWatiExample {

	public static void main(String[] args) {
		WriteObject obj = new WriteObject();
		ThreadA a = new ThreadA(obj);
		ThreadB b = new ThreadB(obj);
		a.start();
		b.start();
	}

}
