package backtracking;

import java.util.ArrayList;

public class SubSets {

	public void getSubSets(int [] nums)
	{
		
		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		
		generateSubSets(nums, 0, output, temp);
		System.out.println(output.toString());
	}
	
	public void generateSubSets(int [] nums, int start, ArrayList<ArrayList<Integer>> output, ArrayList<Integer> temp)
	{
		ArrayList<Integer> t = new ArrayList<Integer>(temp);
		output.add(t);
		
		for(int i= start; i < nums.length; i++)
		{
			temp.add(nums[i]);
			generateSubSets(nums, i+1, output, temp);
			temp.remove(temp.size() -1);
		}
	}

	public static void main(String[] args) {
		
		SubSets s = new SubSets();
		int [] nums = {1,2,3};
		s.getSubSets(nums);
	}

}
