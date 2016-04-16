package glassdoor;

public class StringOneLetterDiff {

	public static boolean isOneWordDiff(String small, String big)
	{
		int sLen = small.length();
		int bLen = big.length();
		
		if(bLen - sLen > 1)
			return false;
		
		int i = 0; 
		int j = 0;
		
		int diff = 0;
		
		while(i < sLen && j < bLen)
		{
			if(small.charAt(i) != big.charAt(j))
			{
				diff++;
			}
			if(diff > 1)
			{
				return false;
			}
			i++;
			j++;
		}
		
		System.out.println(i +" "+j+" "+sLen + " "+bLen);
		if(bLen - j == 1)
			diff++;
		
		if(diff > 1)
			return false;
		else
			return true;
		
	}
	


	public static void main(String[] args) {
		
		System.out.println(isOneWordDiff("car", "car"));

	}

}
