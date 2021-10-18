package d.phone;

public class IPhone extends Phone{
	String url;

	public IPhone(
			String model, 
			String color, 
			String url) {
		super(model, color);
		this.url = url;
	}
	
	
}
