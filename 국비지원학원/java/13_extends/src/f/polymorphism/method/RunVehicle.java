package f.polymorphism.method;

import javax.sound.sampled.ReverbType;

public class RunVehicle {
	//메소드의 다형성
	void runVehicle(Vehicle vehicle) {
		vehicle.run();
	}
	
	void runBus(Bus bus) {
		bus.run();
	}
	
	void runTexi(Texi texi) {
		texi.run();
	}
	public static void main(String[] args) {
		RunVehicle rv = new RunVehicle();
		Bus bus = new Bus();
		rv.runBus(bus);
		
		Texi texi = new Texi();
//		rv.runTexi(bus);
		rv.runTexi(texi);
		
		rv.runVehicle(bus);
		rv.runVehicle(texi);
		Motorcycle mc = new Motorcycle();
		rv.runVehicle(mc);
	}

}
