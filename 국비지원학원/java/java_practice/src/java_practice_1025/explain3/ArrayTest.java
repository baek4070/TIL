package java_practice_1025.explain3;

import java.util.Arrays;

public class ArrayTest<E> {
	// 저장공간
		private int capacity;
		// generic으로 지정된 Type의 배열
		private E[] array;
		// 변화 하는 배열의 길이
		private int length;
		
		public ArrayTest() {
			this(10);
		}

		public ArrayTest(int capacity) {
			this.capacity = capacity;
			array = (E[])new Object[this.capacity];
		}
		// E Type의 배열 array에 값 추가
		public void add(E e) {
			E[] newArray = this.array;
			if(length >= capacity) {
				newArray = Arrays.copyOf(this.array, array.length+1);
				newArray[array.length] = e;
				length++;
			}else {
				for(int i=0; i<array.length; i++) {
					if(array[i] == null) {
						array[i] = e;
						length++;
						break;
					}
				}
			}
			this.array = newArray;
		}
		
		public void remove(E e) {
			E[] newArray = this.array;
			for(int i=0; i<array.length; i++) {
				if(array[i]!= null && array[i].equals(e)) {
					System.out.println("찾은 인덱스 : "+i);
					if(length >= capacity) {
						newArray = Arrays.copyOf(this.array, array.length-1);
						//              원본   시작인덱스  복제배열 복제인덱스  복제할 크기
						System.arraycopy(this.array, i+1, newArray, i, newArray.length-i);
						length--;
						break;
						/*
						for(int j=i; j<newArray.length; j++) {
							newArray[j] = array[j+1];
							length--;
						}
						*/
					}
				}
			}
			this.array = newArray;
		}
		
		public String toString() {
			return Arrays.toString(this.array);
		}

		public int size() {
			return this.length;
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
