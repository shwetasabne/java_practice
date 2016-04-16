package glassdoor;

import java.util.Arrays;

public class AddOneToArray {

	
	public static int [] addOne(int [] a)
	{
		int high = a.length - 1;
		
		int carry = 1;
		while(high >= 0)
		{
			int temp = a[high] + carry;
			if(temp >= 10)
			{
				a[high] = temp%10;
				carry = temp / 10;
				high--;
			}
			else
			{
				a[high] = temp;
				return a;
			}
		}
		if(carry > 0)
		{
			System.out.println("overflow happened");
		}
		return a;
	}
	
	public static void main(String[] args) {
		
		int [] a = {0, 0, 0, 1};
		int [] out = addOne(a);
		System.out.println(Arrays.toString(out));
		
	}

}
