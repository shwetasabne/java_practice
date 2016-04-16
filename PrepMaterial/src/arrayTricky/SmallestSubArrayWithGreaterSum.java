package arrayTricky;

public class SmallestSubArrayWithGreaterSum {

	public int smallestSubArry(int [] a, int x)
	{
		int start = 0;
		int end = 0;
		int minSize = a.length+1;
		
		int currSum = 0;
		while(end < a.length)
		{
			System.out.println("end is "+end + " "+start+" "+currSum);
			while(currSum < x && end < a.length)
			{
				currSum+=a[end++];
			}
			
			while(currSum >= x && start < end)
			{
				if(end - start < minSize)
				{
					minSize = end-start;
				}
				currSum-=a[start++];
			}
		}
		return minSize;
	}
	
	public static void main(String[] args) {
		
		int [] a = {1, 4, 45, 6, 0, 19};
			
		SmallestSubArrayWithGreaterSum m = new SmallestSubArrayWithGreaterSum();
		System.out.println(m.smallestSubArry(a, 51));

	}

}
