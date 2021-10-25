package generic03_method1;

class Util{
	public static<T> Box<T> boxing(T t){
		Box<T>box=new Box<>();
		box.setType(t);
		return box;
				}
	}

public class UtilExample {

	public static void main(String[] args) {
		Box<String> box1 = Util.<String>boxing("사과");
		System.out.println(box1.getType());
		
		Box<String> box2 = Util.<String>boxing("오렌지");
		System.out.println(box2.getType());
		
//		Box<string> errBox = Utill.boxi(1);
		
		Box<Integer> box3 = Util.<Integer>boxing(3);
		int i = box3.getType();
		System.out.println(i);
	}

}
