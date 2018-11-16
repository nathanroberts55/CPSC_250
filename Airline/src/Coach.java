
public class Coach extends Seat{

	protected Coach(String _location) {
		super(_location);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Coach)) {
			return false;
		}

		Coach newSeat = (Coach) obj;

		if (this.location.equals(newSeat.getLocation())) {
			return true;
		}

		return false;
	}
	
	@Override
	public String toString(){
		return (String.format("%-12s", "Coach") + "[" + String.format("%3s", getLocation()) + "]");
	}
}


