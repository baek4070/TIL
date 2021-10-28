package f05_writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

public class WriterExample {

	public static void main(String[] args) {
		try {
			Writer writer = new FileWriter("c:/temp/data.txt",true);
			String str = " 최기근님";
			byte[] bytes = str.getBytes();
			char[] chars = str.toCharArray();
			
			System.out.println(Arrays.toString(chars));
//			writer.write(chars);
			writer.write("김재관");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
