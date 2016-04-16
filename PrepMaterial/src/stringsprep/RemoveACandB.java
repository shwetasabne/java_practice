package stringsprep;

import java.util.Arrays;

public class RemoveACandB {
	
	public String  removeACandB(String s)
	{
		String s1 = "";
		char [] out = new char [s.length()];
		int i = -1;
		int j = 0;
		while (j < s.length())
		{
			System.out.println("i is "+i+" j is "+j+ " "+s.charAt(j));
			//Check if curr and next are a and c respectively
			if( j < (s.length() -1) && s.charAt(j) == 'a' && s.charAt(j+1) == 'c')
			{
				j+=2;
			}
			//check if it is b
			else if(s.charAt(j) ==  'b')
			{
				j++;
			}
			else if(i>= 0 && s.charAt(i) == 'a' && s.charAt(j) == 'c')
			{
				
				i--;
				j++;
			}
			else
				out[++i] = s.charAt(j++);
			
		}
		out[++i] = ' ';
		System.out.println("final i is "+i+" "+Arrays.toString(out));
		
		return s1;
	}
	
	public static void main(String [] args)
	{
		RemoveACandB r = new RemoveACandB();
		r.removeACandB("react");
	}

}
