package dynamicprog;

public class CountAllPathsIn2DArr {

	/**
	 * @param args
	 */
	public static int countPathNoDP(int m, int n)
	{
		if(m == 1|| n==1)
			return 1;
		
		return countPathNoDP(m-1,n)+countPathNoDP(m, n-1);
	}
	
	public static int countPathDP(int m, int n)
	{
		int [][] count = new int[m][n];
		for(int i=0; i< m; i++)
			count[i][0] = 1;
		for(int j=0; j < n; j++)
			count[0][j] = 1;
		
		for(int i=1; i< m ; i++)
		{
			for(int j=1; j < n; j++)
			{
				//System.out.println(i + " "+j);
				count[i][j] = count[i-1][j] + count[i][j-1];
			}
		}
		return count[m-1][n-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countPathNoDP(3,3));
		System.out.println(countPathDP(3,3));
	}

}
