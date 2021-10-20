package b.defaults;

public interface Printable {
	void print();
	
	default void colorPrint() { // 규격 추가할떄 default 가 있으면 좀 유리함 
		
	};
}
