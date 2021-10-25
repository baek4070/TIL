package generic01_type;

public class BoxExample {

	public static void main(String[] args) {
		Box box1 = new Box(); //일단 박스1만들고
		Apple apple1 = new Apple(); // 사과도 만들고
		box1.setObj(apple1); //사과1을 박스1에 셋
		
		if(box1.getObj() instanceof Orange) { //박스 1의 obj 는 Apple 타입
			Orange orange = (Orange)box1.getObj(); // 실행안됨
		}
		System.out.println(box1.getObj() instanceof Orange);
		
		Box box2 = new Box(); // 박스2를 만듬
		Orange orange1 = new Orange(); // 오랜지 1만듬
		box2.setObj(orange1);
		System.out.println(box2.getObj().equals(orange1));
		
		System.out.println("==================");
		
		ShowBox<Orange> showBox = new ShowBox<Orange>(); //제네릭이 Orange 타입인 show 박스
//		showBox.setFruit(apple1);// 타입 검증 컴파일에러
		showBox.setFruit(orange1);// 타입 검증
		Orange fruit = showBox.getFruit();
		System.out.println(orange1.toString());
		System.out.println(fruit.toString()); // 두개 같은거 확인
		
		
		ShowBox<Apple> appleBox = new ShowBox<>();
		appleBox.setFruit(apple1);
		Apple fruit1 = appleBox.getFruit();
		
	}

}






