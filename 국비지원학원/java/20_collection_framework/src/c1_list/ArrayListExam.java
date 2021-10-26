package c1_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListExam {

	public static void main(String[] args) {
		// 순서(index)가 존재하고 데이터 중복 저장이 가능한 List Collection
		ArrayList array = new ArrayList(); // 기본값 오브젝트 타입
		array.add("문자열");
		array.add(100);
		String s = (String)array.get(0); //이렇게 안하려면 제네릭 지정해야합니다
		System.out.println(array);
		
		ArrayList<String> strs = new ArrayList<>();
		int strLength = strs.size();
		System.out.println("size : " + strLength);
		strs.add("java");
		strs.add("JDBC");
		System.out.println(strs.size());
		strs.add("MYSQL");
		strs.add("mysql");
		
		String str = strs.get(1);
		System.out.println(strs);
		System.out.println("1번째 인덱스의 값 : "+ str);
		
		strs.add(2, "Servlet/JSP");
		System.out.println(strs);
		
		strs.set(3, "Oracle");
		System.out.println(strs);
		
		//remove(index) index 위치에 값 삭제
		String result = strs.remove(1);
		System.out.println(strs);
		System.out.println(result);
		
		
		strs.remove("java");
		System.out.println(strs.size());
		System.out.println(strs);
		
		boolean isCheck = strs.contains("java");
		System.out.println(isCheck);
		
		isCheck = strs.contains("mysql");
		System.out.println(isCheck);
		//값이 비어있으면 true , 하나라도 값이 존재하면 false
		isCheck = strs.isEmpty();
		System.out.println(strs);
		System.out.println("isEmpty : "+ isCheck);
		//List 안의 모든 값을 제거
		strs.clear();
		System.out.println(strs);
		
		isCheck = strs.isEmpty();	
		System.out.println("isEmpty : "+ isCheck);
		
		strs.add("java");
		strs.add("JDBC");
		strs.add("MYSQL");
		String[] ss = strs.toArray(new String[strs.size()]);
		System.out.println(Arrays.toString(ss));
		
		List<String> list = Arrays.asList(ss);
		System.out.println(list);
	}

}
