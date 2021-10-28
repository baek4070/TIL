package f03_input;

import java.io.*;

public class ReadExample3 {

	public static void main(String[] args) throws Exception {
		File file = new File("src/f03_input/ReadExample.java");
		InputStream is = new FileInputStream(file);
		int data;
		OutputStream os = null;
		while ((data = is.read()) != -1) {
			
			os = System.out;
			os.write(data);
			os.flush();
			
		}
		os.close();
		is.close();
		System.out.println("끝");
	}

}
