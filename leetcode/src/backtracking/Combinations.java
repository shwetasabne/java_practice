package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Combinations {

	public ArrayList<ArrayList<Integer>> getCombinations(int n, int k)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		int [] num = new int[n];
		for(int i=0; i <num.length; i++)
		{
			num[i] = i+1;
		}
		
		System.out.println(Arrays.toString(num));
		generateCombos(num, k, 0, temp, result);
		System.out.println(result.toString());
		return result;
	}
	
	public void generateCombos(int [] num, int k, int start, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result)
	{
		if(temp.size() == k)
		{
			ArrayList<Integer> t = new ArrayList<Integer>(temp);
			result.add(t);
			return;
		}
		for(int i=start; i < num.length; i++)
		{
			temp.add(num[i]);
			generateCombos(num, k, i+1, temp, result);
			temp.remove(temp.size()-1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Combinations c = new Combinations();
		c.getCombinations(4, 2);
	}

}
