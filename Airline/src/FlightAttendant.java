
public class FlightAttendant extends Employee {

	public FlightAttendant(String _name, Seat _seat, double _salary) {
		super(_name, _seat, _salary);
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof FlightAttendant)) {
			return false;
		}

		FlightAttendant newFlightAttendant = (FlightAttendant) obj;

		if (this.name.equals(newFlightAttendant.getName()) && this.salary == newFlightAttendant.getSalary()) {
			return true;
		}

		return false;
	}

	public String toString(){
		return String.format("%-20s", getName()) + " | " + getSeat() + " | " + "$" + String.format("%10s", String.format("%,.2f", getSalary()));
	}
}
