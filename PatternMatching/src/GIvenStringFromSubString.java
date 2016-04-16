import java.util.Arrays;


public class GIvenStringFromSubString {


	public static int [] computeLPS(String pat)
	{
		int [] count = new int [pat.length()];
		char [] p = pat.toCharArray();
		int j = 0;
		int i = 1;
		count[0] = 0;
		
		while(i < count.length)
		{
			if(p[j] == p[i])
			{
				j++;
				count[i] = j;
				i++;
			}
			else
			{
				if(j != 0)
				{
					j= count[j-1];

				}
				else
				{
					count[i] = 0;
					i++;
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
	
		String pat = "ABCDABCXT";
		int [] out = computeLPS(pat);
		System.out.println(Arrays.toString(out));
		
		int max = 0;
		for(int i=1; i < out.length; i++)
		{
			max = Math.max(out[i], max);
		}
		System.out.println("Max is "+max);
		
		if(pat.length()%max == 0)
			System.out.println("good");
		else
			System.out.println("bad");
	}

}
