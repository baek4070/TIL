package f06_reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public class ReaderExample {

	public static void main(String[] args) throws IOException {
		Reader reader = new FileReader("c:/Temp/data.txt");
		int readData;
		/*
		while (true) {
			readData = reader.read();
			if (readData == -1) break;
			System.out.println((char)readData);
		}
		*/
		char[] cbuf = new char[100];
		while ((readData = reader.read(cbuf)) != -1 ) {
			System.out.println(readData);
			System.out.println(Arrays.toString(cbuf));
		}
		reader.close();
		System.out.println(readData);
	}

}
