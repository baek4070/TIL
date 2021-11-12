package t06_daemon;

import java.util.Map;
import java.util.Set;

public class ThreadInfoExample {

	public static void main(String[] args) {
		AutoSaveThread t = new AutoSaveThread();
		t.setDaemon(true);
		t.setName("AutoSaveThread");
		t.start();
		
		Thread t1 = new Thread(()->{
			for(int i=0; i<1000000; i++);
		});
		t1.setName("t1");
		t1.start();
		
		Map<Thread,StackTraceElement[]> map 
						= Thread.getAllStackTraces();
		Set<Thread> threads = map.keySet();
		for(Thread thread : threads) {
			String isDaemon = (thread.isDaemon()) ? "(DAEMON)" : "(주)" ;
			System.out.println("Name : "+thread.getName()+isDaemon+" : "+thread.getPriority());
			System.out.println("\t 소속그룹 : "+ thread.getThreadGroup().getName());
			System.out.println();
		}
	}

}










