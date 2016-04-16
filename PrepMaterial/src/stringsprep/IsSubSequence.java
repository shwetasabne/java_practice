package stringsprep;

import java.util.Arrays;

public class IsSubSequence {

	public boolean isSubSequence(char [] big, char[] small, int m, int n)
	{
		System.out.println(Arrays.toString(big)+" "+ Arrays.toString(small)+" "+m+" "+n);
		if(n == 0) return true;
		if(m == 0) return false;
		
		
		if(big[m-1] == small[n-1])
		{
			System.out.println("Checking this");
			return isSubSequence(big, small, m-1, n-1);
		}

		return isSubSequence(big, small, m-1, n);

	}
	
	public static void main(String[] args) {
		
		String s1 = "ADXCPY";
		String s2 = "AZY";
		
		IsSubSequence i = new IsSubSequence();
		System.out.println(i.isSubSequence(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
		
	}

}
