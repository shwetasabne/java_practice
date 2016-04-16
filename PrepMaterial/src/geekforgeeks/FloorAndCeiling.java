package geekforgeeks;

import java.util.Arrays;

public class FloorAndCeiling {


	public static int [] findFloorCeiling (int [] a, int search)
	{
		int [] retVal = new int[2];
		
		int low = 0;
		int high = a.length-1;
		retVal[0] = -1; // floor
		retVal[1] = -1; // ceil
		
		if(search > a[high])
		{
			retVal[0] = a[high];
			retVal[1] = -1;
			System.out.println(Arrays.toString(retVal));
			return retVal;
		}
		if(search < a[low])
		{
			retVal[0] = -1;
			retVal[1] = a[low];
			System.out.println(Arrays.toString(retVal));
			return retVal;
		}
		System.out.println("Starting");
		while(low <= high)
		{
	
			int mid = low + (high-low)/2;
			System.out.println("mid is "+mid);

			if(search == a[mid])
			{
				retVal[0] = a[mid];
				retVal[1] = a[mid];
				System.out.println(Arrays.toString(retVal));
				return retVal;
			}
			if(search < a[mid] && a[mid-1] < search)
			{
				retVal[0] = a[mid-1];
				retVal[1] = a[mid];
				System.out.println(Arrays.toString(retVal));
				return retVal;
			}
			if(search < a[mid])
			{
				high =  mid-1;
			}
			else
				low = mid+1;
		}
		System.out.println(Arrays.toString(retVal));
		return retVal;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,3,5,8};
		findFloorCeiling(a,78);
	}

}
