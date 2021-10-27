package explain3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 3. 위도, 경도 정보를 가진 Location 클래스를 작성하고, 
 * 도시 이름을 'key'로 하는 HashMap<String, Location> 
   컬렉션을 만들고, 사용자로부터 도시이름, 경도, 위도를 입력받아 저장하고
   입력 완료 후 도시 이름으로 검색하는프로그램을 작성하시오.
   - 도시이름(city)은 String , 경도(longitude)/위도(latitude)는 
   	 Location객체의 double type 으로 저장
   - ‘q’ 입력 시 정보 입력 완료 / ‘q’ 입력 시 도시 검색 완료
   - 도시이름, 위도, 경도 는 한번에 입력받아 split()
     또는 StringTokenizer로 처리
 *
 */

class Location{
	private double longitude;
	private double latitude;
	
	public Location(double longitude, double latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	@Override
	public String toString() {
		return "Location [longitude=" + longitude + ", latitude=" + latitude + "]";
	}
	
}



public class Explain3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		HashMap<String, Location> manage = new HashMap<>();
		System.out.println("도시, 경도, 위도를 한번에 입력해주세요.(q는 입력완료)");
		while (true) {
			System.out.println(">> ");
			String inputString = sc.nextLine();
			if (inputString.equals("q"))break;
			String[] st = inputString.split(",");
			System.out.println(Arrays.toString(st));
			String city = st[0].trim();
			double longitude = Double.parseDouble(st[1].trim());
			double latitude = Double.parseDouble(st[2].trim());
			System.out.println(city+ " " + longitude + " "+ latitude);
			
			StringTokenizer stoken = new StringTokenizer(inputString,",");
			System.out.println(stoken.countTokens());
			city = stoken.nextToken().trim(); // .nextToken 토큰중에 제일먼저 짤린녀석 을 가지고옴
			longitude = Double.valueOf(stoken.nextToken().trim());
			latitude = Double.parseDouble(stoken.nextToken().trim()); // 이게 더좋다합니다 이유는?
			
			manage.put(city, new Location(longitude, latitude));
		}
		System.out.println("-----------------------------------------");
		
		Set<String> key = manage.keySet(); // 키묶음을 set 타입으로 가져올수있다
		for (String k : key) {
			Location l = manage.get(k);
			System.out.println(k+" "+l.getLongitude()+ " " +l.getLatitude());
		}
		
		System.out.println("-----------------------------------------");
		
		while (true) {
			System.out.println("도시 이름( q는 종료 )>>");
			String city = sc.next();
			if(city.equals("q")) break;
			if(manage.containsKey(city)) {
				System.out.println(city+""+manage.get(city));
			}else {
				System.out.println(city+"는 없습니다.");
			}
		}
		System.out.println("시스템 종료");

	}
}
