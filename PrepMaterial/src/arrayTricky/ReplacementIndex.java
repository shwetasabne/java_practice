package arrayTricky;

public class ReplacementIndex {

	public int countOnes(int [] a, int currIndex)
	{
		int low = 0;
		int high = a.length-1;
		int counter = 0;
		//1 to left of curr
	//	System.out.println("currIndex is "+currIndex+" "+low+" "+high);
		for(int i= currIndex-1; i >= low; i--)
		{
		//	System.out.println("i is "+ i +" "+a[i]);
			if(a[i] == 1)
				counter++;
			else
				break;
		}
		for(int i= currIndex+1; i <= high; i++)
		{
			if(a[i] == 1)
				counter++;
			else
				break;
		}
		return counter+1;
	}
	
	public int findReplacementIndex(int [] a)
	{
		int maxCount = 0;
		int maxIndex = -1;
		for(int i=0; i < a.length; i++)
		{
			if(a[i] == 0)
			{
				int newCount = this.countOnes(a, i);
			//	System.out.println("New count at "+i+" is "+newCount);
				if(newCount > maxCount)
				{
					maxCount = newCount;
					maxIndex  = i;
				}
			}
		}
		return maxIndex;
	}
	
	public static void main(String[] args) {
		
		int [] a = {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1};
		ReplacementIndex r = new ReplacementIndex();
		int out = r.findReplacementIndex(a);
		System.out.println(out);
		int [] b = {0,0};
		System.out.println(r.findReplacementIndex(b));
	}

}
