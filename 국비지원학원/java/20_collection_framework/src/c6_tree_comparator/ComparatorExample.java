package c6_tree_comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorExample {

	public static void main(String[] args) {
		System.out.println("인터페이스 익명 구현");
		Comparator<Fruit> compare = new Comparator<Fruit>() {
			@Override
			public int compare(Fruit o1, Fruit o2) {
				System.out.println("compare : "+o1.toString()+"/"+o2.toString());
				if(o1.getPrice() < o2.getPrice()) {
					return -1;
				}else if(o1.getPrice() == o2.getPrice()) {
					return 0;
				}else {
					return 1;
				}
			}
		};
		
		TreeSet<Fruit> treeSet = new TreeSet<>(compare);
		treeSet.add(new Fruit("포도",3000));
		treeSet.add(new Fruit("딸기",1500));
		treeSet.add(new Fruit("수박",10000));
		System.out.println(treeSet);
		
		
		System.out.println("[Comparator 구현 객체]");
		TreeSet<Fruit> treeSet2 = null; 
		treeSet2 = new TreeSet<>(new DesecendingFruitComparator());
		treeSet2.add(new Fruit("포도",3000));
		treeSet2.add(new Fruit("딸기",1500));
		treeSet2.add(new Fruit("수박",10000));
		System.out.println(treeSet2);
		
		TreeSet<Fruit> treeSet3 = 
				new TreeSet<>(new Comparator<Fruit>() {
			@Override
			public int compare(Fruit o1, Fruit o2) {
				return o1.getPrice() - o2.getPrice();
			}
		});
		
		Integer[] scores = {10,50,30,40,60,20};
		System.out.println(Arrays.toString(scores));
		Arrays.sort(scores);
		System.out.println(Arrays.toString(scores));
		
		Arrays.sort(scores, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		System.out.println(Arrays.toString(scores));
		
		
		
		
		
		
		
		
		
		
	}

}






