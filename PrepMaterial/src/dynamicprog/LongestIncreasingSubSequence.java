package dynamicprog;

import java.util.Arrays;

public class LongestIncreasingSubSequence {


	public static void longestIncreasingDP(int [] a)
	{
		int n = a.length;
		int [] lis = new int[n];
		for(int i =0; i< n ; i++)
		{
			lis[i] = 1;
		}
		
		for(int i=1; i < n; i++ )
		{
			for(int j= 0; j < i; j++)
			{
				if(a[i] > a[j] && lis [i] < lis[j]+1)
					lis[i] = lis[j]+1;
			}
		}
		System.out.println(Arrays.toString(lis));
	}
	
	public static void maxSumInList(int [] a)
	{
		int n = a.length;
		int [] mis = new int [n];
		for(int i=0; i < n; i++)
		{
			mis[i] = a[i];
		}
		for(int i=1; i < n ; i++)
		{
			for(int j=0; j < i; j++)
			{
				if(a[i] > a[j] && mis[i] < mis[j]+a[i])
					mis[i] = mis[j] +a[i];
			}
		}
		System.out.println(Arrays.toString(mis));
	}
	
	public static void main(String[] args) {
		
		int [] a = {1, 101, 2, 3, 100, 4, 5};
		longestIncreasingDP(a);
		maxSumInList(a);
	}

}
