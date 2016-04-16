package glassdorr;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class PairsMapToSum {


	public HashSet pairsMapToSum(int [] a, int sum)
	{
		HashSet<Set<Integer>> hs = new HashSet<Set<Integer>>();
		
		//int i = 0;
		int j = 0;
		
		HashSet<Integer> diff = new HashSet<Integer>();
		
		for(int i=0; i < a.length; i++)
		{
			if(diff.contains(a[i]))
			{
				Set temp = new TreeSet<Integer>();
				temp.add(a[i]);
				temp.add(sum - a[i]);
				hs.add(temp);
			}
			else
			{
				int diff1 = sum - a[i];
				diff.add(diff1);
			}
		}
		
		System.out.println(hs.toString());
		return hs;
	}

	public static void main(String[] args) {
		
		int [] a = {2, 1, 4, -6, 12, 0, 8, 6, -2};
		PairsMapToSum p = new PairsMapToSum();
		p.pairsMapToSum(a, 6);
	}

}
