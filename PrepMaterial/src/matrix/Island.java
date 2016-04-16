package matrix;

public class Island {

	static int rowNbr[] = {-1, -1, -1,  0, 0,  1, 1, 1};
	static int colNbr[] = {-1,  0,  1, -1, 1, -1, 0, 1};
	
	public boolean isSafe(int [][] M, int row, int col, boolean [][] visited)
	{
		return ( (row >=0 && row < M.length) 
				&& (col >=0 && col < M[0].length)
				&& (M[row][col] == 1)
				&& (!visited[row][col]));
	}
	
	public void dfs(int [][] M, int row, int col, boolean [][] visited)
	{
		visited[row][col] = true;
		
		for(int k=0; k < 8; ++k)
		{
			if(isSafe(M, row+rowNbr[k], col+colNbr[k], visited))
			{
				dfs(M, row+rowNbr[k], col+colNbr[k], visited);
			}
		}
	}

	public int countIslands(int [][] M)
	{
		boolean [][] visited = new boolean[M.length][M[0].length];
		int count = 0;
		
		for(int i=0; i < M.length; ++i)
		{
			for(int j=0; j < M[0].length; ++j)
			{
				if(M[i][j] == 1 && !visited[i][j])
				{
					//System.out.println("Processing "+i+ " " +j);
					dfs(M, i, j, visited);
					++count;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int M[][] = {  
				{1, 1, 0, 0, 0},
		        {0, 1, 0, 0, 1},
		        {1, 0, 0, 1, 1},
		        {0, 0, 0, 0, 0},
		        {1, 0, 1, 0, 1}
		    };

		Island i = new Island();
		
		System.out.println(i.countIslands(M));
	}

}
