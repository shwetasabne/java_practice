package glassdoor;

public class ContiguousSubSequenceWithSum {


	public static boolean contiguousSubSequenceWithSum(int [] a, int sum)
	{
		for(int i = 0 ; i < a.length; i++)
		{
			int sumSoFar = a[i];
			if(sumSoFar == sum)
				return true;
			if(sumSoFar > sum)
				continue;
			for(int j = i+1; j < a.length; j++)
			{
				sumSoFar += a[j];
				if(sumSoFar == sum)
					return true;
				else if(sumSoFar > sum)
					break;
					
			}
		}
		return false;
	}

	public static void main(String[] args) {
		
		int [] a = {5, 6, 3, 1, 12};
		System.out.println(contiguousSubSequenceWithSum(a, 11));

	}

}
