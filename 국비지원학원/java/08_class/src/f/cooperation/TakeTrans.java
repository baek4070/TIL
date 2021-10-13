package f.cooperation;

public class TakeTrans {

	public static void main(String[] args) {
		Bus bus100 = new Bus(100);
		bus100.showInfo();
		
		Subway subwayGreen = new Subway("2호선");
		subwayGreen.showInfo();
		
		Student studentSim = new Student("sim", 5000);
		Student studentchoi = new Student("choi", 100000000);
		
		studentSim.takeBus(bus100);
		
		studentchoi.takeSubway(subwayGreen);
		
		bus100.showInfo();
		studentSim.showInfo();
		
		subwayGreen.showInfo();
		studentchoi.showInfo();
	}
	

}
