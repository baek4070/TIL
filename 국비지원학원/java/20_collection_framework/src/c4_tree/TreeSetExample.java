package c4_tree;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(87); // 자동으로 박싱이 됩니다
		treeSet.add(75);
		treeSet.add(new Integer(90)); // 박싱이 이렇게된거나 마찬가지
		treeSet.add(80);
		treeSet.add(80);// 역시 중복은 허용x
		//값을 넣어주면 자동으로 정렬이 되는걸 확인 !! 
		System.out.println(treeSet);
		//그냥 iterator 는 저장된 순서대로 꺼내오지만 descending  은 내림차순으로 꺼내오는것
		Iterator<Integer> itr = treeSet.descendingIterator();
		//꺼내올게 있으면 true
		//꺼내올게 없으면 false
		while(itr.hasNext()) {
			int i = itr.next();
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println(treeSet.descendingSet());// 제대로 출력이 되는거 확인 
		//기존에 있던 셋을 역순으로 바꾸는것                                                  //아마 이놈도 읽기전용이라 TreeSet으로 형변환 해줘야하나 ? 
		TreeSet<Integer> descendingSet = (TreeSet<Integer>)treeSet.descendingSet();
		System.out.println(descendingSet);
		
		System.out.println("treeSet : "+treeSet);
		// 미만을 이야기함
		TreeSet<Integer> head = (TreeSet<Integer>)treeSet.headSet(80);
		System.out.println("head : "+head);
		//이상을 이야기함
		TreeSet<Integer> tail = (TreeSet<Integer>)treeSet.tailSet(80);
		System.out.println("tail : "+tail);
		
		int score = 0;
		
		score = treeSet.lower(87); // 87보다 낮은 수(바로 아래)를 반환 ~ 
		System.out.println("87보다 낮은 수(바로 아래) : " + score); 
		
		score = treeSet.higher(87); 
		System.out.println("87보다 높은 수(바로 위) : " + score); 
		
		score = treeSet.floor(85); 
		System.out.println("85이거나 그 아래 수(바로 아래) : " + score); 
		
		score = treeSet.ceiling(85); 
		System.out.println("85이거나 그 위의 수(바로 위) : " + score); 
		
		score = treeSet.first();
		System.out.println("첫번째 값 : " + score); 
		
		score = treeSet.last(); 
		System.out.println("마지막 값 : " + score); 
		
		score = treeSet.pollFirst(); 
		System.out.println("첫번째 값을 set에서 꺼내오고 삭제 : " + score); 
		System.out.println(treeSet); // 75 삭제된거 확인 ! 
		
		score = treeSet.pollLast(); 
		System.out.println("마지막 값을 set에서 꺼내오고 삭제 : " + score); 
		System.out.println(treeSet); // 90 삭제된거 확인 ! 
		
		
		//이러한 트리의 메소드를 잘 써먹자 ~ 
		
	}

}
