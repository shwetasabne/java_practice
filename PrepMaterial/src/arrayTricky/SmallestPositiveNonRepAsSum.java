package arrayTricky;

public class SmallestPositiveNonRepAsSum {

	public static int smallestNum(int [] a)
	{
		int res = 1;
		for(int i=0; i < a.length && a[i] <= res; i++)
		{
			res = res+a[i];
			System.out.println("res is "+res);
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		int [] count = {1, 2, 6, 10, 11, 15};
		
		int out = smallestNum(count);
		System.out.println(out);

	}

}
