package generic04_method2_multi;
class Util{
	// 두 객체를 넘겨받아
	// 두객체의 속성 값이 일치하는지를 반환
	public static <K,V> boolean compare(Pair<K,V> p1, Pair<K,V> p2) {
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		return keyCompare && valueCompare;
	}
}
public class UtilMultiExample {

	public static void main(String[] args) {
		Pair<Integer, String> pair1 = new Pair<>(1,"사과");
		Pair<Integer, String> pair2 = new Pair<>(1,"사과");
		
		Pair<String, String> pair3 = new Pair<>("user1", "최기근");
		Pair<String, String> pair4 = new Pair<>("user2", "최기근");
		
		boolean result1 = Util.<Integer,String>compare(pair1, pair2);
		System.out.println(result1);
//		boolean result2 = Util.compare(pair3, pair1);
//		boolean result3 = Util.<Integer,String>compare(pair3, pair1);
		boolean result4 = Util.compare(pair3, pair4);
		System.out.println(result4);
	}

}
