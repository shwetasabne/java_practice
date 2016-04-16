package moderate;

public class TrailingZeroes {

	public int trailingZeroes(int num)
	{
		int count = 0;
		
		for(int i= 5; num/i > 0; i = i * 5)
		{
			count+=num/i;
		}
		return count;
	}
	public static void main(String[] args) {
		
		TrailingZeroes t = new TrailingZeroes();
		System.out.println(t.trailingZeroes(101));
	}

}
