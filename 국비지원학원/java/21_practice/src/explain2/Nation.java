package explain2;

public class Nation {

	private String country;
	private String capital;
	
	public Nation(String country, String capital) {
		this.country = country;
		this.capital = capital;
	}

	public String getCountry() {
		return country;
	}

	public String getCapital() {
		return capital;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Nation) {
			Nation nation =(Nation)obj;
			if(nation.getCountry().equals(this.country)) {
				return true;
			}
		}
		return false;
	}
	
	
	
}
