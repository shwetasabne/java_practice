import java.util.Arrays;


public class RemoveElement {

	public static int removeDuplicates(int []a)
	{
		int i=0;
		int j=0;
		
		if(a.length == 0)
			return 0;
		if(a.length == 1)
			return 1;
		while(i < a.length-1)
		{
			if(a[i] == a[i+1])
			{
				i++;
			}
			else{
				a[j+1] = a[i+1];
				
				i++;
				j++;
			}
		}

		System.out.println(Arrays.toString(a));
		return j+1;
	}
	public static int removeElement(int [] a, int val){
		
		int i=0;
		int j=0;
		
		while(j < a.length)
		{
			if(a[j] == val)
			{
				j++;
			}
			else
			{
				a[i] = a[j];
				i++;
				j++;
			}
		}
		System.out.println(Arrays.toString(a));
		return i;
	}

	public static void main(String[] args) {
	
		int [] a = {1,1,2,2, 3, 3};
		//System.out.println(removeElement(a, 3));
		System.out.println(removeDuplicates(a));
	}

}
