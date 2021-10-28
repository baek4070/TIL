package f07_stream_reader_writer;

import java.io.*;

public class StreamWriterExample {

	public static void main(String[] args) throws Exception{
		FileOutputStream fos = new FileOutputStream("C:/Temp/fos.txt");
		Writer writer = new OutputStreamWriter(fos);
		String data = "바이트 출력 스트림을 문자기반 출력 스트림으로 변환~~";
		writer.write(data);
		writer.flush();
		writer.close();
		fos.close();
		System.out.println("종료");
	}

}
