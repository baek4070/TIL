package generic01_type;

public class BoxExample {

	public static void main(String[] args) {
		Box box1 = new Box();
		Apple apple1 = new Apple();
		box1.setObj(apple1);
		
		if(box1.getObj() instanceof Orange) {
			Orange orange = (Orange)box1.getObj();
		}
		System.out.println(box1.getObj() instanceof Orange);
		
		Box box2 = new Box();
		Orange orange1 = new Orange();
		box2.setObj(orange1);
		System.out.println(orange1);
		
		System.out.println("==================");
		
		ShowBox<Orange> showBox = new ShowBox<Orange>();
		showBox.setFruit(orange1);
		Orange fruit = showBox.getFruit();
		
		ShowBox<Apple> appleBox = new ShowBox<>();
		appleBox.setFruit(apple1);
		Apple fruit1 = appleBox.getFruit();
		
	}

}






