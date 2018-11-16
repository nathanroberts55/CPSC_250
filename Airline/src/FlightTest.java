
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class FlightTest {
	private final static String EOL = "\n";
	
	@Test
	public void testFlight() {
		Flight                     flight     = new Flight( new String( "CO 853" ));
		String                     number     = flight.getName();
		ArrayList<Pilot>           pilots     = flight.getPilots();
		ArrayList<Traveler>        travelers  = flight.getTravelers();
		ArrayList<Traveler>        passengers = flight.getPassengers();
		ArrayList<FlightAttendant> attendants = flight.getFlightAttendants();
		boolean                    canTakeOff     = flight.canDepart();
		String                     string     = flight.toString();
		
		assertEquals( "Incorrect result", "CO 853", number );
		assertEquals( "Incorrect result", 0,        passengers.size() );
		assertEquals( "Incorrect result", 0,        travelers.size() );
		assertEquals( "Incorrect result", 0,        pilots.size() );
		assertEquals( "Incorrect result", 0,        attendants.size() );
		assertFalse ( "Incorrect result", canTakeOff );
		assertEquals( "Incorrect result", 
				"FLIGHT: CO 853" + EOL +
				"PILOTS:" + EOL +
				"FLIGHT ATTENDANTS:" + EOL +
				"PASSENGERS:" + EOL, string );
		
		// adding 4 passengers (it won't depart since none will pilot nor attend the flight)
		Traveler t1 = new Pilot          ( "J.J. Abrams",    new Coach( "18A" ), 54000 );
		Traveler t2 = new FlightAttendant( "Woody Allen",    new FirstClass( "5C" ), 49000 );
		Traveler t3 = new Passenger      ( "Alfonso Arau",   new FirstClass( "3A" ));
		Traveler t4 = new Passenger      ( "Dan Aykroyd",    new FirstClass( "3B" ) );

		assertTrue  ( "Incorrect result", flight.addTraveler( t1 ));
		assertTrue  ( "Incorrect result", flight.addTraveler( t2 ));
		assertTrue  ( "Incorrect result", flight.addTraveler( t3 ));
		assertTrue  ( "Incorrect result", flight.addTraveler( t4 ));
		// ... trying to add them again (should fail)
		assertFalse ( "Incorrect result", flight.addTraveler( t1 ));
		assertFalse ( "Incorrect result", flight.addTraveler( t2 ));
		assertFalse ( "Incorrect result", flight.addTraveler( t3 ));
		assertFalse ( "Incorrect result", flight.addTraveler( t4 ));

		pilots     = flight.getPilots();
		travelers  = flight.getTravelers();
		passengers = flight.getPassengers();
		attendants = flight.getFlightAttendants();
		canTakeOff     = flight.canDepart();
		string     = flight.toString();

		assertEquals( "Incorrect results", 0, pilots    .size() );
		assertEquals( "Incorrect results", 0, attendants.size() );
		assertEquals( "Incorrect results", 4, passengers.size() );
		assertTrue  ( "Incorrect results",    passengers.contains( t1 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t2 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t3 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t4 ));
		assertEquals( "Incorrect results", 4, travelers .size() );
		assertTrue  ( "Incorrect results",    travelers .contains( t1 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t2 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t3 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t4 ));
		assertFalse ( "Incorrect result", canTakeOff );
		assertEquals( "Incorrect result", 
				"FLIGHT: CO 853" + EOL +
                "PILOTS:" + EOL +
                "FLIGHT ATTENDANTS:" + EOL +
                "PASSENGERS:" + EOL +
                "J.J. Abrams          | Coach       [18A] | $ 54,000.00" + EOL +
                "Woody Allen          | First Class [ 5C] | $ 49,000.00" + EOL +
                "Alfonso Arau         | First Class [ 3A]" + EOL +
                "Dan Aykroyd          | First Class [ 3B]" + EOL, string );

		// deleting all travelers from the list we received
		//  (checking shallow copy -- nothing should have changed in the flight list)
		travelers.clear();
		travelers  = flight.getTravelers();
		assertEquals( "Incorrect results", 4, travelers .size() );
		assertTrue  ( "Incorrect results",    travelers .contains( t1 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t2 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t3 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t4 ));
		
		// adding a pilot, a flight attendant & a passenger (there is only one pilot and passengers < 8)
		Traveler t5 = new Pilot          ( "Roberto Benigni", new Cockpit(),  26199.56 );
		Traveler t6 = new FlightAttendant( "Drew Barrymore",  new Bulkhead(), 35679.25 );
		Traveler t7 = new FlightAttendant( "Ingmar Bergman",  new Coach( "12C" ), 12300 );

		assertTrue  ( "Incorrect result", flight.addTraveler( t5 ));
		assertTrue  ( "Incorrect result", flight.addTraveler( t6 ));
		assertTrue  ( "Incorrect result", flight.addTraveler( t7 ));

		pilots     = flight.getPilots();
		travelers  = flight.getTravelers();
		passengers = flight.getPassengers();
		attendants = flight.getFlightAttendants();
		canTakeOff     = flight.canDepart();
		string     = flight.toString();

		assertEquals( "Incorrect results", 1, pilots    .size() );
		assertTrue  ( "Incorrect results",    pilots    .contains( t5 ));
		assertEquals( "Incorrect results", 1, attendants.size() );
		assertTrue  ( "Incorrect results",    attendants.contains( t6 ));
		assertEquals( "Incorrect results", 5, passengers.size() );
		assertTrue  ( "Incorrect results",    passengers.contains( t1 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t2 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t3 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t4 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t7 ));
		assertEquals( "Incorrect results", 7, travelers .size() );
		assertTrue  ( "Incorrect results",    travelers .contains( t1 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t2 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t3 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t4 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t5 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t6 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t7 ));
		assertFalse ( "Incorrect result", canTakeOff );
		assertEquals( "Incorrect result", 
				"FLIGHT: CO 853" + EOL +
                "PILOTS:" + EOL +
                "Roberto Benigni      | Cockpit | $ 26,199.56" + EOL +
                "FLIGHT ATTENDANTS:" + EOL +
                "Drew Barrymore       | Bulkhead | $ 35,679.25" + EOL +
                "PASSENGERS:" + EOL +
                "J.J. Abrams          | Coach       [18A] | $ 54,000.00" + EOL +
                "Woody Allen          | First Class [ 5C] | $ 49,000.00" + EOL +
                "Alfonso Arau         | First Class [ 3A]" + EOL +
                "Dan Aykroyd          | First Class [ 3B]" + EOL +
                "Ingmar Bergman       | Coach       [12C] | $ 12,300.00" + EOL, string );
				
		// adding 2nd pilot (passengers < 8)
		Traveler t8 = new Pilot( "Mel Brooks", new Cockpit(),  85100.23 );
		assertTrue  ( "Incorrect result", flight.addTraveler( t8 ));

		pilots     = flight.getPilots();
		travelers  = flight.getTravelers();
		passengers = flight.getPassengers();
		attendants = flight.getFlightAttendants();
		canTakeOff     = flight.canDepart();
		string     = flight.toString();

		assertEquals( "Incorrect results", 2, pilots    .size() );
		assertTrue  ( "Incorrect results",    pilots    .contains( t5 ));
		assertTrue  ( "Incorrect results",    pilots    .contains( t8 ));
		assertEquals( "Incorrect results", 1, attendants.size() );
		assertTrue  ( "Incorrect results",    attendants.contains( t6 ));
		assertEquals( "Incorrect results", 5, passengers.size() );
		assertTrue  ( "Incorrect results",    passengers.contains( t1 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t2 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t3 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t4 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t7 ));
		assertEquals( "Incorrect results", 8, travelers .size() );
		assertTrue  ( "Incorrect results",    travelers .contains( t1 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t2 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t3 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t4 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t5 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t6 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t7 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t8 ));
		assertFalse ( "Incorrect result", canTakeOff );
		assertEquals( "Incorrect result", 
				"FLIGHT: CO 853" + EOL +
                "PILOTS:" + EOL +
                "Roberto Benigni      | Cockpit | $ 26,199.56" + EOL +
                "Mel Brooks           | Cockpit | $ 85,100.23" + EOL +
                "FLIGHT ATTENDANTS:" + EOL +
                "Drew Barrymore       | Bulkhead | $ 35,679.25" + EOL +
                "PASSENGERS:" + EOL + 
                "J.J. Abrams          | Coach       [18A] | $ 54,000.00" + EOL +
                "Woody Allen          | First Class [ 5C] | $ 49,000.00" + EOL +
                "Alfonso Arau         | First Class [ 3A]" + EOL +
                "Dan Aykroyd          | First Class [ 3B]" + EOL +
                "Ingmar Bergman       | Coach       [12C] | $ 12,300.00" + EOL, string );
		
		// adding 2 passengers (ratio passengers/attendants > 5, passengers < 8)
		Traveler t9  = new Passenger( "James Cameron", new Coach     ( "10C" ));
		Traveler t10 = new Passenger( "Nicolas Cage",  new Coach     ( "17A" ));
		assertTrue  ( "Incorrect result", flight.addTraveler( t9  ));
		assertTrue  ( "Incorrect result", flight.addTraveler( t10 ));

		pilots     = flight.getPilots();
		travelers  = flight.getTravelers();
		passengers = flight.getPassengers();
		attendants = flight.getFlightAttendants();
		canTakeOff     = flight.canDepart();
		string     = flight.toString();

		assertEquals( "Incorrect results", 2, pilots    .size() );
		assertTrue  ( "Incorrect results",    pilots    .contains( t5 ));
		assertTrue  ( "Incorrect results",    pilots    .contains( t8 ));
		assertEquals( "Incorrect results", 1, attendants.size() );
		assertTrue  ( "Incorrect results",    attendants.contains( t6 ));
		assertEquals( "Incorrect results", 7, passengers.size() );
		assertTrue  ( "Incorrect results",    passengers.contains( t1 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t2 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t3 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t4 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t7 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t9 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t10 ));
		assertEquals( "Incorrect results", 10, travelers .size() );
		assertTrue  ( "Incorrect results",    travelers .contains( t1 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t2 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t3 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t4 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t5 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t6 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t7 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t8 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t9 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t10 ));
		assertFalse ( "Incorrect result", canTakeOff );
		assertEquals( "Incorrect result", 
				"FLIGHT: CO 853" + EOL +
                "PILOTS:" + EOL +
                "Roberto Benigni      | Cockpit | $ 26,199.56" + EOL +
                "Mel Brooks           | Cockpit | $ 85,100.23" + EOL +
                "FLIGHT ATTENDANTS:" + EOL +
                "Drew Barrymore       | Bulkhead | $ 35,679.25" + EOL +
                "PASSENGERS:" + EOL +
                "J.J. Abrams          | Coach       [18A] | $ 54,000.00" + EOL +
                "Woody Allen          | First Class [ 5C] | $ 49,000.00" + EOL +
                "Alfonso Arau         | First Class [ 3A]" + EOL +
                "Dan Aykroyd          | First Class [ 3B]" + EOL +
                "Ingmar Bergman       | Coach       [12C] | $ 12,300.00" + EOL +
                "James Cameron        | Coach       [10C]" + EOL +
                "Nicolas Cage         | Coach       [17A]" + EOL, string );

		// adding 1 flight attendant (passengers < 8)
		Traveler t11 = new FlightAttendant( "Frank Capra", new Bulkhead(), 19253.71 );
		assertTrue  ( "Incorrect result", flight.addTraveler( t11 ));

		pilots     = flight.getPilots();
		travelers  = flight.getTravelers();
		passengers = flight.getPassengers();
		attendants = flight.getFlightAttendants();
		canTakeOff     = flight.canDepart();
		string     = flight.toString();

		assertEquals( "Incorrect results", 2, pilots    .size() );
		assertTrue  ( "Incorrect results",    pilots    .contains( t5 ));
		assertTrue  ( "Incorrect results",    pilots    .contains( t8 ));
		assertEquals( "Incorrect results", 2, attendants.size() );
		assertTrue  ( "Incorrect results",    attendants.contains( t6 ));
		assertTrue  ( "Incorrect results",    attendants.contains( t11 ));
		assertEquals( "Incorrect results", 7, passengers.size() );
		assertTrue  ( "Incorrect results",    passengers.contains( t1 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t2 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t3 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t4 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t7 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t9 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t10 ));
		assertEquals( "Incorrect results", 11, travelers .size() );
		assertTrue  ( "Incorrect results",    travelers .contains( t1 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t2 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t3 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t4 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t5 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t6 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t7 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t8 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t9 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t10 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t11 ));
		assertFalse ( "Incorrect result", canTakeOff );
		assertEquals( "Incorrect result", 
				"FLIGHT: CO 853" + EOL +
				"PILOTS:" + EOL +
				"Roberto Benigni      | Cockpit | $ 26,199.56" + EOL +
				"Mel Brooks           | Cockpit | $ 85,100.23" + EOL +
				"FLIGHT ATTENDANTS:" + EOL +
				"Drew Barrymore       | Bulkhead | $ 35,679.25" + EOL +
				"Frank Capra          | Bulkhead | $ 19,253.71" + EOL +
				"PASSENGERS:" + EOL +
				"J.J. Abrams          | Coach       [18A] | $ 54,000.00" + EOL +
				"Woody Allen          | First Class [ 5C] | $ 49,000.00" + EOL +
				"Alfonso Arau         | First Class [ 3A]" + EOL +
				"Dan Aykroyd          | First Class [ 3B]" + EOL +
				"Ingmar Bergman       | Coach       [12C] | $ 12,300.00" + EOL +
				"James Cameron        | Coach       [10C]" + EOL +
				"Nicolas Cage         | Coach       [17A]" + EOL, string );

		// adding 1 passengers (all OK)
		Traveler t12 = new Passenger( "Jackie Chan", new Coach( "19A" ));
		assertTrue  ( "Incorrect result", flight.addTraveler( t12 ));

		pilots     = flight.getPilots();
		travelers  = flight.getTravelers();
		passengers = flight.getPassengers();
		attendants = flight.getFlightAttendants();
		canTakeOff = flight.canDepart();
		string     = flight.toString();

		assertEquals( "Incorrect results", 2, pilots    .size() );
		assertTrue  ( "Incorrect results",    pilots    .contains( t5 ));
		assertTrue  ( "Incorrect results",    pilots    .contains( t8 ));
		assertEquals( "Incorrect results", 2, attendants.size() );
		assertTrue  ( "Incorrect results",    attendants.contains( t6 ));
		assertTrue  ( "Incorrect results",    attendants.contains( t11 ));
		assertEquals( "Incorrect results", 8, passengers.size() );
		assertTrue  ( "Incorrect results",    passengers.contains( t1 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t2 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t3 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t4 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t7 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t9 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t10 ));
		assertTrue  ( "Incorrect results",    passengers.contains( t12 ));
		assertEquals( "Incorrect results", 12, travelers .size() );
		assertTrue  ( "Incorrect results",    travelers .contains( t1 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t2 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t3 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t4 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t5 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t6 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t7 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t8 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t9 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t10 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t11 ));
		assertTrue  ( "Incorrect results",    travelers .contains( t12 ));
		assertTrue  ( "Incorrect result", canTakeOff );
		assertEquals( "Incorrect result", 
				"FLIGHT: CO 853" + EOL +
				"PILOTS:" + EOL +
				"Roberto Benigni      | Cockpit | $ 26,199.56" + EOL +
				"Mel Brooks           | Cockpit | $ 85,100.23" + EOL +
				"FLIGHT ATTENDANTS:" + EOL +
				"Drew Barrymore       | Bulkhead | $ 35,679.25" + EOL +
				"Frank Capra          | Bulkhead | $ 19,253.71" + EOL +
				"PASSENGERS:" + EOL +
				"J.J. Abrams          | Coach       [18A] | $ 54,000.00" + EOL +
				"Woody Allen          | First Class [ 5C] | $ 49,000.00" + EOL +
				"Alfonso Arau         | First Class [ 3A]" + EOL +
				"Dan Aykroyd          | First Class [ 3B]" + EOL +
				"Ingmar Bergman       | Coach       [12C] | $ 12,300.00" + EOL +
				"James Cameron        | Coach       [10C]" + EOL +
				"Nicolas Cage         | Coach       [17A]" + EOL +
				"Jackie Chan          | Coach       [19A]" + EOL, string );
	}
}