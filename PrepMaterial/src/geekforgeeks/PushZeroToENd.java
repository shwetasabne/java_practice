package geekforgeeks;

import java.util.Arrays;

public class PushZeroToENd {

	
	public static int [] pushZeroes(int [] a)
	{
		int i = 0;
		int j = 0;
		while(i < a.length-1)
		{
			if(a[i] == 0)
			{
				i++;
			}
			else
			{
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j++;
			}
		}
		System.out.println("After push "+ Arrays.toString(a));

		return a;
	}
	
	public static void main(String[] args) {
		
		int [] a = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};
		System.out.println("Before push "+ Arrays.toString(a));
		pushZeroes(a);
	}

}
