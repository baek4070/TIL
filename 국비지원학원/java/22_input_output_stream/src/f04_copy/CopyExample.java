package f04_copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyExample {

	public static void main(String[] args) {
		String original= "C:/Temp/transform_skew.png";
		String target = "C:/Temp/dir/copy1.png";
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(original);
			fos = new FileOutputStream(target);
			int i = 0;
			int readByte;
			byte[] bytes = new byte[100];
			while ((readByte = fis.read(bytes)) != -1) {
				fos.write(bytes,0,readByte);
				System.out.println(readByte);
				i++;
				System.out.println(i);
			}
			fos.flush();//출력이 완료된후 버퍼에 있는거까지 다 flush해줘야한다
		} catch (IOException e) {
			System.out.println("입출력 오류 : "+ e.getMessage());
		}finally {
			//alt + s + w + enter
			try {
				if(fis != null) fis.close();
				if(fos != null) fos.close();
			} catch (IOException e) {}
 		}
		
	}

}
