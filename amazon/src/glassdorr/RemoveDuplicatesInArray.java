package glassdorr;

import java.util.Arrays;

public class RemoveDuplicatesInArray {

	public int [] removeDuplicates(int [] a)
	{
		
		int [] out = new int[a.length];
		
		int i= 0;
		int j =0;
		
		while(i < a.length-1)
		{
			if(a[i+1] == a[i])
			{
				i++;
			}
			else
			{
				out[j] = a[i];
				j++;
				i++;
			}
			
		}
		
		System.out.println(Arrays.toString(out));
		return out;
	}
	public static void main(String[] args) {
		
		RemoveDuplicatesInArray r = new RemoveDuplicatesInArray();
		int []  a = {1,1,1,2,2,2,3,4,4,5};
		r.removeDuplicates(a);

	}

}
