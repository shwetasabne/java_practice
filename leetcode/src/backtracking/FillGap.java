package backtracking;

import java.util.Arrays;

public class FillGap {


	public static boolean fillGap(int [] a, int gap)
	{
		if(gap == 0)
			return true;
		for(int i= a.length-1; i-gap >=0; i--)
		{
			System.out.println(" i is "+i+" gap is "+gap+" ");
			if(a[i] == 0 && a[i-gap-1] == 0)
			{
				a[i] = gap;
				a[i-gap-1] = gap;
				if(fillGap(a, gap-1))
				{
					return true;
				}
				else
				{
					a[i] = 0;
					a[i-gap-1] = 0;
				}
			}

		}
		return false;
	}
	public static void main(String[] args) {
		
		int n  = 2 ;
		int [] a = new int[n*2];
	//	System.out.println(Arrays.toString(a));

		fillGap(a, n);
		
		System.out.println(Arrays.toString(a));

	}

}
