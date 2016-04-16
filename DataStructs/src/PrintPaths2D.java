import java.util.ArrayList;


public class PrintPaths2D {

	public static ArrayList paths = new ArrayList();
	public static void printPaths(int i, int j, int m, int n, int [][]a, ArrayList path)
	{
		path.add(a[i][j]);
		if(i==m-1 && j == n-1)
		{
			paths.add(path);
			path = new ArrayList();
			return;
		}
		if (j+1 < n) {
			printPaths ( i, j+1, m, n, a, path);
		}
		//down
		if (i+1 < m) {
			printPaths (i+1, j, m, n, a, path);			
		}
		
		System.out.println("Paths are "+paths.toString());
	}
	public static void main(String[] args) {
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

		ArrayList path = new ArrayList();
		printPaths(0,0,a.length, a[0].length, a, path);
	}

}
