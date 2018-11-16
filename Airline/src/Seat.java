
public class Seat {

	protected String location;

	protected Seat(String _location) {
		location = _location;
	}

	public String getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return getLocation();
		 
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Seat)) {
			return false;
		}

		Seat newSeat = (Seat) obj;

		if (this.location.equals(newSeat.getLocation())) {
			return true;
		}

		return false;
	}
	
}
