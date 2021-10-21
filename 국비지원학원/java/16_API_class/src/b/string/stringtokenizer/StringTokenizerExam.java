package b.string.stringtokenizer;

import java.util.StringTokenizer;

public class StringTokenizerExam {

	public static void main(String[] args) {
		String text = "홍길동/김유신/이순신/최기근";
		// 1|최기근|01094867166|address  
		//특정 구분자를 이용해 구별하는 규칙을 정해서 문자열로 한번에 데이터 전송
		StringTokenizer st = new StringTokenizer(text,"/");
		int countTokens = st.countTokens();
		for(int i=0; i<countTokens; i++) {
			String token = st.nextToken();
			System.out.println(token);
		}
		//다양한 구분자를 사용가능하다           이스케이프 문자임
		text = "홍길동|페이커,심현석&최기근\\김재관\"이순신";
		st = new StringTokenizer(text,"|,&\\\"");
		while (st.hasMoreTokens()){
			String token = st.nextToken();
			System.out.println(token);
		}
		
	}

}
