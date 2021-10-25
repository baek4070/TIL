package java_practice_1025.explain2;


public class Util {

	public static <K, V> V getValue(Pair<K, V> p, K k) {
		if (p.getKey().equals(k)) {
			return p.getValue();
		}
		return null;
	}
}
