package test1012;

public class RandomTest {

	public static void main(String[] args) {

		int[] randomNum = new int[10];
		int save = randomNum[0];
		System.out.print("최초의 리스트 : ");
		for (int i = 0; i < 10; i++) {
			randomNum[i] = (int)(Math.random()*100)+1;
			System.out.print(randomNum[i]+" ");
		}
		System.out.print("\n정렬된 리스트 : ");
		for (int i = 0; i < randomNum.length; i++) {
			for (int j = i+1; j < randomNum.length; j++) {
				if (randomNum[i]>randomNum[j]) {
					save = randomNum[i];
					randomNum[i]=randomNum[j];
					randomNum[j]=save;
				}
			}
			System.out.print(randomNum[i]+" ");
			
		}
	}

}
