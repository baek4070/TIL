package c3_map;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExam {

	public static void main(String[] args) {
		// 제네릭을 따로 지정해줄 필요가없다
		// String, String 타입으로 강제되어있기때문 ! 
		Properties prop = new Properties(); 
		prop.put("hi", "hello");
		prop.put("hi", 10);// put 으로 넣을떈 오브젝트 메소드 이기 떄문에 이렇게도 된다 (무슨말인지..)
		System.out.println(prop.get("hi"));//이렇게 값을 꺼내옴
		
//		prop.setProperty("key", 10); //타입안맞추니 오류
		prop.setProperty("key", "key value");
		System.out.println(prop.getProperty("key"));
		// 키값으로 엔트리를 못찾으면 기본적인 벨류값을 제공해준다
		System.out.println(prop.getProperty("심현석","심현석 59점")); 
		
		System.out.println("=====================================================");
		// 경고
		// 파일 입출력을 배워야 이해할수 있음
		String path = PropertiesExam.class.getResource("db.properties").getPath();
		System.out.println(path);
		
		Properties prop2 = new Properties();
		try {
			prop.load(new FileReader(path));
			System.out.println(prop2.getProperty("driver"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
