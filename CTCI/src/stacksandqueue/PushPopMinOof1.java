package stacksandqueue;

import java.util.Stack;

class Node {
	int data;
	Node next;
	public Node(int data){
		this.data = data;
	}
}


@SuppressWarnings("serial")
class LocalStackMin extends Stack<Integer> {
	
	Stack<Integer>s2; // Holds the minimum
	public LocalStackMin(){
		s2 = new Stack<Integer>();
	}
	
	public void push (int data){
		
		if(data < min()){
			s2.push(data);
		}
		super.push(data);
	}
	
	public Integer peek(){
		
		if(super.isEmpty()){
			return -1;
		}
		else {
			return super.peek();
		}
	}
	public Integer pop (){
		
		int value = super.pop();
		if(value == min()){
			s2.pop();
		}
		return value;
	}
	
	public int min(){
		if(s2.isEmpty()){
			return Integer.MAX_VALUE;
		}
		else {
			return s2.peek();
		}
	}
}

public class PushPopMinOof1 {

	public static void main(String[] args) {
		
		LocalStackMin lsm = new LocalStackMin();
		System.out.println("Peeking "+lsm.peek() + " Min "+lsm.min());
		lsm.push(10);
		lsm.push(20);
		lsm.push(5);
		lsm.push(19);
		
		System.out.println("Peeking "+lsm.peek() + " Min "+lsm.min());
		lsm.pop();
		System.out.println("Peeking "+lsm.peek() + " Min "+lsm.min());
		lsm.pop();
		System.out.println("Peeking "+lsm.peek() + " Min "+lsm.min());
		
	}

}
