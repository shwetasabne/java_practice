package stacksandqueue;

import java.util.Stack;

public class DescendingSort {

	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(5);
		stack.push(7);
		stack.push(10);
		stack.push(3);
		stack.push(1);
		System.out.println("Stack "+stack.toString());
		
		Stack<Integer> temp = new Stack<Integer>();
		int max = Integer.MIN_VALUE;
		
		while(!stack.isEmpty()){
			System.out.println("***");
			System.out.println("Max is "+max);
			int v = stack.pop();
			System.out.println("Processing "+v);
			if(temp.isEmpty() || v > max){
				System.out.println("v is "+v+" max is "+max);
				temp.push(v);
				max = temp.peek();
			}
			else {
				
				//v holds our value that needs to be sorted
				// Iterate over the temp stack
				while(!temp.isEmpty() && temp.peek() > v){
				//	System.out.println()
					stack.push(temp.pop());
				}
			//	int before = temp.pop();
				temp.push(v);
				//temp.push(before);
				max = v;
				System.out.println("TStack "+stack.toString());
			}
			System.out.println("Temp is " + temp.toString());
			System.out.println("Max is "+max);
		}
		
		System.out.println("Stack "+temp.toString());

	}

}
