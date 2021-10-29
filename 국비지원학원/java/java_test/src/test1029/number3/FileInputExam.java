package test1029.number3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileInputExam {

	public static void main(String[] args) {
		try {
			InputStream fis = new FileInputStream("test.txt");
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}

}
