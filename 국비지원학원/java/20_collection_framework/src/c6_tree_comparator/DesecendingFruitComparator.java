package c6_tree_comparator;

import java.util.Comparator;

public class DesecendingFruitComparator 
implements Comparator<Fruit>{
	@Override
	public int compare(Fruit o1, Fruit o2) {
		return o2.getPrice() - o1.getPrice();
	}
}




