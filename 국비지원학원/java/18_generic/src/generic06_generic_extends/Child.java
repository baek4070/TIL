package generic06_generic_extends;

//public class Child extends Parent{ // 이렇게 하면 제네릭 타입이 기본적으로 오브젝트로 된다 ! 그럼 제네릭 설정한의미없다
// 부모가 가진 제네릭을 지정하고 자식은 별개로 추가가능
public class Child<T,M,C> extends Parent<T,M>{
	
	private C company;

	public C getCompany() {
		return company;
	}

	public void setCompany(C company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return super.toString()+"Child [company=" + company + "]";
	}
	
	
	
}
