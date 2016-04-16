package glassdoor;

public class MaximumSubArray {

	public int maximumSum(int [] a)
	{
		int max_sum_so_far = a[0];
		int	max_sum_ending_here = a[0];
		int max_index = -1;
		for(int i = 1; i < a.length; i++)
		{
			max_sum_ending_here = Math.max(a[i], max_sum_ending_here+a[i]);
			
			if(max_sum_ending_here > max_sum_so_far)
			{
				max_sum_so_far = max_sum_ending_here;
				max_index = i;
				
			}
			max_sum_so_far = Math.max(max_sum_ending_here, max_sum_so_far);
			
		}
		System.out.println("max sum is "+max_sum_so_far+ " "+max_index);
		return max_sum_so_far;
	}
	public static void main(String[] args) {
		
		MaximumSubArray s = new MaximumSubArray();
		int [] a=  {2, 1, -1, 1, 1, -2, -1, 0, -1};
		int out = s.maximumSum(a);
		System.out.println("Max sum is "+out);

	}

}
