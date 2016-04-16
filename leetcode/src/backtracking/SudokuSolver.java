package backtracking;

public class SudokuSolver {

	public void solve(char [][] board)
	{
		if(board == null || board.length == 0)
			return ;
		
		solved(board);
		printBoard(board);
	}
	
	public void printBoard(char [][] board)
	{
		for(int i=0; i < board.length; i++)
		{
			for(int j=0; j < board[0].length; j++)
			{
				System.out.print(" " + board[i][j]);
			}
			System.out.println();
		}
	}
	
	public boolean solved(char [][] board)
	{
		for(int i=0; i < board.length; i++)
		{
			for(int j=0; j < board[0].length; j++)
			{
				if(board[i][j] == '.')
				{
					for(char num='1'; num <= '9'; num++)
					{

						if(isSafe(board, i, j, num))
						{
							board[i][j] = num;
							
							if(solved(board))
								return true;
							else
								board[i][j] = '.';
							
						}
					}
					return false;
				}
			}
		}

		return true;
	}
	
	public boolean isSafe(char [][] board, int i, int j, char c)
	{
		//check row
		for(int col = 0; col < board[0].length ; col++)
		{
			if(board[i][col] == c)
				return false;
		}
		
		//check col
		for(int row = 0; row < board.length; row++)
		{
			if(board[row][j] == c)
				return false;
		}
		
		//check bocl
		for(int row = i/3*3; row < i/3*3+3; row++)
		{
			for(int col = j/3*3; col <  j/3*3+3; col++)
			{
				if(board[row][col] == c)
					return false;
			}
		}
		return true;
			
	}
	public static void main(String[] args) {
		
		char[][] board = {
				{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
				{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
				{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
				{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
				{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
				{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
				{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
				{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
				{'.', '.', '.', '.', '8', '.', '.', '7', '9'},
		};

		SudokuSolver s = new SudokuSolver();
		s.solve(board);
	}

}
