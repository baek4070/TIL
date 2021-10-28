package f03_input;

import java.io.*;
import java.util.Arrays;

public class ReadExample2 {

	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("c:/temp/file1.txt");
		byte[] bytes = new byte[8];
		is.read(bytes, 3, 2); //  3번째 인덱스 부터 2개를 저장해라
		System.out.println(Arrays.toString(bytes));
		
		System.out.println(new String(bytes)); // 아스키코드에서 0은 공백
		is.close();
	}
}
