package f03_input;

import java.io.*;
import java.util.Arrays;

public class ReadExample1 {

	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("c:/temp/file1.txt");
		int readByte = 0;
		byte[] bytes = new byte[100];
		String data = "";
		while (true) {
			readByte = is.read(bytes);
			System.out.println("읽어들인 byte 크기 : " + readByte);
			if (readByte == -1) break;
			data += new String(bytes);
		}
		System.out.println(Arrays.toString(bytes)); // 이해안감
		System.out.println(data);
		System.out.println();
		is.close();
	}

}
