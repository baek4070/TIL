package e.random;

import java.util.Random;

public class RandomExam {

	public static void main(String[] args) {
		int[] selectNumber = new int[6];
		//random class 가 생성되어
		// 실행 될때마다 시드 갑이 동일하면
		// 동일한 난수를 발생
		Random random = new Random(10);
		// 정수형 난수 발생
		for(int i = 0; i< selectNumber.length; i++) {
			selectNumber[i] = random.nextInt(45)+1;
			System.out.print(selectNumber[i] + " ");
		}
		System.out.println();
		//실행할떄마다 동일한 난수를 돌려받을수 있다 
		Random random5 = new Random(5);
		for (int i = 0; i < 6; i++) {
			System.out.print(random5.nextInt(45)+1 + " ");
			
		}
		//현재시간을 1000분의 1초 단위로 넘겨받겠다
		long time = System.currentTimeMillis();
		System.out.println(time);
		//아무런값을 입력하지 않으면 이 시간을 기준으로 난수발생 하는 매커니즘
		random = new Random();
		Random random1 = new Random(time); // 이거랑 동일한셈
		
		for(int i = 0; i< 6; i ++) {
		System.out.print(random.nextInt(45)+1+" ");
		}
	}

}
