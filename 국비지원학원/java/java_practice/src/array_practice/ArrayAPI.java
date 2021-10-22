package array_practice;

import java.util.Arrays;

public class ArrayAPI {

	public static void main(String[] args) {
		
		//배열의 위치와 값을 선언과 동시에 초기화
		int[] scores = {70, 60, 50, 40, 60, 60};
		System.out.println(scores);
		int[] scores2 = scores; // 위치를 알려주는것임
		System.out.println(scores2);
		//-------------------배열 내용 반환 ------------------------------
		System.out.println("scores : " + Arrays.toString(scores));
		System.out.println("scores2 : " + Arrays.toString(scores2));
		//-------------------배열 복제-----------------------------
		int[] scores3 = Arrays.copyOf(scores, 8); // 원본보다 길어도 상관없음 기본값이 들어감
		System.out.println(scores3);			  // 다른 주소를 참조함
		System.out.println("scores3 : " + Arrays.toString(scores3));
		System.out.println(scores3);			  // 다른 주소를 참조함
		System.out.println("scores3 : " + Arrays.toString(scores3));
		//-------------------배열 특정 범위만 복제 ------------------------
										//(원본,시작인덱스,길이로 환산한 마지막 인덱스까지)
		int[] scores4 = Arrays.copyOfRange(scores, 0, scores.length);
		System.out.println(scores4);
		System.out.println("scores4 : " + Arrays.toString(scores4));
		scores4[scores.length-1]=100;
		System.out.println("scores4 : " + Arrays.toString(scores4));
		System.out.println("scores : " + Arrays.toString(scores));
		//------------------- 배열 정렬 --------------------------------
		Arrays.sort(scores4);
		System.out.println(scores4);			// 정렬이 바뀌어도 저장 주소값은 동일한걸 확인
		System.out.println("scores4 배열 전체정렬 : " + Arrays.toString(scores4));
		//--------------------배열 부분 정렬 -----------------------------------
		Arrays.sort(scores3,1,7); //(원본,시작인덱스,길이로 환산한 마지막 인덱스까지)
		System.out.println(scores3);			  // 다른 주소를 참조함
		System.out.println("scores3 1번쨰~7번째 부분정렬: " + Arrays.toString(scores3));
		//----------------------스트링 타입의 배열------------------------------------
		String[] strs;
		strs = new String[]{"C언어","DAVA","JavaScript","MySQL","ASP"};
		System.out.println(strs);
		System.out.println(Arrays.toString(strs));
		//-----------------------스트링 타입 배열 복제 ----------------------------------
		String[] strs1 = Arrays.copyOf(strs,strs.length);
		System.out.println(strs1);
		System.out.println("복제된 strs1 : " +Arrays.toString(strs1));
		//-------------------스트링 타입 배열 아스키 기준 정렬--------------------------------
		Arrays.sort(strs);
		System.out.println(strs);
		System.out.println("정렬된 strs : "+Arrays.toString(strs));
		//--------------------부분 배열 값 대체---------------------------------------
		Arrays.fill(strs, 1,3,"대체되었음");//(원본,시작인덱스,길이로 환산한 마지막 인덱스까지)
		System.out.println(strs);
		System.out.println("부분 대체된 strs : "+Arrays.toString(strs));
		//--------------------전체 배열 값 대체---------------------------------------
		Arrays.fill(strs, "전체대체");
		System.out.println(strs);
		System.out.println("전체대체된 strs : "+Arrays.toString(strs));
		//--------------------스트링 타입 배열 이진탐색 ----------------------------------
		// 이차원 배열
		int[] array3[] = new int[2][]; // 값을 []개저장할수 있는 배열이 2개 존재한다
		
		int array2[][] = {
							{1,2,3},
							{4,5,6,7},
							{7,8,9}
						 };
		
		for(int i = 0; i< array2.length; i++) {
//			System.out.println(array2[i]);
			System.out.print("{");
			for(int j = 0; j < array2[i].length; j++) {
			//	System.out.printf("array2[%d][%d]-[%d]",i,j,array2[i][j]);
				System.out.print(array2[i][j]+" ");
			}
			System.out.print("}\n");
		}
		
		int[] array1[] = new int[2][];
		System.out.println(array1[0]);
		System.out.println(array1[1]);
//		System.out.println(array1[2]);
		array1[0] = new int[3];
		array1[1] = new int[4];
		System.out.println(array1.length);
		System.out.println(array1[0].length);
		System.out.println(array1[1].length);
		
	}
}
