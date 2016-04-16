package strings;

import java.util.Stack;

public class SimpleCalculator {

	public int output(String s)
	{
		int r = 0;
		int a = 0;
		int b = 0;
		
		Stack<String> o = new Stack<String>();
		
		for(char ch : s.toCharArray())
		{
			if(Character.isDigit(ch))
			{
				int curr = Integer.valueOf(String.valueOf(ch));
				System.out.println(" "+ch+" is digit");
				// Check if there top of stack is * or /
		//		System.out.println(o.toString());
				if(!o.isEmpty() && (o.peek().equals("*") || o.peek().equals("/")))
				{
					
					String opr = o.pop();
					if(opr.equals("*"))
					{
						int prev = Integer.valueOf(o.pop());
						int out = prev * curr;
						o.push(String.valueOf(out));
					}
					if(opr.equals("/"))
					{
						int prev = Integer.valueOf(o.pop());
						int out = prev / curr;
						o.push(String.valueOf(out));
					}
				}
				else
				{
					o.push(String.valueOf(ch));
				}

			}
			else
			{
				o.push(String.valueOf(ch));
			}
			
		}
		System.out.println(o.toString());
		return r;
	}
	public static void main(String[] args) {
		
		SimpleCalculator s = new SimpleCalculator();
		s.output("3*2+2-5/3");
	}

}
