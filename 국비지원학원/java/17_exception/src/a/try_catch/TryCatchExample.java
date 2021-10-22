package a.try_catch;

import java.util.Scanner;

public class TryCatchExample {

	public static void main(String[] args) {
		System.out.println("Main Start");
		int[] scores = new int[5];
		Scanner scan = new Scanner(System.in);
		//정수를 입력하지 않는다면
		//java.lang.NumberFormatException 발생하며 바로 프로그램이 꺼짐
		//이걸 대비해서 예외처리를 해야함
		try { //오류가 발생할수 있는곳을 try블록으로 감싼다
			System.out.println("변경하실 인덱스 번호를 입력하세요."); 
			//인덱스 번호를 5이상으로 입력하면 ArrayIndexOutOfBoundsException발생
			String a = scan.next();
			int index = Integer.parseInt(a); // 정수값으로 리턴
			System.out.println("변경하실 값을 입력하세요>");
			scores[index] =scan.nextInt();
			System.out.println(scores[index]+"값으로 변경되었습니다.");
			System.out.println("Try block End");
		}catch (NumberFormatException e) {
			e.printStackTrace();//오류에대한 전체내용을 프린트 해줌
			System.out.println("NumberFormatException 발생");
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());//간략하게 어떤오류인지 메시지만 출력
			System.out.println("ArrayIndexOutOfBoundsException 발생");
		}finally {
			System.out.println("오류가 발생하든 발생하지않든 무조건 실행");
		}
		System.out.println("Main End");
	}

}
