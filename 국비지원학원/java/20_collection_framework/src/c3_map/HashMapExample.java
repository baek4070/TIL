package c3_map;

import java.util.*;

public class HashMapExample {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("최기근", 100);
		map.put("심현석", 59);
		map.put("양은정", 99);
		map.put("박종혁", 80);
		System.out.println(map); //map은 키와 밸류가 하나의 엔트리를 이룬다
		map.put("심현석", 85);
		System.out.println(map); //키값이 같으면 밸류값만 변경된다
		int score = map.get("최기근");
		System.out.println(score);
		map.remove("심현석");
		System.out.println(map);
		//키값이 존재하는지 확인
		System.out.println(map.containsKey("심현석"));
		//벨류값이 존재하는지 확인
		System.out.println(map.containsValue(80));
		System.out.println("===========================================");
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entry = entrySet.iterator();
		while (entry.hasNext()) {
			Map.Entry<String, Integer> ent = entry.next();
			System.out.println("key : "+ ent.getKey());
			System.out.println("value : " +ent.getValue());
			if (ent.getKey().equals("박종혁")) {
				entry.remove();
			}
		}
		System.out.println(map);
		System.out.println("==============================");
		
		Set<String> ketSet = map.keySet();
		Iterator<String> keyItr = ketSet.iterator();
		while (keyItr.hasNext()) {
			String key = keyItr.next();
			int value = map.get(key);
			System.out.println("key : "+ key + "value : "+value);
//			if (key.equals("양은정")) { // 마지막이라 오류발생 x
//			if (key.equals("최기근")) { // 오류발생
//				map.remove(key);
//			}
		}
		System.out.println(map);
		for (String s : ketSet) {
			System.out.println("key : "+ s);
		}
	}

}
