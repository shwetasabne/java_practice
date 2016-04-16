package dynamicprog;

import java.util.Arrays;

public class DecodingSequence {


	public static int decodeNonDP(String s, int end)
	{
		if(end == 0 || end == 1)
			return 1;
		
		int count = 0;
		if(s.charAt(end-1) > '0')
			count = decodeNonDP(s.substring(0,end-1), end-1);
		
		if(s.charAt(end-2) < '2' || (s.charAt(end-2) == '2' && s.charAt(end-1) < '7'))
			count+=decodeNonDP(s.substring(0, end-2), end-2);
		return count;
	}
	
	public static int decodeDP(char[] ch, int n)
	{
		int [] count = new int[n+1];
		count[0] = 1;
		count[1] = 1;
		
		for (int i =2; i <= n; i++)
		{
			count[i] = 0;
			
			if(ch[i-1]  > '0')
			{
				count[i] = count[i-1];
			}
			if(ch[i-2] < '2' || (ch[i-2] == '2' && ch[i-1]<'7'))
				count[i]+=count[i-2];
		}
		System.out.println(Arrays.toString(count));
		return count[n];
	}
	

	public static void main(String[] args) {
		
		String s = "121";
		int out = decodeNonDP(s, s.length());
		System.out.println(out);
		
		out = decodeDP(s.toCharArray(), s.length());
		System.out.println(out);
	}

}
