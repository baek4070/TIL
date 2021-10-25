package generic06_generic_extends;
//      구현 클래스 이름을 이렇게 많이 지음
public class StorageImpl<T> implements Storage<T>{
	
	private T[] array; //제네릭 타입의 배열
	
	public StorageImpl(int capacity) {
		Object o = new Object[capacity];
		this.array = (T[])o; // T 의 타입을 모르니까 인스턴스를 생성한수 없다 !
	}
	
	@Override
	public void add(T item, int index) {
		
		array[index] = item;
		
	}

	@Override
	public T get(int index) {
		return array[index];
	}
	
}
/*
public class StorageImpl implements Storage{ // 타입을 지정하지 않으니 기본적으로 오브젝트로 나오는거 확인

	@Override
	public void add(Object item, int index) {
	}

	@Override
	public Object get(int index) {
		return null;
	}

	
}
*/
