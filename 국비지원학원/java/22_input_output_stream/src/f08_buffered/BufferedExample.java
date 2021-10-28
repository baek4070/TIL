package f08_buffered;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BufferedExample {

	public static void main(String[] args) throws Exception {
		String path = "C:/Temp/bonobono.jpg";
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		
		long startTime = 0;
		long endTime = 0;
		
		int data;
		
		startTime = System.nanoTime();
		while ((data = fis.read()) != -1) {}
		endTime = System.nanoTime();
		System.out.printf("fis : %d ns %n",(endTime-startTime)); // FileInputStream 으로 읽었을때 속도
		
		startTime = System.nanoTime();
		while ((data = bis.read()) != -1) {}
		endTime = System.nanoTime();
		System.out.printf("bis : %d ns %n",(endTime-startTime)); //BufferedInputStream 으로 읽었을때 속도
		
		bis.close();
		fis.close();
	}

}
