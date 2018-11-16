import java.util.ArrayList;
import java.util.Collections;

public class Flight implements Cloneable{
	protected String name;
	protected ArrayList<Traveler> newTravelers = new ArrayList<Traveler>();
//	protected ArrayList<Traveler> travelers = new ArrayList<Traveler>();
//	protected ArrayList<Pilot> pilots = new ArrayList<Pilot>();
//	protected ArrayList<FlightAttendant> flightAttendants = new ArrayList<FlightAttendant>();
//	protected ArrayList<Traveler> passengers = new ArrayList<Traveler>();
	
	public Flight(String _name) {
		name = _name;

	}

	public String getName() {
		return name;
	}

	public boolean addTraveler(Traveler a) {
		if (!(newTravelers.contains(a))) {
			newTravelers.add(a);
			
			return true;
		}

		return false;
	}

	public ArrayList<Traveler> getTravelers() {
		
//		for(int i = 0; i < newTravelers.size(); i++){
//			travelers.add(newTravelers.get(i));
//		}
		ArrayList<Traveler> travelers = new ArrayList<Traveler>();
//		travelers = newTravelers;
//		Collections.copy(newTravelers, travelers);
		for(Traveler object : newTravelers){
			travelers.add(object);
		}
		
				
		
		return travelers;
	}

	public ArrayList<Pilot> getPilots() {
		ArrayList<Pilot> pilots = new ArrayList<Pilot>();
		
		for (Traveler object : newTravelers) {
			if (object instanceof Pilot && object.getSeat() instanceof Cockpit) {
				pilots.add((Pilot) object);
			}
		}
		return pilots;
	}

	public ArrayList<Traveler> getPassengers() {
		ArrayList<Traveler> passengers = new ArrayList<Traveler>();
		
		for (Traveler object : newTravelers) {
			if (object.getSeat() instanceof Coach || object.getSeat() instanceof FirstClass) {
//				if(!(passengers.contains(object))){
				passengers.add(object);
//				}
			}
		}
		return passengers;
	}

	public ArrayList<FlightAttendant> getFlightAttendants() {
		ArrayList<FlightAttendant> flightAttendants = new ArrayList<FlightAttendant>();
		
		for (Traveler object : newTravelers) {
			if (object instanceof FlightAttendant && object.getSeat() instanceof Bulkhead) {
				flightAttendants.add((FlightAttendant) object);
			}
		}

		return flightAttendants;
	}

	public boolean canDepart() {
		if(getFlightAttendants().size() == 0){
			return false;
		}
		
		if(getPilots().size() >= 2 && getPassengers().size() >= 8){
			int x = getPassengers().size();
			int y = getFlightAttendants().size();
			int t = x / y;
			
			if(t <= 5){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString(){
		String pilotNames = "";
		
		for(int i = 0; i < getPilots().size(); i++){
			pilotNames += getPilots().get(i) + "\n";
		}
		
		String flightAttendantNames = "";
		
		for(int i = 0; i < getFlightAttendants().size(); i++){
			flightAttendantNames += getFlightAttendants().get(i) + "\n";
		}
		
		String passengerNames = "";
		
		for(int i = 0; i < getPassengers().size(); i++){
			passengerNames += getPassengers().get(i) + "\n";
		}
		
		String flight = "FLIGHT: " + getName() + "\n";
		String pilots = "PILOTS:\n" + pilotNames;
		String flightAttendants = "FLIGHT ATTENDANTS:\n" + flightAttendantNames;
		String passengers  = "PASSENGERS:\n" + passengerNames;
		return flight + pilots + flightAttendants + passengers;
	}
}
