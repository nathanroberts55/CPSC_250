
public class Bulkhead extends Seat {

	protected Bulkhead() {
		super("Bulkhead");
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Bulkhead) {
			return true;
		}

		return false;
	}
	
	public String toString(){
		return getLocation();
	}

}
