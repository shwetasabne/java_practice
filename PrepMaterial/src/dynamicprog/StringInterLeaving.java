package dynamicprog;

import java.util.Arrays;

public class StringInterLeaving {


	public static void stringInterLeave(String s1, String s2, String res, char [] ch, int i)
	{
		
		if(s1.length() == 0 && s2.length() ==0)
			System.out.println(String.valueOf(ch));

		if(s1.length() != 0)
		{
			
			ch[i] = s1.charAt(0);
			stringInterLeave(s1.substring(1), s2, res, ch, i+1);
		}
		if(s2.length() != 0)
		{
			ch[i] = s2.charAt(0);
			
			stringInterLeave(s1, s2.substring(1), res, ch, i+1);
		}
	}
	
	public static void main(String[] args) {
		
		String s1 = "AB";
		String s2 = "CD";
		char [] ch = new char[s1.length()+s2.length()];
		stringInterLeave(s1, s2, "", ch, 0);
	}

}
