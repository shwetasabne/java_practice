package arrayTricky;

import java.util.Arrays;

public class ArrangePositiveNegative {

	
	public void rotateRight(int [] arr, int curr, int prev)
	{
		int tmp = arr[curr];
		for(int i= curr; i > prev; i--)
		{
			arr[i] = arr[i-1];
		}
		arr[prev] = tmp;
	}
	
	public int oppositeIndex(int [] arr, int i, char ch)
	{
		int j = i;
		if(ch == '-')
		{
			
			while (j < arr.length)
			{
				if(arr[j] < 0)
					return j;
				j++;
			}
		}
		else if(ch == '+')
		{
			while (j < arr.length)
			{
				if(arr[j] > 0)
					return j;
				j++;
			}
		}
		return -1;
	}
	
	public void arrage(int [] arr)
	{
		for(int i=0; i < arr.length; i++)
		{
			if(i%2 ==0 && arr[i] > 0)
			{
				//Means on an even index we have positive number, so find first number with opposite sign
				int curr = this.oppositeIndex(arr, i, '-');
				System.out.println("In if : curr is "+curr);
				if(curr != i && curr != -1)
					this.rotateRight(arr, curr, i);
					
			}
			else if(i%2 !=0 && arr[i] < 0)
			{
				//Means on off index we have negative number
				int curr = this.oppositeIndex(arr, i, '+');
				System.out.println("In else : curr is "+curr);
				if(curr !=i && curr !=-1)
					this.rotateRight(arr, curr, i);
			}
		}
		System.out.println("Final "+ Arrays.toString(arr));
	}
	public static void main(String[] args) {
		
		int [] a = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
		System.out.println("Begin "+ Arrays.toString(a));
		ArrangePositiveNegative ar = new ArrangePositiveNegative();
		ar.arrage(a);
	}

}
