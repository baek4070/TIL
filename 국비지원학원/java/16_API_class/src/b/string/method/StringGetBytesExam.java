package b.string.method;

import java.io.UnsupportedEncodingException;

public class StringGetBytesExam {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "한글표현"; // utf-8 에서는 한글자표현에 3바이트를 사용함
		System.out.println(str.length());
		
		byte[] bytes1 = str.getBytes("UTF-8");//"인코딩 타입" 이런식으로 인코딩 타입을 지정가능
		System.out.println("bytes1의 length : "+bytes1.length); 
		
		byte[] bytes2 = str.getBytes("EUC-KR"); // 쌍팔년도에 글자당 2바이트로 표현하게끔 만들어진 언어셋
		System.out.println(bytes2.length);
		
		System.out.println(new String(bytes1));
		System.out.println(new String(bytes2));
	}

}
