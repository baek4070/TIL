package b.string.stringtokenizer;

import java.util.Scanner;

public class Change {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int answer = 0;
        String st = n + "";
        String[] nums = st.split("");
        for (String s : nums) {
			answer += Integer.parseInt(s);
		}

        System.out.println(answer); 

	}

}
