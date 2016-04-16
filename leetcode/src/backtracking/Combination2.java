package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Combination2 {

	
	public ArrayList<ArrayList<Integer>> getCombination2(int [] num, int target)
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		Arrays.sort(num);
		
		getCombination(num, target, temp, result, 0);
		
		System.out.println(result.toString());
		return result;
	}
	
	public void getCombination(int [] num, int target, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result, int start)
	{
		if(target == 0)
		{
			ArrayList<Integer> t = new ArrayList<Integer>(temp);
			result.add(t);
			return;
		}
		
		for(int i=start; i < num.length ; i++)
		{
			temp.add(num[i]);
			getCombination(num, target-num[i], temp, result, i+1);
			temp.remove(temp.size()-1);
		}
	}

	public static void main(String[] args) {
		
		Combination2 c = new Combination2();
		int [] num  = {10,1,2,7,6,1,5};
		c.getCombination2(num, 8);

	}

}
