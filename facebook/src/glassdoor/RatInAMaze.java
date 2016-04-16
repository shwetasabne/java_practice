package glassdoor;

public class RatInAMaze {


	public boolean isSafe(int [][] maze, int currX, int currY, int destX, int destY)
	{
		if(currX >= 0 && currX <= destX && currY >= 0 && currY <= destY)
		{
			if(maze[currX][currY] == 1)
				return true;
			else
				return false;
		}
		return false;
	}
	public boolean isPossible(int [][] maze, int currX, int currY, int destX, int destY)
	{
		if(currX == destX && currY == destY)
			return true;
		
		if(isSafe(maze, currX, currY, destX, destY))
		{
			if(isPossible(maze, currX+1, currY, destX, destY))
				return true;
			
			if(isPossible(maze, currX, currY+1, destX, destY))
				return true;
			
			else
				return false;
		}
		return false;
		
	}

	public static void main(String[] args) {
	
		int [][] maze = {
				{1, 0, 0 , 0},
				{1, 1, 0, 1 },
				{0, 1 , 1 , 0},
				{1, 1, 1, 1}
		};
		
		RatInAMaze r = new RatInAMaze();
		System.out.println(r.isPossible(maze, 0, 0, 3, 3));
		

	}

}
