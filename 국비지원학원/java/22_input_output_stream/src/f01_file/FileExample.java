package f01_file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {

	public static void main(String[] args) {
		String dir = "C:/Temp/dir/aaa";
		String fileName = "text.java";
		
		File file = new File(dir);
		// 해당 위치에 폴더나 파일이 존재하면 true
		// 존재하지 않으면 false를 반환
		if(!file.exists()) {
			// 경로에 있는 모든 디렉토리를 생성
			file.mkdirs();
			// 마지막에 정의된 디렉토리를 생성
			//file.mkdir();
			System.out.println("디렉토리 생성완료");
			// "C:/Temp/dir/aaa/text.java"
		}
		
		file = new File(dir,fileName);
		try {
			file.createNewFile();
			System.out.println("파일 생성 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File file1 = new File("C:/Temp/file1.txt");
		if(file1.exists() == false) {
			try {
				file1.createNewFile();
				System.out.println("파일 생성 완료");
			} catch (IOException e) {
				System.out.println("파일 생성 실패 : " + e.getMessage());
			}
		}
		
		File temp = new File("C:/Temp");
		// listFiles 디렉토리에 있는 
		// 폴더나 파일들의 정보를 File[] 로 제공
		File[] contents = temp.listFiles();
		System.out.println(contents.length);
		SimpleDateFormat sdf 
			= new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		for(File f : contents) {
			// 폴더나 파일의 마지막 수정 시간을 long type으로 반환
			Date date = new Date(f.lastModified());
			String now = sdf.format(date);
			System.out.print(now);
			// 파일객체에 저장된 정보가 디렉토리면 true 아니면 false
			if(f.isDirectory()) {
				// 디렉토리
				// getName 파일이나 디렉토리의 이름
				System.out.println("\t<DIR>\t\t\t"+f.getName());
			}else {
				// 파일
				System.out.println("\t<FILE>\t\t\t"+f.getName());
			}
		} // for 종료
		
		// File file1 = new File("C:/Temp/file1.txt");
		// file1이 가진 파일정보를 삭제
		file1.delete();
		
		// 운영체제에 맞는 디렉토리 구분자를 제공
		System.out.println(File.separator);	//type String
		System.out.println(File.separatorChar);//type char
	}
}

