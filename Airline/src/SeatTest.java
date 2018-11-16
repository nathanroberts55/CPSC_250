


import static org.junit.Assert.*;

import org.junit.Test;


public class SeatTest {

	@Test
	public void testSeating() {
		Seat seat     = new Seat( "1B" );
		String  location = seat.getLocation();
		assertEquals( "Incorrect result", "1B", location );
		String  string   = seat.toString();
		assertEquals( "Incorrect result", "1B", string );
		
		Object obj1, obj2;
		
		obj1 = new Seat( "24D" );
		obj2 = new Seat( "24D" );
		assertTrue ( "Incorrect result", obj1.equals( obj2 ));
		
		obj2 = new Seat( "24E" );
		assertFalse( "Incorrect result", obj1.equals( obj2 ));
		
		assertFalse( "Incorrect result", obj1 instanceof FirstClass );
		assertFalse( "Incorrect result", obj1 instanceof Bulkhead );
		assertFalse( "Incorrect result", obj1 instanceof Cockpit );
		assertFalse( "Incorrect result", obj1 instanceof Coach );

		obj2 = "abracadabra";
		assertFalse( "Incorrect result", obj1.equals( obj2 ));
		assertFalse( "Incorrect result", obj1.equals( null ));
	}
	@Test
	public void testCoach() {
		Seat seat     = new Coach( "7C" ); 
		String  location = seat.getLocation();
		assertEquals( "Incorrect result", "7C", location );
		String  string   = seat.toString();
		assertEquals( "Incorrect result", "Coach       [ 7C]", string );
		
		Object obj1, obj2;
		
		obj1 = new Coach( "14A" );
		obj2 = new Coach( "14A" );
		assertTrue ( "Incorrect result", obj1.equals( obj2 ));
		
		obj2 = new Seat( "14A" );
		assertFalse( "Incorrect result", obj1.equals( obj2 ));
		
		obj2 = new Coach( "8F" );
		assertFalse( "Incorrect result", obj1.equals( obj2 ));
		
		assertFalse( "Incorrect result", obj1 instanceof FirstClass );
		assertFalse( "Incorrect result", obj1 instanceof Bulkhead );
		assertFalse( "Incorrect result", obj1 instanceof Cockpit );
		
		obj2 = "abracadabra";
		assertFalse( "Incorrect result", obj1.equals( obj2 ));
		assertFalse( "Incorrect result", obj1.equals( null ));
	}
	@Test
	public void testFirstClass() {
		Seat seat     = new FirstClass( "21E" ); 
		String  location = seat.getLocation();
		assertEquals( "Incorrect result", "21E", location );
		String  string   = seat.toString();
		assertEquals( "Incorrect result", "First Class [21E]", string );
		
		Object obj1, obj2;
		
		obj1 = new FirstClass( "1A" );
		obj2 = new FirstClass( "1A" );
		assertTrue ( "Incorrect result", obj1.equals( obj2 ));
		
		obj2 = new Seat( "1A" );
		assertFalse( "Incorrect result", obj1.equals( obj2 ));
		
		obj2 = new FirstClass( "3B" );
		assertFalse( "Incorrect result", obj1.equals( obj2 ));
		
		obj2 = new Seat( "3B" );
		assertFalse( "Incorrect result", obj1.equals( obj2 ));
		
		assertFalse( "Incorrect result", obj1 instanceof Bulkhead );
		assertFalse( "Incorrect result", obj1 instanceof Cockpit );
		assertFalse( "Incorrect result", obj1 instanceof Coach );
		
		obj2 = "abracadabra";
		assertFalse( "Incorrect result", obj1.equals( obj2 ));
		assertFalse( "Incorrect result", obj1.equals( null ));
	}
	@Test
	public void testCockpit() {
		Seat seat     = new Cockpit(); 
		String  location = seat.getLocation();
		assertEquals( "Incorrect result", "Cockpit", location );
		String  string   = seat.toString();
		assertEquals( "Incorrect result", "Cockpit", string );
		
		Object obj1, obj2;
		
		obj1 = new Cockpit();
		obj2 = new Cockpit();
		assertTrue ( "Incorrect result", obj1.equals( obj2 ));
		
		obj2 = new Seat( "Cockpit" );
		assertFalse( "Incorrect result", obj1.equals( obj2 ));
		
		assertFalse( "Incorrect result", obj1 instanceof FirstClass );
		assertFalse( "Incorrect result", obj1 instanceof Bulkhead );
		assertFalse( "Incorrect result", obj1 instanceof Coach );
		
		obj2 = "abracadabra";
		assertFalse( "Incorrect result", obj1.equals( obj2 ));
		assertFalse( "Incorrect result", obj1.equals( null ));
	}
	@Test
	public void testBulkhead() {
		Seat seat     = new Bulkhead(); 
		String  location = seat.getLocation();
		assertEquals( "Incorrect result", "Bulkhead", location );
		String  string   = seat.toString();
		assertEquals( "Incorrect result", "Bulkhead", string );
		
		Object obj1, obj2;
		
		obj1 = new Bulkhead();
		obj2 = new Bulkhead();
		assertTrue ( "Incorrect result", obj1.equals( obj2 ));
		
		obj2 = new Seat( "Bulkhead" );
		assertFalse( "Incorrect result", obj1.equals( obj2 ));
		
		assertFalse( "Incorrect result", obj1 instanceof FirstClass );
		assertFalse( "Incorrect result", obj1 instanceof Cockpit );
		assertFalse( "Incorrect result", obj1 instanceof Coach );
		
		obj2 = "abracadabra";
		assertFalse( "Incorrect result", obj1.equals( obj2 ));
		assertFalse( "Incorrect result", obj1.equals( null ));
	}
}