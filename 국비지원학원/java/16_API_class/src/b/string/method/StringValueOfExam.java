package b.string.method;

public class StringValueOfExam {

	public static void main(String[] args) {
		//문자열로 변경
		//객체정보도 문자열로 변경될수 있다
		String str1 = String.valueOf(10);
		String str2 = String.valueOf(true);
		String str3 = String.valueOf(3.14);
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		String str4 = 10+"";
	}

}
