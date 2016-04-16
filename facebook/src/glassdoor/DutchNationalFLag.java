package glassdoor;

import java.util.Arrays;

public class DutchNationalFLag {

	public static void swap(int idx1, int idx2, int [] a)
	{
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}

	public static void sortColors(int [] a)
	{
		System.out.println("Before sort "+ Arrays.toString(a));
		int low = 0;
		int mid = 0;
		int high = a.length-1;
		
		while(mid <= high) 
		{
			//System.out.println("mid is "+mid +" high "+high);
			switch(a[mid])
			{
				case 0 : 
					swap(low, mid, a);
					low++;
					mid++;
					break;
				case 1:
					mid++;
					break;
				case 2 :
					swap(mid, high, a);
					high--;
					break;
			}
		}
		System.out.println("After sort "+ Arrays.toString(a));
	}
	
	public static void main(String[] args) {

		int [] a  = {0,1,2,2,1,2,0,0,1,2};
		sortColors(a);
	}

}
