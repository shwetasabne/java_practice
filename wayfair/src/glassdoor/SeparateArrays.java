package glassdoor;
import java.util.*;


public class SeparateArrays {

	public ArrayList<int []> separateArrays (int [] a)
	{
		ArrayList<int []> result = new ArrayList();
		
		if(a.length == 0)
			return result;
		
		ArrayList<Integer> positive = new ArrayList<Integer>();
		ArrayList<Integer> negative = new ArrayList<Integer>();
		
		for(int i=0; i < a.length; i++)
		{
			if(a[i] >= 0)
			{
				positive.add(a[i]);
			}
			else
			{
				negative.add(a[i]);
			}
		}
		
		int [] p = new int[positive.size()];
		int [] n = new int[negative.size()];
		for(int i=0; i< p.length; i++)
		{
			p[i] = positive.get(i);
		}
		for(int i=0; i< n.length; i++)
		{
			n[i] = negative.get(i);
		}
		
		result.add(n);
		result.add(p);
		return result;
	}
	
	public void separateArrayQS(int [] a, int low, int high)
	{
		int i = low;
		int j = high;
		int pivot = 0;
		
		while(i <= j)
		{
			while(a[i] < pivot)
				i++;
			
			while(a[j] > pivot)
				j--;
			
			if(i <= j)
			{
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		System.out.println("low "+low+" j "+j+" high "+high+" i "+i);
		//if(low < j)
		//	separateArrayQS(a, low, j);
	//	if(i < high)
		//	separateArrayQS(a, i, high);
	}
	
	public static void main(String[] args) {
		
		SeparateArrays s = new SeparateArrays();
		int [] a = {2,4,-3,4,-1,5,6,-10};
		s.separateArrayQS(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
		

	}

}
