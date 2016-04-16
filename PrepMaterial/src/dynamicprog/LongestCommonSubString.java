package dynamicprog;

public class LongestCommonSubString {


	public static int longestCommonSub(String a1, String b1)
	{
		char [] a = a1.toCharArray();
		char [] b = b1.toCharArray();
		
		int [][] lc  = new int [a1.length()+1][b1.length()+1];
		int res = 0;
		int minStart = Integer.MAX_VALUE;
		int maxEnd = Integer.MIN_VALUE;
		for(int i=0; i < a.length; i++)
		{
			for(int j=0; j < b.length; j++)
			{
				//System.out.println(" i is "+i+" j is "+j+" "+b.length);
				if(i == 0 || j == 0)
				{
					lc[i][j] = 0;
				}
				else if(a[i-1] == b[j-1])
				{
					lc[i][j] = lc[i-1][j-1]+1;
				//	System.out.println(" Here i = "+i+"  j="+j);
					//if(i == j)
					{
						minStart = Math.min(minStart, i);
					//	maxEnd = Math.max(maxEnd, j);
					}
					res = Math.max(res, lc[i][j]);
				}
				else
				{
					lc[i][j] = 0;
				}
			}
		}
		System.out.println(minStart +" "+ a1.substring(minStart-1, minStart-1+res));
		

		return res;
	}
	
	public static void main(String[] args) {
		
		String s1 = "Site:GieeksforGeeks.org";
		String s2 = "NewSite:GeeksQuiz.com";
		
		System.out.println(longestCommonSub(s1, s2));

	}

}
