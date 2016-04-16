package backtracking;

import java.util.Arrays;

public class NQueenProblem {


	public static boolean isSafe(int col, int Qi, int [] board)
	{
		for(int i=0; i < Qi; i++)
		{
			if(board[i] == col)
				return false;
			
			if(Math.abs(board[i] - col) == Math.abs(i - Qi))
				return false;
		}
		return true;
	}
	
	public static int solnCounter = 0;
	public static void placeQueens(int Qi, int [] board)
	{
		if(Qi == board.length)
		{
			System.out.println("Printing solution "+solnCounter);
			System.out.println(Arrays.toString(board));
			//Row or Queen
			for(int i=0; i < board.length; i++)
			{
				// Col
				for(int j=0; j < board.length; j++)
				{
					if(board[i] == j)
					{
						System.out.print(" " + "Q");
					}
					else
					{
						System.out.print(" " + ".");
					}
				}
				System.out.println();
			}
			solnCounter++;
		}
		else
		{
			for(int i=0; i < board.length; i++)
			{
				if(isSafe(i, Qi, board))
				{
					board[Qi] = i;
					placeQueens(Qi+1, board);
					board[Qi] = -1;
				}
			}
		}
	}

	public static void main(String[] args) {
		int [] board = new int[8];
		placeQueens(0, board);

	}

}
