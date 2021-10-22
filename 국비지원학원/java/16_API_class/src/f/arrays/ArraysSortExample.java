package f.arrays;

import java.util.Arrays;

public class ArraysSortExample {

	public static void main(String[] args) {
		int[] scores = {96,99,98,97,100};
		// 자동으로 배열 내용을 보여준다 인덱스번호로 반복문 돌리필요 x 
		String values = Arrays.toString(scores);
		System.out.println(values);
		//자동으로 배열을 정렬할 범위를 알려주는것임 2번 인덱스 부터 4번인덱스 까지
		Arrays.sort(scores, 2 , 4);
		System.out.println(Arrays.toString(scores));
		
		// 자동으로 배열 전체를 정렬해서 보여준다
		Arrays.sort(scores);
		System.out.println(Arrays.toString(scores));
		//아스키(유니) 코드 기준으로 정렬가능 
		//가나다 순으로 정렬됨
		String [] names = {"홍길동","박찬호","강민호","전지현"};
		Arrays.sort(names);
		System.out.println(Arrays.toString(names));
		
		//Arrays.fill 값을 대체
		// 1번 인덱스 부터 3번 인덱스까지 "심현석" 이란 내용으로 채우겠다 
		Arrays.fill(names,1,3,"심현석");
		System.out.println(Arrays.toString(names));
		// 범위 지정안하면 전부다 대체됨
		Arrays.fill(names,"심현석");
		System.out.println(Arrays.toString(names));
		
	}

}
