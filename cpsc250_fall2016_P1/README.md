# Project Description #

For this project, we will implement a simple game played on a 2D grid. The object of the game is to capture ghosts in a room using ghost traps, while accounting for walls that block our traps from working.

At the start of the game, each space in the grid contains a ghost or a wall. We have one and only one turn in which to place a ghost trap. We must decide where to deploy our ghost trap for maximum effect.

When activated, our trap sends out 4 beams in the North, East, South, and West directions. The beam captures all ghosts it encounters before it is stopped by the edges of room, or blocked by an internal wall.

We get to choose where we deploy the trap, but we only have one trap.  Therefore,
we want to maximize the number of ghosts caught.  The ghosts cannot escape the trap,
UNLESS the trap lands on a cell occupied by a ghost.  In that case the ghost can disable the trap before it works, and we lose our one and only trap (0 ghosts caught).

If the trap is deployed on top of a wall it is destroyed, and 0 ghosts are caught.

Any invalid indices (outside of array bounds) will result in 0 ghosts caught.

# Project Implementation #

We will model our room as a two dimensional array of characters:

* G = ghost
* W = wall
* · = empty (ASCII code 183)
* @ = path of ray (ASCII code 64)

When the code has been completed, the output from main() will look like this:

    +_____+
    |·····|
    |·WW··|
    |·G··G|
    |··WW·|
    |G·G·W|
    +-----+

     Original room contains 4 ghosts!
     Number of trapped ghosts from location (2,0) =3
                               (For fixed room 1 this should be 3)
      The best location is ( 2,  0) num captured Ghosts=3

    +_____+
    |@····|
    |@WW··|
    |@@@@@|
    |@·WW·|
    |@·G·W|
    +-----+
     New      room contains 1 ghosts!
                               (For fixed room 1 this should be 1)

The **+**, **-**, and **|** are just there for illustration and are not part of the array.

The project comes with two helper classes.

* **Location.java** : Simple class that holds public row, column indices to locate a single cell in the room and allows generating random locations. Do *not* modify this class.
* **Room.java** : A class with static functions that create and display a variety of rooms. Do *not* modify this class.
* **GhostBuster.java** : A shell class for coding your work. Start here and fill in the code where indicated.

You will write three methods:

1. Write the method **numGhosts** to calculate the number of ghosts that will be trapped from a given location given a 2D array for the game board.
2. Write the method **findBestLocation** to choose the Location to deploy the trap.
3. Write a third method, **deployTrap**, that *creates a copy* of our original room array, modifies
the contents of the new array based on where we deployed the trap, and returns the new array without
modifying the first.

You are given some basic JUnit tests that work with a few of the simple rooms.
These are starters only; you should add tests as needed to throughly test your code.  
Your code should work with arrays of any (rectangular) shape up to 78 x 78, and
any configuration of ghosts and walls.  The methods should protect against invalid
array cell indices.

Follow directions at http://www.pcs.cnu.edu/cs150lab/cpsc-lab-git.pdf for cloning this project and setting up your Eclipse project.
Make sure to add your instructor to your forked project, and your fork set to *PRIVATE* !
That is, "keep it secret! keep it safe!" https://www.youtube.com/watch?v=_YhpauKGgQ4 
