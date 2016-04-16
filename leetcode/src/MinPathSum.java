import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


public class MinPathSum {

	public static int getRightElement(int [][]a, int currI, int currJ)
	{
		int right = -1;
		int newJ = currJ+1;
		if(newJ < a[0].length)
		{
			right = a[currI][newJ];
		}
		return right;
	}
	
	public static int getDownElement(int [][]a, int currI, int currJ)
	{
		int down = -1;
		int newI = currI + 1;
		if(newI < a.length)
		{
			down = a[newI][currJ];
		}

		return down;
	}

	public static void  printPath(String tempString, int i, int j, int m, int n, int [][] arr, ArrayList all, int level)
	{

		
		ArrayList list = null;
		if(all.size() == level)
		{
			list = new ArrayList();
			all.add(list);
			
		}
		else {
			list = (ArrayList)all.get(level);
		}

		String newString = tempString + arr[i][j];
		list.add(arr[i][j]);
		System.out.println("Current element is "+arr[i][j]+ " level is "+level+ " list is "+list.toString());
		if (i == m -1 && j == n-1) {
			System.out.println(newString);
			level=level+1;
			System.out.println("returning with level "+level+ " "+all.toString());
			return;
		}
		
		//right
		if (j+1 < n) {
			printPath (newString, i, j+1, m, n, arr, all, level);
		}
		//down
		if (i+1 < m) {
			printPath (newString, i+1, j, m, n, arr, all, level);			
		}
	}
	public static void printPaths(int [][] a, int currI, int currJ, ArrayList all, ArrayList curr)
	{
	}
	
	public static void allPaths(int [][] a) 
	{
		ArrayList curr = new ArrayList();
		ArrayList all = new ArrayList();
		all.add(curr);
		printPaths(a, 0, 0, all, curr);
		System.out.println(all.toString());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]a = new int[4][3];
		
		int m = 4;
		int n = 3;
		a[0][0] = 3;
		a[0][1] = 4;
		a[0][2] = 1;
		
		a[1][0] = 6;
		a[1][1] = 0;
		a[1][2] = 5;
		
		a[2][0] = 2;
		a[2][1] = 8;
		a[2][2] = 9;
		
		a[3][0] = 7;
		a[3][1] = 1;
		a[3][2] = 2;
		
		printArr(a);
		
		ArrayList all = new ArrayList();
		ArrayList curr = new ArrayList();
	//	all.add(curr);
		printPath("", 0, 0, a.length, a[0].length, a, all, 0);
		System.out.println("Yaay" +all.toString());
	}
	
	public static void printArr(int [][]a)
	{
		for(int i=0; i < a.length; i++)
		{
			for(int j=0; j < a[0].length; j++)
			{
				System.out.print(a[i][j]+"  ");
			}
			System.out.println("");
		}
	}

}
