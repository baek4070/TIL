package c1_list;

import java.util.*;

public class ArrayListPractice01 {

	public static void main(String[] args) {
		//기본 길이 (용량, capacity) 가 10인 ArrayList 를 생성
		ArrayList list1 = new ArrayList(10);
		// 실제로 제네릭 타입을 지정하지 않으면 객체만 저장가능 하지만
		// autoboxing 에 의해 기본형이 참조형으로 자동 변환
		list1.add(5);
		list1.add(4);
		list1.add(2);
		list1.add(0);
		list1.add(1);
		list1.add(3);
//		list1.add(new Integer(3)); // 이거 왜안되는지 알아볼것
										//인덱스번호가 1 <= x < 4 인 녀석들로 배열을 만듬
										//하지만 subList() 로만든 배열은 읽기전용 이기떄문에
										// new ArrayList로 새로 만들어주어야 사용가능!
		//ArratList(Collection c)
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
//		print(list1, list2); // 남궁성 선생님 세팅 궁금
		System.out.println(list1);
		System.out.println(list2);
		
		
		System.out.println("===============");
		
		
		//Collection 은 인터페이스, Collections 는 유틸 클래스
		Collections.sort(list1); //오름차순으로 정렬한다
		Collections.sort(list2);
		System.out.println(list1);
		System.out.println(list2);
		
		System.out.println("list1.containsAll(list2) : " + list1.containsAll(list2));
		
		list2.add("B");
		list2.add("C");
		list2.add(3, "A"); //중간에 A 끼어넣기 ~ , 다른값들이 자리옮기는건 부담가는 작업
		System.out.println(list1);
		System.out.println(list2);
		System.out.println("====================");
		list2.set(3, "AA"); // 3번쨰 인덱스 값 교체하기
		System.out.println(list1);
		System.out.println(list2);
		
		list1.add(0, "1");
		//indexOf()는 지정된 객체의 위치(인덱스)를 알려준다
		System.out.println("index="+list1.indexOf(1));
		//스트링과 인티저 타입 구분지어지는거 확인 !!!!!!! 
		System.out.println(list1);
		System.out.println(list2);
		list1.remove(1); //인덱스가 1인 객체를 삭제
		//list1 에서 list 2와 겹치는걸 삭제
		System.out.println("list1.retainAll(list2):"+list1.retainAll(list2));
		System.out.println(list1);
		System.out.println(list2);
		
		//list2 에서 list1 에 포함된 객체들을 삭제
		for (int i = list2.size()-1; i >= 0; i--) {
			if(list1.contains(list2.get(i)))
				list2.remove(i);
		}
		System.out.println(list1);
		System.out.println(list2);
		
	}//main 종료

		

} // class
