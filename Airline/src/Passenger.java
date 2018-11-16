
public class Passenger extends Traveler {

	public Passenger(String _name, Seat _seat) {
		super(_name, _seat);
		
		if(_seat instanceof Bulkhead || _seat instanceof Cockpit){
			throw new IllegalArgumentException();
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Passenger)) {
			return false;
		}

		Passenger newPassenger = (Passenger) obj;

		if (this.name.equals(newPassenger.getName())) {
			return true;
		}

		return false;
	}
}
