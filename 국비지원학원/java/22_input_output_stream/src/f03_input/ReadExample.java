package f03_input;

import java.io.*;
public class ReadExample {

	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("c:/Temp/file1.txt");
			int readByte = 0;
			while (true) {
				// 바이트단위로 읽어와서 읽은 값을 int 타입으로 반환
				readByte = is.read();
				System.out.println(readByte); // 아스키 코드 
				//End Of File(EOF) == -1
				if (readByte == -1) break; // end of file , 파일의 내용을 읽어오다가 파일이 끝이났다 하면 -1을 반환
				System.out.println((char)readByte); // 문자로 나오는거 확인 //한글은 제대로 안나옴 // 한글은 3바이트 인데 1바이트로 가져와서 깨짐
			}
//		} catch (FileNotFoundException e) {// FileNotFoundException은 IOException 를 상속하기 떄문에 
		} catch (IOException e) { //IOException 으로 캐치가 가능하다 ! 
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (Exception e) {}
		}
	}

}
