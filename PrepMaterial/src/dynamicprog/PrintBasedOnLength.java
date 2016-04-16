package dynamicprog;

import java.util.Stack;

public class PrintBasedOnLength {

	public String getBaseString(int n)
	{
		String temp = "";
		for(int i = 1; i <= n-1; i++)
		{
			temp = temp+ String.valueOf(i);
		}
		return temp;
	}

	public void printString(int n)
	{
		String base = getBaseString(n);
		int i = n;
		while(true)
		{
			String newString = base + String.valueOf(i);
			if(newString.length() > n)
				break;
			System.out.println(newString);
			i++;
		}
			
	}
	
	public static void enumerate(int k, int n) { 
		Stack<Integer> state = new Stack<Integer>(); 
		// init 
		for(int i = 1; i <= k; i++){ state.add(i); } 
		// print 
		boolean done = false; 
		while(state.size() > 0){ 
			System.out.println(state.toString()); 
			int j = 0; 
			while(j < k){ 
				int ik = state.pop(); 
				if(ik < n - j){ 
					for(int i = 0 ; i <= j; i++){ 
						state.push(ik+i+1); } 
					break; } 
				j++; 
				} 
			}
		}
		
	
	public static void main(String[] args) {
		
		PrintBasedOnLength p = new PrintBasedOnLength();
	//	p.printString(2);
		
		enumerate(10, 3);

	}

}
