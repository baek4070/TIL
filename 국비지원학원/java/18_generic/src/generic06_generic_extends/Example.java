package generic06_generic_extends;

public class Example {

	public static void main(String[] args) {
		Parent<String, String> p1 = new Parent<>();
		p1.setKind("TV");
		p1.setMode("LG 스마트 TV");
		System.out.println(p1);
		
		Child<String, String, String> child = new Child<>();
		child.setKind("Car");
		child.setMode("520d");
		child.setCompany("BMW");
		System.out.println(child); 
		
		System.out.println("=========================");
		Storage<Integer> storage = new StorageImpl<>(3);
		storage.add(200, 0);
		System.out.println(storage.get(0));
		System.out.println(storage.get(1));
		
		if(storage.get(1) == null) { //인티저 타입인데 어찌 널이? int가 아닌 Integer 이라는 객체
			storage.add(300, 1);
		}
		
		System.out.println(storage.get(1));
		
		Integer[] array1 = new Integer[3];
		array1[0]=null;
		System.out.println(array1[0]);
		
	}

}
