package array;

public class LottoProgram {

		public static void main(String[] args) {
			
			double random = Math.random();
			System.out.println(random);
			int number = (int)(random*45)+1;
			System.out.println(number);
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
			for(int i : lotto) {
				System.out.print(i+" ");
			}
			
		}
}
