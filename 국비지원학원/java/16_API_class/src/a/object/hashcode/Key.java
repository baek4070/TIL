package a.object.hashcode;

public class Key {
	public int number;

	public Key(int number) {
		super();
		this.number = number;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Key) {
			if (this.number == ((Key)obj).number) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.number;
	}

	
}
