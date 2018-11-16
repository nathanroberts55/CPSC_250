import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author David Conner
 *
 */
public class GhostBustersTest {

	@Test
	public void testNumGhosts() {
		
		char[][] room = Room.createFixedRoom(1);
		int nGhosts = GhostBusters.numCapturedGhosts(room, 2, 0);
		assertEquals(" fixed room 5x5 num from (2,0) should be 3",3, nGhosts);
		
		nGhosts = GhostBusters.numCapturedGhosts(room, 4, 1);
		assertEquals(" fixed room 5x5 num from (4,1) should be 3",3, nGhosts);
	}

	@Test
public void testNumGhostsCollision() {
		
		char[][] room = Room.createFixedRoom(1);
		int nGhosts = GhostBusters.numCapturedGhosts(room, 2, 1);
		assertEquals(" fixed room 5x5 num from (2,1) should be 0 since collides with ghost",0, nGhosts);
		
		nGhosts = GhostBusters.numCapturedGhosts(room, 4, 0);
		assertEquals(" fixed room 5x5 num from (4,0) should be 0 since collides with ghost",0, nGhosts);
	}
	

	@Test
	public void testNumGhostsNull() {
		
		int nGhosts = GhostBusters.numCapturedGhosts(null, 2, 1);
		assertEquals(" A null room should return 0 ",0, nGhosts);
	}
	
	@Test
	public void testNumGhostsWallCollision() {
		
		char[][] room = Room.createFixedRoom(1);
		int nGhosts = GhostBusters.numCapturedGhosts(room, 1, 1);
		assertEquals(" fixed room 5x5 num from (1,1) should be 0 since collides with wall",0, nGhosts);
		
		nGhosts = GhostBusters.numCapturedGhosts(room, 3, 2);
		assertEquals(" fixed room 5x5 num from (3,2) should be 0 since collides with wall",0, nGhosts);
	}
	
	@Test
	public void testNumGhostsInvalidIndex() {
		
		char[][] room = Room.createFixedRoom(1);
		int nGhosts = GhostBusters.numCapturedGhosts(room, -1, 1);
		assertEquals(" fixed room 5x5 num from (-1,1) should be 0 since invalid index",0, nGhosts);
		
		nGhosts = GhostBusters.numCapturedGhosts(room, 3, -1);
		assertEquals(" fixed room 5x5 num from (3,-1) should be 0 since invalid index",0, nGhosts);
		
		nGhosts = GhostBusters.numCapturedGhosts(room, 5, 1);
		assertEquals(" fixed room 5x5 num from (5,1) should be 0 since invalid index",0, nGhosts);
		
		nGhosts = GhostBusters.numCapturedGhosts(room, 3, 5);
		assertEquals(" fixed room 5x5 num from (3,5) should be 0 since invalid index",0, nGhosts);
	}
	
	// @todo Create similar tests for findBestLocation
	// 
	@Test
	public void testFindBestLocationNull() {
		
		Location loc = GhostBusters.findBestLocation(null);
		assertTrue(" A null room should return (-1, -1) ",loc.equals(new Location(-1,-1)));
	}
	
	@Test
	public void testFindBestLocation5x5() {
		
		char[][] room = Room.createFixedRoom(1);
		Location loc = GhostBusters.findBestLocation(room);
		int nGhosts  = GhostBusters.numCapturedGhosts(room, loc.row, loc.col);
		assertEquals(" fixed room 5x5 num can capture 3",3, nGhosts);
	}
	
	
	// @todo Create similar tests for deployTrap
	@Test
	public void testDeployTrapNull() {
		
		char[][] new_world = GhostBusters.deployTrap(null, 1, 1);
		assertNull(" A null room should return for invalid world", new_world);
	}
	
	
	@Test
	public void testDeployTrapWall() {
		
		char[][] room = Room.createFixedRoom(1);
		
		char[][] new_room = GhostBusters.deployTrap(room, 1, 1); // busted trap on wall
		
		assertTrue(" Deploying trap on wall should not change room (busted trap) ",Room.equals(room, new_room));
	}
	
	@Test
	public void testDeployTrapGhost() {
		
		char[][] room = Room.createFixedRoom(1);		
		
		char[][] new_room = GhostBusters.deployTrap(room, 2, 1); // Ghost disables trap
		
		assertTrue(" Deploying trap on ghost should not change room (ghost disables trap) ",Room.equals(room, new_room));
	}
	
	
	@Test
	public void testDeployTrap5x5a() {
		
		char[][] room = Room.createFixedRoom(1);		
		
		char[][] new_room = GhostBusters.deployTrap(room, 2, 0); // Ghost disables trap
		
		char[][] test_room = {{'@','.','.','.','.'},
							  {'@','W','W','.','.'},
							  {'@','@','@','@','@'},
							  {'@','.','W','W','.'},
							  {'@','.','G','.','W'}};
		assertTrue(" Invalid deployment - see example ",Room.equals(test_room, new_room));
	}
	
	@Test
	public void testDeployTrap5x5b() {
		
		char[][] room = Room.createFixedRoom(1);		
		
		char[][] new_room = GhostBusters.deployTrap(room, 3, 1); // Ghost disables trap
		
		char[][] test_room = {{'.','.','.','.','.'},
							  {'.','W','W','.','.'},
							  {'.','@','.','.','G'},
							  {'@','@','W','W','.'},
							  {'G','@','G','.','W'}};
		assertTrue(" Invalid deployment - make sure you are stopping at walls ",Room.equals(test_room, new_room));
	}
	

}
