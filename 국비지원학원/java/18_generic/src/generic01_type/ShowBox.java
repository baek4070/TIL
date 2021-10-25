package generic01_type;

public class ShowBox<T> { //클래스에 제네릭을 쓴경우 
	
	private T fruit; //제네릭 타입 fruit

	public T getFruit() { // get fruit
		return fruit;
	}

	public void setFruit(T fruit) { // set fruit
		this.fruit = fruit;
	}
	
}
