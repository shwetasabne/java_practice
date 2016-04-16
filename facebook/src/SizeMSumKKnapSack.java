import java.util.ArrayList;


public class SizeMSumKKnapSack {


	public ArrayList<Integer> findSubSet(ArrayList<Integer> currSet, int sum, int size, int currIndex, int currSum, int [] input)
	{
		if(currSum > sum)
			return null;
		
		if(currIndex == input.length-1)
			return null;
		
		if(currSet.size() == size)
		{
			if(currSum == sum)
			{
				System.out.println(" curr "+currIndex);
				return currSet;
			}
			else
				return null;
		}
		
		ArrayList<Integer> with = (ArrayList<Integer>)currSet.clone();
		
		with.add(input[currIndex]);
		//System.out.println(with);
		with = findSubSet(with, sum, size, currIndex+1, currSum+input[currIndex], input);

		if(with != null)
			return with;
		else
		{
			ArrayList<Integer> without = (ArrayList<Integer>)currSet.clone();
			without = findSubSet(without, sum, size, currIndex+1, currSum, input);
			return without;
		}

			
	}
	public static void main(String[] args) {
		
		int [] a = {1,2,3,3,5,6,7};
		SizeMSumKKnapSack m  = new SizeMSumKKnapSack();
		ArrayList currSet = new ArrayList();
		ArrayList out  = m.findSubSet(currSet, 9, 2, 0, 0, a);
		//System.out.println(out.toString());
	}

}
