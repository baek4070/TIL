package t04_synchronized;

public class Calcurator {

	private int memory;

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
	// 이것이 동기화다 사용하는동안 다른놈이 사용못한다 ! 
//	public synchronized void setMemory(int memory) {
		synchronized(this) {
			this.memory = memory;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {}
			// 현재 동작중인 스레드 정보
			// Thread.currentThread()
			String name = Thread.currentThread().getName();
			System.out.println(name+" : "+this.memory);
		}
	}
	
	
}
