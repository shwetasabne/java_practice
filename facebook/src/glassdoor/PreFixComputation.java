package glassdoor;

import java.util.Stack;

public class PreFixComputation {


	public static boolean isOperator(char ch)
	{
		if(ch == '*' || ch == '/' || ch == '+' || ch == '-')
			return true;
		else
			return false;
	}
	
	
	public static int solvePrefixComputation(String s)
	{
		char [] ch = s.toCharArray();
		Stack<String> operandStack = new Stack<String>();
		
		for(int i=ch.length-1; i >=0; i--)
		{
		//	System.out.println(" stack is "+operandStack.toString());
			if(isOperator(ch[i]))
			{
				// if operator, pop last 2 items
				int a = Integer.valueOf(operandStack.pop());
				int b = Integer.valueOf(operandStack.pop());
				if(ch[i] == '*')
				{
					int c = a*b;
					operandStack.push(String.valueOf(c));
				}
				else if(ch[i] == '/')
				{
					int c = a/b;
					operandStack.push(String.valueOf(c));
				}
				else if(ch[i] == '+')
				{
					int c = a+b;
					operandStack.push(String.valueOf(c));
				}
				else if(ch[i] == '-')
				{
					int c = a-b;
					operandStack.push(String.valueOf(c));
				}
			}
			else
			{
				operandStack.push(String.valueOf(ch[i]));
			}
		}
		
		int out = Integer.valueOf(operandStack.pop());
		return out;
	}
	
	public static void main(String[] args) {
		
		String s = "+*123";
		System.out.println(solvePrefixComputation(s));

	}

}
