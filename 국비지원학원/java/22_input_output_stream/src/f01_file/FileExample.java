package f01_file;

import java.io.File;
import java.io.IOException;

import javax.swing.tree.DefaultTreeCellEditor.EditorContainer;

public class FileExample {

	public static void main(String[] args) {
		String dir = "C:/temp/dir/aaa";
		String fileName = "text.java";
		
		File file = new File(dir);
		//해당 위치에 폴더나  파일이 존재하면 true
		//존재하지 않으면 false를 반환
		if (!file.exists()) {
			// 경로에 있는 모든 디렉토리를 생성
			file.mkdirs();
			// 마지막에 정의된 디렉토리를 생성
//			file.mkdir();
			System.out.println("디렉토리 생성완료");
			file = new File(dir,fileName);
			try {
				file.createNewFile();
				System.out.println("파일 생성 완료");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			File file1 = new File("C:temp/file1.tex");
			if (file1.exists()==false) {
				try {
					file1.createNewFile();
					System.out.println("파일 생성 완료");
				} catch (IOException e) {
					System.out.println("파일 생성 실패" + e.getMessage());
				}
			}
					
	
			File temp = new File("C:/Temp");
			//listFiles 디렉토리에 있는
			//폴더나 파일들의 정보를 File[] 로 제공
			File[] contents = temp.listFiles();
			System.out.println(contents.length);
			
		}
	}

}
