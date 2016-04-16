package geekforgeeks;

public class RowWithMaxOne {

	public static int firstIndex(int [] a, int low, int high)
	{
		
		while(low <= high)
		{
			int mid = low+ (high-low)/2;
	//		System.out.println(" *** low is "+low+" hight "+high+" mid "+ mid);
			if(mid == 0)
			{
				return mid;
			}
		//	System.out.println(" *** mid is "+mid);
			if(a[mid] == 1 && a[mid-1] == 0)
				return mid;
			if( a[mid] == 0)
				low = mid+1;
			else
				high = mid -1;
		}
		return -1;
	}

	public static int rowWithMaxOne(int [][]a)
	{
		int ret = 0;
		
		for(int i=0; i < a.length; i++)
		{
			int index = firstIndex(a[i], 0, a[i].length-1);
			System.out.println(i+" index is "+index);
		}
		return ret;
	}
	public static void main(String[] args) {
		
		int [][] a = new int [4][4];
		for(int i =0; i < a.length; i++)
		{
			for(int j=0; j < a[0].length; j++)
			{
				a[i][j] = 0;
			}
		}
		a[0][1] = 1;
		a[0][2] = 1;
		a[0][3] = 1;
		
		a[1][2] = 1;
		a[1][3] = 1;
		
		a[2][0] = 1;
		a[2][1] = 1;
		a[2][2] = 1;
		a[2][3] = 1;
		
		for(int i =0; i < 4; i++)
		{
			for(int j=0; j < 4; j++)
			{
				System.out.print("  " + a[i][j]);
			}
			System.out.println();
		}
		rowWithMaxOne(a);
	}
	

}
