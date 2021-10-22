package b.throwss;

public class ThrowsExample {

	public static void main(String[] args){
		System.out.println("Main 시작");
		try {
			findClass("java.lang.String");
//			findClass("java.lang.String2");// 잘못작성되었지만 예외처리가 되었기때문에 실행가능
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Main 종료");
	}
												// 실행부에서 예외처리해라 ! 떠넘김
	public static void findClass(String path) throws ClassNotFoundException {
		//Class 설계도 정보를 path 로가가지고 가져와주세요 
		Class clazz = Class.forName(path); 
		//문자열 로 전달받는다는건 누군가 입력한다는 뜻
		//해당 path에 정보가 없을수도 있으니까(ClassNotPoundException)
		//예외처리를 강제함
		//여기서 하기 귀찮으면 throws 를 이용하면 됨 ! 
		// 하지만 누군가는 try catch 를 하긴해야함 
		System.out.println(clazz);
	}
}
