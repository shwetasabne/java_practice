package arrayTricky;

public class DuplicateInNoExtraSpace {

	public void printDuplicates(int [] arr)
	{
		for(int i=0; i < arr.length; i++)
		{
			if(arr[Math.abs(arr[i])] > 0)
			{
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])] ;
			}
			else
			{
				System.out.println(Math.abs(arr[i]));
			}
		}
	}
	
	public static void main(String[] args) {
		
		DuplicateInNoExtraSpace d = new DuplicateInNoExtraSpace();
		int [] a = {1, 2, 3, 1, 3, 6, 6};
		d.printDuplicates(a);
		
	}

}
