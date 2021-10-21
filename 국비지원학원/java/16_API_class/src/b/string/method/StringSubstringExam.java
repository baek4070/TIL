package b.string.method;

public class StringSubstringExam {

	public static void main(String[] args) {
		String ssn = "880815-1236456";
		
		String firstNum = ssn.substring(0,6);
		System.out.println(firstNum);
		System.out.println(ssn);
		//7번째인덱스 부터 (10-1)인덱스 까지
		String last = ssn.substring(7,8);
		System.out.println(last);
		
		//하나의 문자를 짤라오는거는 charAt이 더좋다 ~ 
		char gender = ssn.charAt(7);
		System.out.println(gender);
		
		String endNum = ssn.substring(7);
		System.out.println(endNum);
	}

}
