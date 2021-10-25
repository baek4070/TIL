package generic02_multi;

public class Twin<T,M> { //t와 m을 제네릭으로 가지는 클래스
	private T typeT; // 제네릭 타입 T 의 typeT
	private M model; // 제네릭 타입 M 의 model
	
	public T getTypeT() {
		return typeT;
	}
	public void setTypeT(T typeT) {
		this.typeT = typeT;
	}
	public M getModel() {
		return model;
	}
	public void setModel(M model) {
		this.model = model;
	}
	
	
}
