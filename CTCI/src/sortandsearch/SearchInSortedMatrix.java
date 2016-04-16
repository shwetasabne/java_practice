package sortandsearch;

import java.util.Arrays;

public class SearchInSortedMatrix {

	public static boolean findElement(int [][]a, int element)
	{
		int row = 0;
		int col = a[row].length-1;
		
		while(row <= a.length-1 && col >= 0)
		{
			if(a[row][col] == element)
				return true;
			if(a[row][col] > element)
			{
				col--;
			}
			else
			{
				row++;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		int [][] a = new int[4][4];
		
		a[0][0] = 15;
		a[0][1] = 20;
		a[0][2] = 40;
		a[0][3] = 85;
		
		a[1][0] = 20;
		a[1][1] = 35;
		a[1][2] = 80;
		a[1][3] = 95;
		
		a[2][0] = 30;
		a[2][1] = 55;
		a[2][2] = 95;
		a[2][3] = 105;
		
		a[3][0] = 40;
		a[3][1] = 80;
		a[3][2] = 100;
		a[3][3] = 120;
		
		for(int i=0; i < a.length; i++)
		{
			System.out.println(Arrays.toString(a[i]));
		}
		
		SearchInSortedMatrix m = new SearchInSortedMatrix();
		System.out.println(m.findElement(a, 92));
	}

}
