
public class Traveler {
	
	protected String name;
	protected Seat seat;
	
	
	public Traveler(String _name, Seat _seat) {
		name = _name;
		seat = _seat;
	}

	public String getName() {
		return name;
	}

	public Seat getSeat() {
		return seat;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Traveler)) {
			return false;
		}

		Traveler newTraveler = (Traveler) obj;

		if (this.name.equals(newTraveler.getName())) {
			return true;
		}

		return false;
	}
	
	public String toString(){
		return String.format("%-20s", getName()) + " | " + getSeat();
	}
	
}
