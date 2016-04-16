package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Combination1 {

	public ArrayList<ArrayList<Integer>> getCombination1(int[] num, int target)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		Arrays.sort(num);
		
		getCombination(0, target, temp, result, num);
		System.out.println(result.toString());
		return result;
	}
	
	public void getCombination(int start, int target, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result, int [] num)
	{
		if(target == 0)
		{
			ArrayList<Integer> t = new ArrayList<Integer>(temp);
			result.add(t);
			return;
		}
		for(int i=start; i < num.length; i++)
		{
			if(target < num[i]) 
	            return;
			//System.out.println("i is "+i);
			temp.add(num[i]);
			getCombination(i, target-num[i], temp, result, num);
			temp.remove(temp.size() -1 );
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Combination1  c1 = new Combination1();
		int [] num = {2,3,6,7};
		c1.getCombination1(num, 7);
	}

}
