package java_practice_1025.explain3;

public class ArrayTest<E> {

	int capacity;
	E[] array;
	int length;
	
	public ArrayTest (){};
	
	public ArrayTest(int capacity) {
		this.capacity = capacity;
	}





	public static void main(String[] args) {

		ArrayTest<String> array = new ArrayTest<>(3);
		System.out.println(array);
		
		
		
	}

}
