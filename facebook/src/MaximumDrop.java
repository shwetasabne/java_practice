
public class MaximumDrop {

	public static int findMaximumDrop(int [] a)
	{
		int minIndex = 0;
		int maxDrop = 0;
		for(int i=1; i < a.length; i++)
		{
			if(a[i] < a[minIndex])
			{
				minIndex = a[i];
			}
			else
			{
				maxDrop = Math.max(maxDrop, a[i]-a[minIndex]);
			}
		}
		return maxDrop;
	}
	
	public static void main(String[] args) {
		
		int [] a = {10, 1, 5, 14, 0, -5};

		System.out.println(findMaximumDrop(a));
	}

}
