package dynamicprog;

import java.util.Arrays;

public class MinJumpsArr {


	public static void minJumps(int [] a)
	{
		int n = a.length;
		int [] jumps = new int[n];
		int i, j ;
		
		if(n == 0 || a[0] == 0)
			return ;
		
		jumps[0] = 0;
		
		for(i = 1; i < n ; i++)
		{
			jumps[i] = Integer.MAX_VALUE;
			for(j =0 ; j< i; j++)
			{
				System.out.println(i+" " +" jumps[j] "+ j+" " +jumps[j]);
				if( i<=j +a[j] && jumps[j] != Integer.MAX_VALUE)
				{
					jumps[i] = Math.min(jumps[i], jumps[j]+1);
					break;
				}
			}
		}
		System.out.println(jumps[n-1]);
		System.out.println(Arrays.toString(jumps));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {1, 3, 6,9};
		minJumps(a);
	}

}
