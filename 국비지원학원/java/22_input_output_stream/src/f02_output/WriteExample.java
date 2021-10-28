package f02_output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {

	public static void main(String[] args) {
		//배포 환경에서 이시스템이 어느 운영체제에서 돌아갈지 모르면 File.separator를 사용하는게 맞다 
		String path = "C:"+File.separator+"Temp"+File.separator+"file1.txt";
		/*//OutputStream 해당하는 위치에 파일이 존재하지 않으면 파일을자동으로 생성해준다 // 대신 디렉토리는 생성안해준다 오류발생! 
		File file = new File(path);
		if (!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("파일 생성 완료");
			} catch (IOException e) {
				System.out.println("생성 실패 : "+e.getMessage());
			}
			
		}
		*/
		try {
			//OutputStream 해당하는 위치에 파일이 존재하지 않으면 파일을자동으로 생성해준다 // 대신 디렉토리는 생성안해준다 오류발생! 
//			OutputStream os = new FileOutputStream(path); //그냥 덮어쓰기
			OutputStream os = new FileOutputStream(path,true);//이어 쓰기
			String s = "한글";
			byte[] bytes = s.getBytes();
			//os.write(bytes, 1, 2);
			os.write(bytes);
			/*
			for (int i = 0; i < bytes.length; i++) {
				os.write(bytes[i]);
			}
			*/
			os.flush(); //아웃풋 스트림이 끝나면 항상 따라붙는것 //값을 내뱉고
			os.close(); //아웃풋 스트림이 끝나면 항상 따라붙는것 // 종료 해줘야함
			System.out.println("작성 완료");
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다");
		} catch (IOException e) {
			System.out.println("출력 오류");
		}
		
	}
}
