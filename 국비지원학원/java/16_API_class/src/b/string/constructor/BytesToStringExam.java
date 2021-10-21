package b.string.constructor;

public class BytesToStringExam {

	public static void main(String[] args) {
		byte[] bytes = new byte[] {
		//  H   e   l   l   o   _ J   a  v   a
			72,101,108,108,111,32,74,97,118,97
		};
		
		String str = new String(bytes);
		System.out.println(str);
		// 6번째 인덱스 부터 4자리로 문자열 생성
		String str2 = new String(bytes,6,4);
		System.out.println(str2);
		//bytes 배열의 0번째 인덱스 부터 5개 - Hello
		String str3 = new String(bytes,0,5);
		System.out.println(str3);
		
		char[] strs = new char[] {'안','녕','하','세','요'};
		str = new String(strs);
		System.out.println(str);
		str = new String(strs,0,2);
		System.out.println(str);
		//string 을 char array 로 변경
		char[] stringArray = str.toCharArray();
		for(char c : stringArray) {
			System.out.println(c);
		}
	}
}
