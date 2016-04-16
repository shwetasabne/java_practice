package backtracking;

import java.util.ArrayList;

public class Combination3 {

	public ArrayList<ArrayList<Integer>> getCombination3 (int k, int n)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		if(n > 9)
			return null;
		
		int [] num = {1,2,3,4,5,6,7,8,9};

		getCombination(k, num, 0, temp, result, n);
		System.out.println(result.toString());
		return result;
	}
	
	public void getCombination(int size, int [] num, int start, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result, int target)
	{
		if(target == 0)
		{
			ArrayList<Integer> t = new ArrayList<Integer>(temp);
			if(t.size() == size)
			{
				result.add(t);	
			}
			return; 
		}
		
		for(int i= start; i < num.length; i++)
		{
			temp.add(num[i]);
			getCombination(size, num, i+1, temp, result, target-num[i]);
			temp.remove(temp.size() -1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Combination3 c = new Combination3();
		c.getCombination3(3, 9);
	}

}
