package b.defaults;

public class LGPrinter implements Printable{

	public void printLG() {
		System.out.println("LG 프린터기 출력");
	}

	@Override
	public void print() {
		System.out.println("LG 프린터 출력");
	}
	
}
