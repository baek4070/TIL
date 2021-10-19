package f.polymorphism.customer;

public class CustomerExample {

	public static void main(String[] args) {
		Customer[] customerList = new Customer[10];
		
		Customer customerSim = new Customer(100110, "심현석");
		Customer customerKim = new Customer(100111, "김재관");
		Customer customerChoi = new GoldCustomer(100112, "최기근");
		
		customerList[0] = customerSim;
		customerList[1] = customerKim;
		customerList[2] = customerChoi;
		Customer customerLee = new VIPCustomer(100113, "이광호", 12);
		customerList[3] = customerLee;
		
		System.out.println("=== 고객정보 ===");
		for (Customer c : customerList) {
			if (c != null) {
			System.out.println(c.showCustomerInfo());
			}
		}
		
		System.out.println("==할인율과 보너스 포인트 계산==");
		int price = 100000; // 지불금액
		for(Customer c : customerList) {
			if(c != null) {
				int cost = c.calcPrice(price);
				System.out.println(c.customerName+"님이"+cost+"원 지불하셨습니다.");
				System.out.println(c.showCustomerInfo());
			}
		}
	}

}
