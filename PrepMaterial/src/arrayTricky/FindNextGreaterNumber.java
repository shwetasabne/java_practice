package arrayTricky;

import java.util.Arrays;

public class FindNextGreaterNumber {


	public static void findNext (char [] digits)
	{
		int i = 0;
		
		for(i = digits.length-1; i > 0; i--)
		{
			if (digits[i] > digits[i-1])
			{
				break;
			}
		}
		if(i == 0)
		{
			System.out.println("not possible");
		}
		
		int d =  Integer.valueOf(String.valueOf(digits[i]));
		System.out.println("d is "+d);
		// find smallest digit on right side of d
		int smallestIndex  = i;
		for(int x = i+1; x < digits.length; x++)
		{
			System.out.println(" Num i s " +digits[x]+" "+d);
			if( Integer.valueOf(String.valueOf(digits[x])) < d)
			{
				smallestIndex = x;
				d = Integer.valueOf(String.valueOf(digits[x]));
			}
		}
		System.out.println("smallest us "+smallestIndex+" "+d);
		//swap i-1 and smallestIndex
		
		char temp = digits[smallestIndex];
		digits[smallestIndex] = digits[i-1];
		digits[i-1] = temp;
		System.out.println(Arrays.toString(digits));
		
		//Sort form i to end
		Arrays.sort(digits, i, digits.length-1);
		System.out.println(Arrays.toString(digits));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String m  = "218765";
		findNext(m.toCharArray());
	}

}
