package generic02_multi;

public class TwinExample {

	public static void main(String[] args) {
		Twin<TV, String> tv = new Twin<TV,String>(); // T-> TV , M -> String
		tv.setTypeT(new TV()); //TV가 Twin의 부품객체 , 기본생성자 
		tv.setModel("LG 스마트 TV");
		
		Twin <Car, Integer> car = new Twin<>();
		car.setTypeT(new Car());
		car.setModel(520);
	}

}
