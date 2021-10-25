package java_practice_1025.explain3;

import java.util.Arrays;

public class ArrayTest<E> {

	E[] array;

	//기본생성자
	public ArrayTest (){};
	//capacity 길이만큼의 E 타입의 배열생성 하는 생성자
	public ArrayTest(int capacity) {
//		this.array[] =new E[capacity]; //타입을 모르니까 메모리 공간확보? 가안되서 인스턴스 생성불가
		Object o =new Object[capacity];
		//최상위 오브젝트로 먼저 생성하고 형변환
		// 넘버 타입은 박싱 언박싱 생각하면됨 ~ !
		this.array = (E[])o; 
	}
		
		void add(E e) {
			
		}
		
		void remove(E e) {
			
		}
		
		int size() {
			return array.length;
		}

	@Override
		public String toString() {
			return "ArrayTest [array=" + Arrays.toString(array) + "]";
		}
	public static void main(String[] args) {

		ArrayTest<String> array = new ArrayTest<>(3);
		System.out.println(array);
		array.add("최기근");
		array.add("유관순");
		array.add("신사임당");
		array.add("최기근");
		
		System.out.println(array.size());
		System.out.println(array);
		
		array.remove("최기근");
		System.out.println(array.size());
		System.out.println(array);
		
		array.remove("최기근");
		System.out.println(array.size());
		System.out.println(array);
		
	}

}
