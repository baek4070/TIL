package f07_stream_reader_writer;

import java.io.*;

public class StreamReaderExample {

	public static void main(String[] args) throws Exception {
		String path = "C:/Temp/data.txt";
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		Reader reader = new InputStreamReader(fis); //InputStream 의 바이트 기반을  StreamReader 의 2바이트 기반 문자로 
		
		int readData = 0;
		char[] cbuf = new char[100]; // 문자 백개가 안되니까 반복문 안돌림 ~ 
		readData = reader.read(cbuf);
		System.out.println(readData);
		System.out.println(new String(cbuf));
		reader.close();
		fis.close();
	}

}
