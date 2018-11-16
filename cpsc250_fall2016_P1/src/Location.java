/**
 * @class This class holds the cell indices (row, column) for a 2D array
 * 
 * The data is publicly accessible
 */

/**
 * @author David Conner (david.conner@cnu.edu)
 *
 */

import java.util.Random;


public class Location {
	/** row of the array */
	public int row;
	
	/** column of the array */
	public int col;
	
	
	/** Private instance of random number generator */
	private static Random rand = new Random();
	
	/** Construct location at (0, 0) */
	public Location()
	{
		row = 0;
		col = 0;
	}
	
	/** Copy constructor */
	public Location(Location loc)
	{
		row = loc.row;
		col = loc.col;
	}
	
	/** Construct location at given coordinates */
	public Location(int i, int j)
	{
		row = i;
		col = j;
	}
	
	/** Construct location at random point within max width (w) and height (h) 
	 * 
	 * @param height = height (number of rows)
	 * @param width  = width  (number of columns)
	 * @param random boolean flag to generated a random number otherwise (0,0)
	 */
	public Location(int height, int width, boolean random)
	{
		
		if (random)
		{
			row = rand.nextInt(height);
			col = rand.nextInt(width);
		}
		
			
	}
	/** formatted string that shows the row and column data */
	@Override
	public String toString() 
	{
		return String.format("(% 2d, % 2d)",row,col);
	}

	public boolean equals(Location loc)
	{
		return (loc.row == row) && (loc.col == col);
	}
	
	@Override
	public Location clone()
	{
		return new Location(row,col);	
	}
}
