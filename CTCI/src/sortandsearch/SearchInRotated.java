package sortandsearch;

public class SearchInRotated {


	public int findIndex(int [] arr, int k)
	{
		int index = -1;
		int pivot = 0;
		for(int i=1; i < arr.length-1; i++)
		{
			if(arr[i] > arr[i+1])
			{
				pivot = i;
				break;
			}
		}
		System.out.println("pivot is "+pivot);
		
		int low = 0;
		int high = arr.length -1;
	
		if(k == arr[pivot])
			return pivot;
	
		
		if(arr[low] < k &&   k < arr[pivot])
		{
			
			high = pivot - 1;
		}
		else
		{
			low = pivot +1 ;
			
		}
		System.out.println(low + " "+high);

		while(low <= high)
		{
			int mid = low + (high-low)/2;
			System.out.println("low "+low +" high "+high+" mid "+mid);
			if(arr[mid] == k)
				return mid;
			if(arr[mid] < k) 
				low = mid +1 ;
			else if(arr[mid] > k)
			{
				high = mid -1;
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		
		int [] a = {10, 15, 20, 0, 5, 10};
		SearchInRotated r = new SearchInRotated();
		System.out.println(r.findIndex(a, 10));

	}

}
