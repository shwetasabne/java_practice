package moderate;

public class ContinuousSequenceSum {


	public static int maxSum(int [] a)
	{
		int m = a[0];
		
		int max_so_far = a[0];
		
		for(int i = 1; i < a.length; i++)
		{
			max_so_far = Math.max(a[i], max_so_far+a[i]);
			m = Math.max(max_so_far, m);
		}
		return m;
	}
	
	public static void main(String[] args) {
		
		int[] a = {-2, -1, -8};
		System.out.println(maxSum(a));
	}

}
