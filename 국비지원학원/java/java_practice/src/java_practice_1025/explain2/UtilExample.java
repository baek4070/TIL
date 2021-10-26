package java_practice_1025.explain2;

public class UtilExample {
	public static void main(String[] args) {
		Pair<String, Integer> pair = new Pair<>("최기근", 35);
		
		
		Integer age = Util.getValue(pair, "최기근");
		
		
		System.out.println(pair.getKey() +" : "+age);
		
		ChildPair<String, Integer> childPair = new ChildPair<>("김기근", 20);
		Integer childAge = Util.getValue(childPair, "최기근");
		System.out.println(childPair.getKey() +" : "+childAge);
		
		ChildPair<Integer, String> childPair2 = new ChildPair<>(20, "김기근");
		String childAge2 = Util.getValue(childPair2, 20);
		System.out.println(childPair2.getKey() +" : "+childAge2);
		
		/*
		OtherPair<String, Integer> otherPair = new OtherPair<>("최기근", 20);
		//OtherPair는 Pair를 상속하지 않으므로 오류가 발생해야 한다.
		int otherAge = Util.getValue(otherPair, "최기근");
		System.out.println(otherAge);
		*/
	}
}
