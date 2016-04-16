package geekforgeeks;

import java.util.Arrays;

public class RotateArray {

	public static void reverse(int [] arr, int start, int end)
	{
		while(start < end)
		{
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	public static void main(String[] args) {

		int [] array = {1,2,3,4,5,6};
		int num = 2;
		
		int order = num % array.length;
		
		int lenFirst = array.length - order;
		reverse(array, 0, lenFirst - 1);
		reverse(array, lenFirst, array.length-1);
		reverse(array, 0, array.length-1);
		
		System.out.println(Arrays.toString(array));
	}

}
