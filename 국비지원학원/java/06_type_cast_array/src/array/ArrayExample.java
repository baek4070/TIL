package array;// 배열이 1차적(?)으로 제일 연산속도가(대게) 빠르다

public class ArrayExample {

	public static void main(String[] args) {
		//배열의 위치와 값을 선언과 동시에 초기화
		int[] scores = {70, 60, 50, 40, 60, 60};
		System.out.println(scores);
		int[] scores2 = scores; // 위치를 알려주는것임
		System.out.println(scores2);
		scores[0]= 80;
		System.out.println(scores[0]);
		System.out.println(scores2[0]); 
		// scores[0]=80 지정해도 주소를 같게 해놓았기 떄문에 둘다 80으로 프린트 된거 확인
		System.out.println(scores == scores2);
		// 마찬가지로 == 연산 true
		int a = 10;
		int b = a;
		b = 20;
		System.out.println(a == b);
		//다른 예를 보여주는것
		System.out.println("scores의 길이 : " + scores.length);
		
		int[] arrays;
		arrays = null; // null값으로 초기화
//		arrays[0] = 10 ; //null 포인트를 가르키는데 0번 인덱스에 값을 넣지 못함. 오류나는거 확인
//		System.out.println(arrays);
		if (arrays == null) {
			arrays = new int[6]; // 초기값 0 인거 확인, 공간에 기본값으로 자동 초기화
		}
		
		arrays[5] = 80;
		arrays[3] = 60;
		
		for(int i = 0; i < arrays.length; i++) {
			System.out.printf("arrays[%d] : %d \n",i,arrays[i]);
		}
//		arrays[6] = 100;
		
//		arrays = null;
//		arrays[0] = 100;
		
		//문자 형 배열
		char chars[] = new char[26];
		
		char c = 'A';
		
		for(int i = 0; i < chars.length; i++, c++) {
			chars[i] = c;
		}
		
		for(int i=0; i<chars.length; i++) {
			System.out.print("["+chars[i]+"]");
		}
		System.out.println();
		
		//실수
		double[] doubles = new double[3];
		doubles[1] = 3.14;
		for(int i =0; i<doubles.length; i++) {
			System.out.print(doubles[i]+" ");
		}
		System.out.println();
		
		//논리형 - 초기값 false
		boolean[] tasks = new boolean[5];
		System.out.println(tasks[tasks.length-1]);
		
		//참조 타입의 배열
		
		String[] strs;
//		strs = {"C언어","JAVA","JavaScript","MySQL","JSP"};
		strs = new String[]{"C언어","JAVA","JavaScript","MySQL","JSP"};
		System.out.println(strs[0]);
		System.out.println(strs);
		//strs = new String[6]; // 새로운 공간을 할당 
		System.out.println(strs); // 주소가 다른것을 확인
		//향상된 for 문(for Each문)
		for(String s : strs) {
			System.out.print(s+" ");
		}
		System.out.print("\n");
		
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
