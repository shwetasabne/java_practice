package dynamicprog;

public class RemoveMinElementsFrom2Sides {


	public static int minElemnts(int [] a)
	{
		int longest_start = -1;
		int longest_end = 0;
		
		for(int start = 0; start < a.length; start++)
		{
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			//System.out.println("Broken *****");
			for(int end = start; end < a.length; end++)
			{
				//System.out.println("inner loop ...");
				int val = a[end];
				if(val < min) min = val;
				if(val > max) max = val;
				
				System.out.println("start:"+start+" end:"+end+" val:"+val + " min:"+min
						+ " max:"+max + " ls:"+longest_start + " le:"+longest_end);
				if(2*min <= max)
				{
					System.out.println("breaking...");
					break;
				}
				if(end - start > (longest_end - longest_start) || longest_start == -1)
				{
					longest_end = end;
					longest_start = start;
				}
			}
		}
		
		System.out.println("longest start "+longest_start);
		System.out.println("longest end "+longest_end);
		return -1;
	}
	public static void main(String[] args) {
		
		int arr[] = {4, 5, 100, 9, 10, 11, 12, 15, 200};
		minElemnts(arr);
	}

}
