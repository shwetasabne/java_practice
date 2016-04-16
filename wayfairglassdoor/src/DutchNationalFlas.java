import java.util.Arrays;


public class DutchNationalFlas {


	public static int []  a = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
	
	public void sort()
	{
		int low = 0;
		int mid = 0;
		int high = a.length -1;
		
		while(mid <= high)
		{
			switch(a[mid])
			{
				case 0 : 
					swap(low, mid);
					low++;
					mid++;
					break;
				case 1:
					mid++;
					break;
				case 2:
					swap(high, mid);
					high--;
					break;
			}
		}
	}
	
	private void swap(int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		return;
	}
	
	public static void main(String[] args) {
		
		DutchNationalFlas d = new DutchNationalFlas();
		System.out.println(Arrays.toString(a));
		d.sort();
		System.out.println(Arrays.toString(a));

	}

}
