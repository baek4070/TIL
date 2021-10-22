package g.format;

import java.text.DecimalFormat; // 문자열을 조작해주는 거기때문에 text 에있음

public class DecimalFormatExample {

	public static void main(String[] args) {

		double num = 1234567.849;
		DecimalFormat df = new DecimalFormat("0");
		String str = df.format(num);
		System.out.println(str);
		
		df = new DecimalFormat("0.0");
		str = df.format(num);
		System.out.println(str);
		
		//소수점 두번째 자리까지 표현하고
		//남은 정수자리는 0으로채움
		df = new DecimalFormat("0000000000000.00");
		str = df.format(num);
		System.out.println(str);
		
		//정수는 그대로 표현하고 소수점자리는 두번째 자리까지 표현하겠다
		df = new DecimalFormat("#.##");
		str = df.format(num);
		System.out.println(str);
		
		df = new DecimalFormat("###,###,###.##");
		str = df.format(num);
		System.out.println(str);
		
		// \u00A4 == 유니코드 원화 표시
		df = new DecimalFormat("\u00A4 #,###원");
		str = df.format(num);
		System.out.println(str);
		
		df = new DecimalFormat("$ #,###원");
		str = df.format(num);
		System.out.println(str);
	}

}
