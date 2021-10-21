package b.string.method;

public class StringBuilderExam {

	public static void main(String[] args) {
		String a = "최기근";
		System.out.println(a.hashCode());
		a += "천재";
		System.out.println(a.hashCode());
		a += "다";
		System.out.println(a.hashCode()); // 주소값 바뀌는거 확인
		
		
		StringBuilder sb = new StringBuilder();
		System.out.println(sb.hashCode());
		sb.append("자바");
		System.out.println(sb.hashCode());
		sb.append("Programming Study");
		System.out.println(sb.toString());
		System.out.println(sb.hashCode()); // 주소값 그대로인거 확인 
		//문자열 인덱스 4번째에 "2"추가
		sb.insert(4, "2");
		System.out.println(sb.toString());
		System.out.println(sb.hashCode());
		//해당 인덱스 위치의 문자를 변경
		sb.setCharAt(4, '6');
		System.out.println(sb.toString());
		System.out.println(sb.hashCode());
		//delete(시작 인덱스, 해당 자리까지) 문자열을 삭제
		sb.delete(4, 6);
		System.out.println(sb.toString());
		System.out.println(sb.hashCode());
		
	}

}
