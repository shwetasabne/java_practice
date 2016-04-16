package glassdoor;

public class SearchInSortedRotatedArray {


	public static int findInRotatedSortedArray(int [] a, int k)
	{
		// find pivot
		int pivot = a[a.length-1];
		for(int i= 1; i < a.length; i++)
		{
			if(a[i] < a[i-1])
			{
				pivot = i-1;
			}
		}
		System.out.println("pivot element is "+ a[pivot]);
		
		// now check which side of pivot to search
		int low = 0; 
		int high = a[a.length-1];
		if(k < a[0])
		{
			low = pivot + 1;
		}
		else
		{
			high = pivot;
		}
		
	//	System.out.println("low "+low+" hgh "+high);
		// now binarysearch
		while( low <= high)
		{
			int mid = low + (high-low)/2;
			
			if(a[mid] == k) return mid;
			else if(k < a[mid])
			{
				high = mid - 1;
			}
			else
			{
				low = mid + 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		
		int []  a = {5, 6, 7, 1, 2, 3, 4};
		System.out.println(findInRotatedSortedArray(a, 15));	

	}

}
