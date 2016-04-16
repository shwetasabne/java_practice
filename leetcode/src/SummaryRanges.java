import java.util.ArrayList;
import java.util.List;


public class SummaryRanges {

	public static List<String> summaryRanges(int[] nums) {
        
		List<String> newList = new ArrayList();
		if(nums.length == 0)
			return newList;
		if(nums.length == 1)
		{
			String temp = ((Integer)nums[0]).toString();
			newList.add(temp);
			//System.out.println(newList.toString());
			return newList;
		}
		int i=0;
		int j=0;
		while(i < nums.length-1)
		{
			if(nums[i+1] - nums[i] == 1)
			{
				i++;
			}
			else
			{
				if(nums[i] != nums[j])
				{
					String temp = nums[j] + "->" + nums[i];
					newList.add(temp);
				}
				else
				{
					String temp = ((Integer)nums[i]).toString();
					newList.add(temp);
				}
				
				i++;
				j=i;
			}
		}
		if(nums[i] - nums[i-1] == 1)
		{
			String temp = nums[j] + "->" + nums[i];
			newList.add(temp);
		}
		else
		{
			String temp = ((Integer)nums[i]).toString();
			newList.add(temp);
		}
		System.out.println(i+ " " + j + " "+ newList.toString());
		return newList;
    }
	
	public static void main(String[] args) {
		
		int [] a = {1,3,4,5,90};
		summaryRanges(a);

	}

}
