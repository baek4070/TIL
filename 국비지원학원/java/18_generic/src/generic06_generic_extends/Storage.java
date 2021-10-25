package generic06_generic_extends;

public interface Storage<T> {

	void add(T item, int index); // 매개변수 타입 을 인터페이스 제네릭 지정 가능
	T get(int index); // 반환 타입을 인터페이스 제네릭 지정 가능
	
}
