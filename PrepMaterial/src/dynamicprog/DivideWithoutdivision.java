package dynamicprog;

import java.util.Arrays;

public class DivideWithoutdivision {


	public static int[] getQuotientRemainder(int dividend, int divisor)
	{
		int [] qr = new int[2];
		
		int q = 0;
		int rmd = 0;
		while( dividend >= divisor)
		{
			dividend = dividend - divisor;
			q++;
		}
		qr[0] = q;
		qr[1] = dividend;
		return qr;
	}
	public static void main(String[] args) {
		
		int [] q = getQuotientRemainder(10, 3);
		System.out.println(Arrays.toString(q));
		
	}

}
