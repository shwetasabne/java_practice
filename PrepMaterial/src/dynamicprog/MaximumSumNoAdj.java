package dynamicprog;

import java.util.Arrays;

public class MaximumSumNoAdj {


	public static int getNonAdjMax(int [] a)
	{
		int [] table = new int[a.length];
		
		table[0] = a[0];
		table[1] = a[1];
		
		for(int i=2; i < a.length; i++)
		{
			table[i] = Math.max(a[i]+table[i-2], a[i]);
		}
		System.out.println(Arrays.toString(table));
		return table[table.length-1];
		
	}
	
	public static void main(String[] args) {
		
		int [] a = {5,5,10,40,50,35};
		int out = getNonAdjMax(a);
		int [] b = {3, 2, 5, 10, 7};
		out = getNonAdjMax(b);
	}

}
