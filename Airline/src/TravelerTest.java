
import static org.junit.Assert.*;

import org.junit.Test;


public class TravelerTest {

	@Test
	public void testTraveler() {
		String   name     = "John Johnson";
		Seat  seat     = new Coach( "1B" );
		Traveler traveler = new Traveler( new String( name ), seat );
		assertEquals( "Incorrect result", name, traveler.getName() );
		assertEquals( "Incorrect result", seat, traveler.getSeat() );
		String   string   = traveler.toString();
		assertEquals( "Incorrect result", "John Johnson         | Coach       [ 1B]", string );
		
		Object obj1, obj2;
		
		obj1 = new Traveler( "James Jameson", new FirstClass( "2A" ));
		obj2 = new Traveler( "James Jameson", new FirstClass( "2A" ));
		assertTrue ( "Incorrect result", obj1.equals( obj2 ));
		
		obj2 = new Traveler( "James Jameson", new Bulkhead());
		assertTrue ( "Incorrect result", obj1.equals( obj2 ));

		obj2 = new Traveler( "Johan Jameson", new FirstClass( "2A" ));
		assertFalse( "Incorrect result", obj1.equals( obj2 ));
		
		assertFalse( "Incorrect result", obj1 instanceof Passenger );
		assertFalse( "Incorrect result", obj1 instanceof Employee );
		assertFalse( "Incorrect result", obj1 instanceof Pilot );
		assertFalse( "Incorrect result", obj1 instanceof FlightAttendant );

		obj2 = "abracadabra";
		assertFalse( "Incorrect result", obj1.equals( obj2 ));
		assertFalse( "Incorrect result", obj1.equals( null ));
	}
	@Test
	public void testEmployee() {
		String   name     = "Jane Johansson";
		Seat  seat     = new Cockpit();
		double   salary   = 123456.78;
		Employee employee = new Employee( new String( name ), seat, salary );
		assertEquals( "Incorrect result", name, employee.getName() );
		assertEquals( "Incorrect result", seat, employee.getSeat() );
		String   string   = employee.toString();
		assertEquals( "Incorrect result", "Jane Johansson       | Cockpit | $123,456.78", string );
		
		Object obj1, obj2;
		
		obj1 = new Employee( "Janny Jansen", new Bulkhead(), 43521 );
		obj2 = new Employee( "Janny Jansen", new Bulkhead(), 43521 );
		assertTrue ( "Incorrect result", obj1.equals( obj2 ));
		
		obj2 = new Traveler( "Janny Jansen", new Bulkhead() );
		assertFalse( "Incorrect result", obj1.equals( obj2 ));

		obj2 = new Employee( "Janny Jansen", new Bulkhead(), 99999 );
		assertFalse( "Incorrect result", obj1.equals( obj2 ));

		obj2 = new Employee( "James Hannah", new Bulkhead(), 43521 );
		assertFalse( "Incorrect result", obj1.equals( obj2 ));
		
		assertFalse( "Incorrect result", obj1 instanceof Passenger );
		assertFalse( "Incorrect result", obj1 instanceof Pilot );
		assertFalse( "Incorrect result", obj1 instanceof FlightAttendant );
		
		obj2 = "abracadabra";
		assertFalse( "Incorrect result", obj1.equals( obj2 ));
		assertFalse( "Incorrect result", obj1.equals( null ));
	}
	@Test
	public void testPilot() {
		String   name   = "Jimi Hendrix";
		Seat  seat   = new FirstClass( "15D" );
		double   salary = 87000;
		Employee pilot  = new Pilot( new String( name ), seat, salary );
		assertEquals( "Incorrect result", name, pilot.getName() );
		assertEquals( "Incorrect result", seat, pilot.getSeat() );
		String   string = pilot.toString();
		assertEquals( "Incorrect result", "Jimi Hendrix         | First Class [15D] | $ 87,000.00", string );
		
		Object obj1, obj2;
		
		obj1 = new Pilot( "London Paris", new FirstClass( "5B" ), 13245 );
		obj2 = new Pilot( "London Paris", new Cockpit(),          13245 );
		assertTrue ( "Incorrect result", obj1.equals( obj2 ));
		
		obj2 = new Pilot( "London Paris", new Cockpit(), 13245 );
		assertTrue ( "Incorrect result", obj1.equals( obj2 ));

		obj2 = new Pilot( "Barcelona Diaz", new FirstClass( "5B" ), 13245 );
		assertFalse( "Incorrect result", obj1.equals( obj2 ));
		
		obj2 = new Employee( "London Paris", new FirstClass( "5B" ), 13245 );
		assertFalse( "Incorrect result", obj1.equals( obj2 ));
		
		assertFalse( "Incorrect result", obj1 instanceof Passenger );
		assertFalse( "Incorrect result", obj1 instanceof FlightAttendant );
		
		obj2 = "abracadabra";
		assertFalse( "Incorrect result", obj1.equals( obj2 ));
		assertFalse( "Incorrect result", obj1.equals( null ));
	}
	@Test
	public void testFlightAttendand() {
		String   name      = "Barbie Belanova";
		Seat  seat      = new Bulkhead();
		double   salary    = 37300;
		Employee attendant = new FlightAttendant( new String( name ), seat, salary );
		assertEquals( "Incorrect result", name, attendant.getName() );
		assertEquals( "Incorrect result", seat, attendant.getSeat() );
		String   string    = attendant.toString();
		assertEquals( "Incorrect result", "Barbie Belanova      | Bulkhead | $ 37,300.00", string );
		
		Object obj1, obj2;
		
		obj1 = new FlightAttendant( "Milan DiCaprio", new Bulkhead(), 37300 );
		obj2 = new FlightAttendant( "Milan DiCaprio", new Bulkhead(), 37300 );
		assertTrue ( "Incorrect result", obj1.equals( obj2 ));
		
		obj2 = new FlightAttendant( "Milan DiCaprio", new Cockpit(), 37300 );
		assertTrue ( "Incorrect result", obj1.equals( obj2 ));

		obj2 = new FlightAttendant( "Milan DiCaprio", new Bulkhead(), 28700 );
		assertFalse( "Incorrect result", obj1.equals( obj2 ));
		
		obj2 = new Employee( "Milan DiCaprio", new Bulkhead(), 37300 );
		assertFalse( "Incorrect result", obj1.equals( obj2 ));
		
		assertFalse( "Incorrect result", obj1 instanceof Pilot );
		assertFalse( "Incorrect result", obj1 instanceof Passenger );
		
		obj2 = "abracadabra";
		assertFalse( "Incorrect result", obj1.equals( obj2 ));
		assertFalse( "Incorrect result", obj1.equals( null ));
	}
	@Test
	public void testPassenger() {
		String   name      = "Jimmy Neutron";
		Seat  seat      = new Coach( "44G" );
		Traveler passenger = new Passenger( new String( name ), seat );
		assertEquals( "Incorrect result", name, passenger.getName() );
		assertEquals( "Incorrect result", seat, passenger.getSeat() );
		String   string   = passenger.toString();
		assertEquals( "Incorrect result", "Jimmy Neutron        | Coach       [44G]", string );
		
		Object obj1, obj2;
		
		obj1 = new Passenger( "Jimmy Neutron", new Coach( "44G" ));
		obj2 = new Passenger( "Jimmy Neutron", new Coach( "44G" ));
		assertTrue ( "Incorrect result", obj1.equals( obj2 ));
		
		obj2 = new Passenger( "Jimmy Neutron", new FirstClass( "9B" ));
		assertTrue ( "Incorrect result", obj1.equals( obj2 ));
		
		obj2 = new Traveler( "Jimmy Neutron", new Coach( "44G" ));
		assertFalse( "Incorrect result", obj1.equals( obj2 ));
		
		assertFalse( "Incorrect result", obj1 instanceof Employee );
		
		obj2 = "abracadabra";
		assertFalse( "Incorrect result", obj1.equals( obj2 ));
		assertFalse( "Incorrect result", obj1.equals( null ));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testPassengerCannotBeInTheCockpit() {
		String   name = "Rodrigo Rodriguez";
		Seat  seat = new Cockpit();
		new Passenger( name, seat );
	}
	@Test(expected = IllegalArgumentException.class)
	public void testPassengerCannotBeInTheBulkhead() {
		String   name = "Juan Juanes";
		Seat  seat = new Bulkhead();
		new Passenger( name, seat );
	}
}