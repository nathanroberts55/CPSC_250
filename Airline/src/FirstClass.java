
public class FirstClass extends Seat {

	protected FirstClass(String _location) {
		super(_location);
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof FirstClass)) {
			return false;
		}

		FirstClass newSeat = (FirstClass) obj;

		if (this.location.equals(newSeat.getLocation())) {
			return true;
		}

		return false;
	}
	
	@Override
	public String toString(){
		return (String.format("%-12s", "First Class") + "[" + String.format("%3s", getLocation()) + "]");
	}
}
