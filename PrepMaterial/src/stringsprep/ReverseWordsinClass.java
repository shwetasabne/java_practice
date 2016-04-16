package stringsprep;

import java.util.Stack;

public class ReverseWordsinClass {

	public String reverseWords(String s)
	{
		String rev = "" ;
		
		Stack<String> stack = new Stack<String>();
		StringBuilder sb = new StringBuilder();
		
		for(char c : s.toCharArray())
		{
			System.out.println("Processing "+c);
			if(c == ' ')
			{
				stack.push(sb.toString());
				sb = new StringBuilder();
			}
			else
			{
				sb.append(c);
			}
		}
		stack.push(sb.toString());
		System.out.println(stack.toString());
		while(!stack.isEmpty())
		{
			rev = rev + " " + stack.pop();
		}
		System.out.println(" Stack results "+rev);
		return rev;
	}
	
	public static void main (String [] args)
	{
		ReverseWordsinClass r = new ReverseWordsinClass();
		r.reverseWords("i like  kunal");
	}
}
