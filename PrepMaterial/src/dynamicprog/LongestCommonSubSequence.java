package dynamicprog;

import java.util.Arrays;

public class LongestCommonSubSequence {

	public static void longestCommonSubSequence(String a1, String b1)
	{
		char [] a = a1.toCharArray();
		char [] b = b1.toCharArray();
		
		int [][] lcs = new int[a1.length()+1][b1.length()+1];
		
		for(int i=0; i < a1.length(); i++)
		{
			for(int j=0; j < b1.length(); j++)
			{
				if(i==0 || j==0)
				{
					lcs[i][j] = 0;
				}
				else if(a[i-1] == b[j-1])
				{
					lcs[i][j] = lcs[i-1][j-1]+1;
				}
				else
				{
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
		}
		
		System.out.println(lcs[a1.length()-1][b1.length()-1]);
		int i = a1.length();
		String temp = "";
		int j = b1.length();
		while(i > 0 && j > 0)
		{
			//System.out.println(" "+i+" "+j);
			if(a[i-1] == b[j-1])
			{
				temp = temp +a[i-1];
				i--;
				j--;
			}
			else if(lcs[i-1][j] > lcs[i][j-1])
				i--;
			else
				j--;
		}
		System.out.println(temp);
	}
	public static void main(String[] args) {
		
		longestCommonSubSequence("AGGTAB", "GXTXAYB");
	}

}
