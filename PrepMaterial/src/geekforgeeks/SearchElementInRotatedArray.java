package geekforgeeks;

public class SearchElementInRotatedArray {


	public static int findPivot(int []a)
	{

		int low = 0;
		int high = a.length - 1;

		while(low < high)
		{
			int mid = low + (high-low)/2;
			if( a[mid] > a[mid+1] )
				return mid;
			if( a[low] > a[mid])
				high = mid;
			else
				low = mid + 1;
		}

		return -1;
	}
	
	public static boolean findElementInRotatedArray(int [] a, int search)
	{
		int low = 0;
		int high = a.length-1;
		int pivot = findPivot(a);


		if(pivot != -1)
		{
			if(search == a[pivot])
				return true;
			if(search < a[low])
			{
				low = pivot+1;
			}
			else
			{
				high = pivot;
			}
		}
		
		// Now start binary search
		while(low <= high)
		{
			int mid = low + (high-low)/2;
			if(search == a[mid])
				return true;
			if(search < a[mid])
				high = mid-1;
			else
				low = mid+1;
		}
		return false;
	}
	public static void main(String[] args) {
		
		int a [] = {3,4};
		//System.out.println(findPivot(a));
		System.out.println(findElementInRotatedArray(a, 4));

	}

}
