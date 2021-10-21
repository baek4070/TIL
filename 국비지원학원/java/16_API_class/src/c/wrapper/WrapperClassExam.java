package c.wrapper;

public class WrapperClassExam {

	public static void main(String[] args) {
		
		Integer obj1 = new Integer(100);
		int i = obj1;
		Integer obj2 = i;
		obj2 = 100;
		Integer.valueOf(100);
		Integer.valueOf("100");
		obj2 = new Integer(100);
		System.out.println(obj2);
		
		Integer obj3 = obj1 + obj2;
		System.out.println(obj3);
		
		Byte byte1 =Byte.valueOf("1");
		Character ch = new Character('A');
		short sh = new Short((short)100);
		Integer in = new Integer(200);
		Long l = new Long(300);
		Float f = new Float(3.14);
		Double d = new Double(3.14);
		Boolean bool =new Boolean("true");
		
		int result = Integer.parseInt("12546");
		System.out.println(result);
	}

}
