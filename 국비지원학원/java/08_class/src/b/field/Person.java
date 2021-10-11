package b.field;

public class Person {
	String name;		//이름
	int height;			//키
	double weight;		//몸무게
	char gender;		//성별
	boolean isMarried;	//결혼 여부 
	
	public static void main(String[] args) {
	
		Person p1 = new Person();
		p1.name = "최기근";
		p1.height= 184;
		p1.weight= 70;
		p1.gender= '남';
		p1.isMarried= false;
		
		System.out.printf("이름은 : %s , 키는 %d",p1.name,p1.height);
		
		Person p2 = new Person();
		p2.name = "심현석";
		p2.height = 160;
		System.out.printf("\n이름은 %s , 키는 %d",p2.name,p2.height);
	}
}
