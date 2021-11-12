package t08_thread_pool;

import java.util.concurrent.*;
public class ExecuteExample {

	public static void main(String[] args) {
		// 초기 스레드 수 : ExecutorService 객체가 생성 될때 기본적으로 생서오디는 스레드 수
		// 초스레드가  증가한후 사용되지 않는 스레드를 스레드 풀에서 제거하지 안혹 최소한으로 유지할수있는 개수
		// 최대 스레드 수 : 스레드 풀에서 관리하는 최대 스레드 수
		/*
		 *		newCachedThreadPool()
		 * 		초기 스레드 수, 코어 스레드 수는 0개
		 * 		최대 스레드 수는 Integer.MAX_VALUE
		 * 		스레드 개수 보다 작업 개수가 많으면 새로운 스레드를 생성하여 작업 처리
		 * 		만약 일이 없는 스레드가 60초 동안 유지되면 스레드를 종료시키고 제거
		 * 
		 * 		newFixedThreadPool(int nThreads)
		 * 		초기 스레드수 0개 코어 스레드 수와 최대 스레드 수를 nThreads값으로 지정
		 */
		// java.util.concurrent.*
		ExecutorService exe = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 16; i++) {
			Runnable run = new Runnable() {
				
				@Override
				public void run() {
					ThreadPoolExecutor tpe = (ThreadPoolExecutor)exe;
					int poolSize = tpe.getPoolSize();
					String threadName = Thread.currentThread().getName();
					System.out.println("[총 스레드 수 : "+poolSize+"] 작업 스레드 이름 : " + threadName);
//					int i = Integer.parseInt("일"); // 강제로 오류 발생 스레드를 계속 새로 생성 해서 사용
				}
			};
			// 다쓴 스레드는 버림
//			 결과 값을 반환하지 않기 때문에 오류가 발생하면 처리가 없음
//			exe.execute(run);
			
			// 스레드를 재사용
			// 오류나 반환타입에 대한 결과를반환
			// 오류에 대한 처리가 이루어짐
			exe.submit(run);
			
			
//			if (i == 10) {
//				exe.shutdown();
//			}	
		}
		exe.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("추가된 작업");
			}
		});
		// 이미 시작된 작업은 실행하고 , 새로운 작업은 추가하지 않음
//		exe.shutdown(); // 항상 스레드 풀은 사용이 끝나면 셧다운을 해줘야한다 ! // 셔다운 된 스레드에 작업을 추가할수는없다 ! 
		
		try {
			exe.awaitTermination(10, TimeUnit.SECONDS); // 지정한 시간뒤에 스레드의 종료를 확인하는것 10초동안 대기상태에 빠진다 ! 
			// 못일어 날수도 있으니까 예외처리를 해주어야함 !! // 스레드에게 지연시간을 주겠다는 뜻 
		} catch (InterruptedException e) {
			System.out.println("wait 완료");
		}
		
		// 모든 task 강제종료 // 큐에 들어가있던 뭐든 3개만 출력되는것 확인 !!! 
		exe.shutdownNow();
	}

}
