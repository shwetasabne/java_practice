package matrix;

public class RotateArray {


	public void rotateArray(int [][] a)
	{
		int row = 0;
		int col = 0;
		
		int m = a.length;
		int n = a[0].length;
		
		while(row < m && col < n)
		{
			int prev = a[row+1][col];
			
			// First row, so col will change
			for(int i= col; i < n; i++ )
			{
				int curr = a[row][i];
				a[row][i] = prev;
				prev = curr;
			}
			row ++;
			
			// Last col, so row will change
			for(int i= row; i < m; i++)
			{
				int curr = a[i][n-1];
				a[i][n-1] = prev;
				prev = curr;
			}
			n--;
			
			// Last row
			if(row < m)
			{
				for(int i= n-1; i >= col; i--)
				{
					int curr = a[m-1][i];
					a[m-1][i] = prev;
					prev = curr;
				}
				m--;
			}
			
			if(col < n)
			{
				for(int i= m-1; i >= row; i--)
				{
					int curr = a[i][col];
					a[i][col] = prev;
					prev = curr;
				}
				col++;
			}
		}
	}
	
	public void printMatrix(int [][] a)
	{
		for(int i=0; i < a.length; i++)
		{
			for(int j=0; j < a[0].length; j++)
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		
		RotateArray r = new RotateArray();
		
		int a[][] = { 
				{1,  2,  3,  4},
		        {5,  6,  7,  8},
		        {9,  10, 11, 12},
		        {13, 14, 15, 16}  };

		r.printMatrix(a);
		r.rotateArray(a);
		System.out.println();
		r.printMatrix(a);
	}

}
