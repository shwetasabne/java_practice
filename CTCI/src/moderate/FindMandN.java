package moderate;

public class FindMandN {

	public int end_left (int [] a)
	{
		
		for(int i=1; i< a.length; i++)
		{
			if(a[i]<a[i-1])
			{
				return (i-1);
			}
		}
		return a.length -1;
	}
	
	public int start_right(int [] a)
	{
		for(int i = a.length-2; i >=0; i--)
		{
			if(a[i] > a[i+1])
			{
				return (i+1);
			}
		}
		return 0;
	}
	
	public void minMandN (int [] array)
	{
		int end_left_ind = this.end_left(array);
		
		int start_right_ind = this.start_right(array);
		
		int min = end_left_ind + 1 ;
		int max = start_right_ind - 1;
		
		
	}
	public static void main(String[] args) {
		

	}

}
