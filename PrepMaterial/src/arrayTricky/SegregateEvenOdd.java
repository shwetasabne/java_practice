package arrayTricky;

import java.util.Arrays;

public class SegregateEvenOdd {

	
	public static void main(String[] args) {
		
		int [] arr = {12, 34, 45, 9, 8, 90, 3};
		System.out.println(Arrays.toString(arr));
		int left = 0; 
		int right = arr.length-1;
		
		while(left < right)
		{
			while(left < right && arr[left]%2 == 0)
				left++;
			
			while(left < right && arr[right]%2 != 0)
				right--;
			
			if(left < right)
			{
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
