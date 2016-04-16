package glassdoor;

import java.util.Stack;

public class ValidBrackets {

	public static String getMatching(String str)
	{
		if(str.equals("}"))
			return "{";
		else if (str.equals("]"))
			return "[";
		else if (str.equals(")"))
			return "(";
		else
			return "";			
	}
	
	public boolean validExp(String s)
	{
		Stack<String> stack = new Stack<String>();
		for (char c : s.toCharArray())
		{
			if(c == '(' || c == '{' || c == '[')
			{
				stack.push(String.valueOf(c));
			}
			if(c == ')' || c == '}' || c == ']')
			{
				String match = getMatching(String.valueOf(c));
				if(match.equals(stack.peek()))
				{
					stack.pop();
				}
				else
				{
					return false;
				}
			}
		}
		return (stack.size() == 0);
	}

	public static void main(String[] args) {
		
		ValidBrackets v = new ValidBrackets();
		String m = "(a+b{c}[t+u])";
		System.out.println(v.validExp(m));
		m = "(a+b{c[t}+u])";
		System.out.println(v.validExp(m));
	}

}
