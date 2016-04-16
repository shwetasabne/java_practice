package dynamicprog;

public class LongestEqualHalfs {

	/**
	 * Using same concept as finding the longest palindrome
	 * @param args
	 */
	public static int maxEqualSum(int [] a)
	{
		int maxLen = 0;
		int n = a.length;
		for(int i=0; i <= n-2; i++)
		{
			int l = i; 
			int r = i+1;
			
			int lSum = 0;
			int rSum = 0;
			while(l >=0 && r < n)
			{
				lSum += a[l];
				rSum += a[r];
				if(lSum == rSum)
				{
					System.out.println(" "+l+" "+r);
					maxLen = Math.max(maxLen, r-l+1);
				}
				l--;
				r++;
			}
		}
		return maxLen;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {1, 5, 3, 8, 0, 2, 3};
		System.out.println(maxEqualSum(a));	
	}

}
