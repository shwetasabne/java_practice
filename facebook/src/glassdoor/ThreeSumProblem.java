package glassdoor;

import java.util.Arrays;

public class ThreeSumProblem {

	
	public static void findThreeSum(int [] a, int sum )
	{
		int l=0;
		int r = 0;
		
		Arrays.sort(a);
		for(int i=0; i < a.length; i++)
		{
			l = 0;
			r = a.length -1 ;
			while(l < r)
			{
				if( (a[i] + a[l] + a[r]) == sum)
				{
					System.out.println(" found "+a[i]+" "+a[l]+" "+a[r]);
					return ;
				}
				if( (a[i] + a[l] + a[r]) < sum )
				{
					l++;
				}
				else
				{
					r--;
				}
			}
		}
	}

	public static void main(String[] args) {
		
		int [] a = {-2, 0, 1, 1, 10, 8};
		findThreeSum(a, 0);
	}

}
