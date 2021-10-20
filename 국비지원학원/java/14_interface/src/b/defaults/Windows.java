package b.defaults;

public class Windows {

	public void print(Printable print) {
		print.print();
	}
	
//	public void print(LGPrinter printer) {
//		printer.printLG();
//	}
//	
//	public void print(SamsungPrinter printer) {
//		printer.samsungPrint();
//	}
	
	public static void main(String[] args) {
		Windows windows = new Windows();
		LGPrinter lgPrinter = new LGPrinter();
		lgPrinter.colorPrint();
		SamsungPrinter samsungPrinter = new SamsungPrinter();
		windows.print(lgPrinter);
		windows.print(samsungPrinter);
	}
}
