package geekforgeeks;

import java.util.*;

public class CountDistinctPais {


	public static int countDistinctPairs(int []a, int num)
	{
		int count = 0;
		
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
		
		for(int i=0; i<a.length; i++)
		{
			m.put(a[i], i);
		}
		System.out.println(m.toString());
		for(int i=0; i < a.length; i++)
		{
			int x = a[i];
			
			if( (x-num >= 0) && m.containsKey(x-num))
			{
				System.out.println(" Pair "+x+" "+(x-num));
				count++;
			}
			if( (x+num) < Integer.MAX_VALUE && m.containsKey(x+num) )
			{
				System.out.println(" Pair "+x+" "+(x+num));
				count++;
			}
			m.remove(x);
		}
		System.out.println("Found "+count+ " distinct pairs");
		return count;
	}
	
	public static void main(String[] args) {
		
		int [] a = {8, 12, 16, 4, 0, 20};
		countDistinctPairs(a, 4);

	}

}
