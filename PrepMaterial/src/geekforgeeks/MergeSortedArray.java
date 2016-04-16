package geekforgeeks;

import java.util.Arrays;

public class MergeSortedArray {

	
	public int [] removeNulls(int []a)
	{
		int i = 0; int j = 0;
		while( i < a.length)
		{
			if(a[i] == -1)
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
		return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {2, -1, 7, -1, -1, 10, -1, 12};
		MergeSortedArray ms = new MergeSortedArray();
		ms.removeNulls(a);
		System.out.println(Arrays.toString(a));
	}

}
