
/**
 * @class Room - generate a bounded game grid defined as array of characters populated with Ghosts (G) and Walls (W). 
 * 
 * Size is limited to 4 to 78  characters wide, and 4 to 160 characters tall
 * 
 * This class is provided to students, and does not need to be changed for P1
 */

/**
 * @author David Conner (david.conner@cnu.edu)
 *
 */

public class Room {
	
	
	/** Define constants used to set data */
	public static final char GHOST 	    ='G';
	public static final char WALL 	    ='W';
	public static final char EMPTY	    =  46;  //183;	// This is centered dot
	public static final char DEPLOYED   =  64;  // This is a @
	
			
	/** Checks to see if non-empty character is at cell location 
	 * 
	 * @param room
	 * @param row
	 * @param col
	 * @return
	 */
	public static boolean isEmpty(char[][] room, int row, int col)
	{
		return (room[row][col] == EMPTY);

	}
	
	
	/** Checks to see if a ghost character is at cell location 
	 * 
	 * @param room
	 * @param row
	 * @param col
	 * @return
	 */
	public static boolean isGhost(char[][] room, int row, int col)
	{
		return (room[row][col] == GHOST);

	}
	
	
	/** Checks to see if a ghost character is at cell location 
	 * 
	 * @param room
	 * @param row
	 * @param col
	 * @return
	 */
	public static boolean isWall(char[][] room, int row, int col)
	{
		return (room[row][col] == WALL);

	}
	
	
	/** Check if two rooms are equivalent */
	public static boolean equals(char[][] room1, char[][] room2)
	{
		if (room1 == null || room2 == null) return false; // always assume null arrays are false
		
		if (room1.length != room2.length) return false;   // different sizes
		
		if (room1[0].length != room2[0].length) return false;   // different sizes
		
		for (int i=0; i < room1.length; i++)
			for (int j=0; j < room1[0].length; j++)
				if (room1[i][j] != room2[i][j]) return false;
		
		// Everything matched, so we are good
		return true;
		
	}
	
	/** This method returns the total number of ghosts in a room
	 * @param room
	 * @return integer number of ghosts
	 */
	public static int countGhosts(char[][] room)
	{
		int count = 0;
		if (room == null) return 0;
		
		for (int i=0; i < room.length; i++)
			for (int j=0; j < room[0].length; j++)
				if (room[i][j] == GHOST) ++count; // increment the ghost counter
		
		return count;
		
	}

	
	
	/** Display the grid room with characters
	 * 
	 * @param room - room defined as 2D array of characters
	 */
	public static void displayRoom(char[][] room)
	{
		if (room == null)
		{
			System.out.println(" Invalid room");
			return;
		}
		
		
		System.out.println();
		System.out.print("+");
		for (int i = 0; i < room[0].length;i++)
			System.out.print("_");
		
		System.out.print("+");
		System.out.println();
		
		for (int i = 0; i < room.length;i++)
		{
			System.out.print("|");
			for (int j = 0; j < room[i].length;j++)
			{
				System.out.print(room[i][j]);;
			}
			System.out.println("|");
		}

		System.out.print("+");
		for (int i = 0; i < room[0].length;i++)
			System.out.print("-");
		System.out.print("+");
		System.out.println();
		
	}
	
	/** Initialize the room as empty with no walls or ghosts */
	public static void initRoom(char[][] room)
	{
		if (room == null)
		{
			System.out.println(" Cannot initialize room because it is null!");
			return;
		}
		
		// Set all the cells to EMPTY character (centered dot)
		for (int i = 0; i < room.length;i++)
		{
			for (int j = 0; j < room[i].length;j++)
			{
				room[i][j] = EMPTY;
			}
		}
				
	}

	/** Create a room of given size with randomly positioned ghosts and walls
	 * 
	 * @param height	 - number of rows in array
	 * @param width		 - number of columns in array
	 * @param numGhosts	 - number of randomly placed ghosts to create
	 * @param numWalls	 - number of randomly placed walls to create
	 * @return  a 2D character array representing the defined room
	 */
	
	public static char[][] createRandomRoom(int height, int width, int numGhosts, int numWalls)
	{
		if (width < 0 || width > 78)
		{
			System.out.println(" Invalid width="+width+" - returning null array");
			return null;
		}
		if (height < 0 || height > 160)
		{
			System.out.println(" Invalid height="+height+" - returning null array");
			return null;
		}
		
		char[][] room = new char[height][width];
		
		initRoom(room);
		
		
		int entities = 0;
		for (int g=0; g<numGhosts+numWalls; g++)
		{
			// Generate a random location
			Location loc = new Location(height, width, true);
			int row = loc.row;
			int col = loc.col;
			
			int count = 0;
			while (!isEmpty(room, row, col))
			{
				count++;
				if (count > 10*width*height)
				{
					System.out.println(" Failed to find enough spaces in reasonable time- return null room");
					return null;
				}
				
				loc = new Location(height, width, true);
				row = loc.row;
				col = loc.col;
			}
			
			// Set the cell to the appropriate data
			if (entities >= numGhosts)
				room[row][col] = WALL;
			else
				room[row][col] = GHOST;
			
			++entities;
			
		}
		
		
		return room;
	}
	/** Create a room of predetermined size and fixed positions of ghosts and walls
	 * 
	 * @param room	 - selection number of the room (1, 2, 3 rooms defined)
	 * @return  a 2D character array representing the defined room
	 */
	public static char[][] createFixedRoom(int room)
	{
		
		switch (room)
		{
		case 1: // 5 x 5 with 3 ghosts and walls
			return create5x5Room();
			
		case 2: // 20 x 20 
			return create20x20Room();
		case 3: // 40 x 20
			return create40x20Room();
		}
		
		return null;
	}
	
	/** Create a 5x5 room with 4 ghosts and 5 walls
	 * @return  a 2D character array representing the defined room
	 */
	public static char[][] create5x5Room()
	{
		char[][] room = new char[5][5];
		initRoom(room);
		
		/* originally defined
		(0,0)+_____+
		     |·····|
		     |·WW··|
		     |·G··G|
		     |··WW·|
		     |G·G·W|
		     +-----+ */
		room[2][1] = GHOST;
		room[2][4] = GHOST;
		room[4][2] = GHOST;
		room[4][0] = GHOST;
		
		room[1][2] = WALL;
		room[3][3] = WALL;
		room[3][2] = WALL;
		room[1][1] = WALL;
		room[4][4] = WALL;
		
		return room;
	}
	
	/** Create a 20x20 room with 8 ghosts and 1 walls
	 * @return  a 2D character array representing the defined room
	 */
	public static char[][] create20x20Room()
	{
		char[][] room = new char[20][20];
		initRoom(room);
		
		for (int i=0; i < 20; i++)
			room[i][i] = WALL;
		
		room[ 4][ 8] = GHOST;
		room[ 4][10] = GHOST;
		room[ 6][ 8] = GHOST;
		room[ 6][12] = GHOST;
		room[12][ 8] = GHOST;
		room[12][10] = GHOST;
		room[14][ 8] = GHOST;
		room[14][12] = GHOST;
		
		return room;
	}
	
	/** Create a 40x20 room with 8 ghosts and 37 walls
	 * @return  a 2D character array representing the defined room
	 */
	public static char[][] create40x20Room()
	{
		char[][] room = new char[40][20];
		initRoom(room);
		
		for (int i=0; i < 40; i+= 5)
			for (int j=0; j < room[0].length;j++)
				room[i][j] = WALL;
		
		room[ 4][ 8] = GHOST;
		room[ 4][10] = GHOST;
		room[ 6][ 8] = GHOST;
		room[ 6][12] = GHOST;
		room[12][ 8] = GHOST;
		room[12][10] = GHOST;
		room[14][ 8] = GHOST;
		room[14][12] = GHOST;
		room[22][ 8] = GHOST;
		room[22][10] = GHOST;
		room[24][ 8] = GHOST;
		room[24][12] = GHOST;
		room[32][ 8] = GHOST;
		room[32][10] = GHOST;
		room[34][ 8] = GHOST;
		room[34][12] = GHOST;
		return room;
	}
	
	
	// Tester
	public static void main(String[] args)
	{
		
		System.out.println(" Sample rooms");
		char[][] room1 = createRandomRoom(40,20,40,100);
		displayRoom(room1);
		
		char[][] room2 = createFixedRoom(1);
		displayRoom(room2);
		
		char[][] room3 = createFixedRoom(2);
		displayRoom(room3);
		
		char[][] room4 = createFixedRoom(3);
		displayRoom(room4);
		
		System.out.println("  Wall     <"+WALL+">");
		System.out.println("  Ghost    <"+GHOST+">");
		System.out.println("  Empty    <"+EMPTY+">");
		System.out.println("  Deployed <"+DEPLOYED+">");
				
		
	}
	
}
