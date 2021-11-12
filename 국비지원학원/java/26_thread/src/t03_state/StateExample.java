package t03_state;

public class StateExample {

	public static void main(String[] args) {
		// NEW
		TargetThread targetThread = new TargetThread();
		
		Thread t = new StatePrintThread(targetThread);
		t.start();
	}

}
