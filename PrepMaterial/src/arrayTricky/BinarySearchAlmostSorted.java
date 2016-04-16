package arrayTricky;

public class BinarySearchAlmostSorted {

	public int binarySearch(int []a, int x)
	{
		int lo = 0;
		int hi = a.length-1;
		
		while(lo <= hi)
		{
			int mid = lo + (hi-lo)/2;
			
			if(a[mid] == x) return mid;
			if(a[mid-1] == x) return mid-1;
			if(a[mid+1] == x) return mid+1;
			
			if(a[mid] > x)
			{
				lo = mid+2;
			}
			else
			{
				hi = mid-1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		
		int[] a = {10, 3, 40, 20, 50, 80, 70};
		BinarySearchAlmostSorted n = new BinarySearchAlmostSorted();
		System.out.println(n.binarySearch(a, 4));

	}

}
