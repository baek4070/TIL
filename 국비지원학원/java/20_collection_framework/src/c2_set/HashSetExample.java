package c2_set;

import java.util.*;


public class HashSetExample {

	public static void main(String[] args) {
		Set<String> s1 = new HashSet<>();
		s1.add("A");
		s1.add("D");
		s1.add("B");
		s1.add("C");
		
		System.out.print("[ ");
		Iterator<String> itr = s1.iterator();
		//반복자 내부에 꺼내올 값이 존재하면 true
		// 더이상 꺼내올값이 없으면 false
		// Set내부에 값의 개수가 변경되는 연산이 이루어 질떄는
		// 반복자를 이용하는게 안전하다
		while (itr.hasNext()) {
			String s = itr.next();
			if(s.equals("A")) {
				itr.remove(); // 반복자를 통해서 삭제하면 안정적인 삭제가능 
			}
		System.out.print(s+" ");
		}
		System.out.println("]");
		s1.add("A");
		System.out.println(s1.contains("A"));
		
		Set<String> s2 = new HashSet<>();
		s2.add("A");
		s2.add("D");
		s2.add("E");
		System.out.print("[ ");
		for(String s : s2) { //반복자를 이용하는것과 동일하다 ! 내부적으론 iterator을 사용 
			System.out.print(s+" ");
//			if(s.equals("A")) { 
//				s2.remove(s); //반복문이 도는 도중에 삭제가 되서 오류발생 길이변경이 일어남
//			}
		} 
		System.out.println("]");
		System.out.println("s1 : "+s1); //안의 데이터가 뭐가있는지 그냥이렇게 출력하면됨 (toString과 동일)
		System.out.println("s2 : "+s2);
		//복제랑 비슷한걸 알수있다
		Set<String> s3 = new HashSet<>(s1);
		
		System.out.println(s3);
		//합집합
		s3.addAll(s2); // 합쳤다 근데 중복은 안되니까 중복되는애들은 제외한걸 알수있다
		System.out.println("s3 : "+ s3);
		Set<String> s4 = new HashSet<>(s1);
		//교집합
		s4.retainAll(s2);
		System.out.println(s4);
		System.out.println("size : " + s4.size());
		s4.add(null);
		System.out.println(s4);
		s4.add(null); // 널도 중복이라 보기때문에 추가가 안된다
		System.out.println(s4);
		s4.clear();
		System.out.println(s4.isEmpty());
		System.out.println(s4);
	}

}
