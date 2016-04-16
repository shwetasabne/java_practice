package geekforgeeks;

public class MajorDifference {


	public static int maxDiff(int [] a)
	{
		if(a.length == 0)
			return 0;
		if(a.length == 1)
			return 0;
		int majorDiff = 0;
		int minElement = a[0];
		int i = 1;
	//	System.out.println("min is "+minElement);
		while(i < a.length)
		{
	//		System.out.println("Processign "+a[i]+" min Element "+minElement);
			if(a[i] < minElement)
			{
				minElement = a[i];
			}
			else
			{
				majorDiff = Math.max(majorDiff, (a[i] - minElement));
			}
			i++;
		}
		return majorDiff;
	}
	public static void main(String[] args) {
		
		int []a = {2, 1, 10, 6, 4, 8, 1};
		int out = maxDiff(a);
		System.out.println(out);
		int []b = {7, 9, 5, 6, 3, 2};
		 out = maxDiff(b);
		System.out.println(out);
	}

}
