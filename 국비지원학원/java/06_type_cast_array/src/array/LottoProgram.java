package array;

import java.util.Scanner;

public class LottoProgram {

		public static void main(String[] args) {
			
//			double random = Math.random();
//			System.out.println(random);
//			int number = (int)(random*45)+1;
//			System.out.println(number);
			int[] lotto = new int[6];
			int count = 0;
			for(int i = 0; i < lotto.length; i++) {
				count++;
				lotto[i] = (int)(Math.random()*45)+1;
				for(int j=0; j < i; j++) {
					if(lotto[j] == lotto[i]) {
						i--;
						break;
					}
				}
				
			}
			System.out.println(count);
			for(int i : lotto) {
				System.out.print(i+" ");
			}
			// 44 33 41 7 32 11
			// 7 11 32 33 41 44
//			int temp = lotto[0];// temp: 44;
//			lotto[0] = lotto[1];// lotto[0] : 33;
//			lotto[1] = temp;    // lorro[1] : 44;
			
			int temp = 0;
			// 앞의 숫자와 뒤의 숫자 크기를 비교해서 작은순으로 정렬
			for(int i = 0; i<lotto.length; i++) {
				for(int j = i+1; j<lotto.length; j++) {
					if(lotto[i] > lotto[j]) {
						temp = lotto[i];
						lotto[i] = lotto[j];
						lotto[j] = temp;
					}
				}
			}
			System.out.println();
//			for(int i : lotto) {
//				System.out.print(i+" ");
//			}
//			System.out.println();
			
			int[] myLotto = new int[6];
			
			Scanner sc = new Scanner(System.in);
			
			boolean isRun=true;
			
			while (isRun) {
				System.out.println("1.로또구입 |2.로또확인 |3.당첨확인|4.종료");
				System.out.println("번호를 입력해 주세요>");
				int selectNo = sc.nextInt();
				if(selectNo == 1) {
					System.out.println("로또구입");
					a : for(int i=0; i<myLotto.length; i++) {
						System.out.println((i+1)+"번째 번호를 입력하세요 > ");
						int number = sc.nextInt();
						if(number < 1 || number > 45) {
							System.out.println("1~45까지의 번호만 입력가능합니다.");
							i--;
							continue;
						}else {
							for(int j=0; j < i; j++) {
								if(number == myLotto[j]) {
									System.out.println("이미 등록된 번호입니다. \n 다시입력하세요.");
									i--;
									continue a;
								}
							}
							myLotto[i] = number;
						}
					}
				}else if (selectNo ==2) {
					System.out.println("로또확인");
					for (int i: myLotto){
						System.out.print("["+i+"]");
					}
				}else if (selectNo ==3) {
					System.out.println("당첨확인");
					System.out.println("당첨번호 : ");
					for(int i : lotto) {
						System.out.print("["+i+"]");
					}
					System.out.println();
					int cnt = 0;
					for (int i = 0; i < myLotto.length; i++) {
						for (int j = 0; j < lotto.length; j++) {
							if(myLotto[i] == lotto[j]) {
								cnt++;
							}
						}
					}
					System.out.println("동일한 번호 개수는 : " + cnt);
				}else{
					System.out.println("프로그램 종료");
					isRun = false;
				}
				System.out.println();
			}
			
		}
}
