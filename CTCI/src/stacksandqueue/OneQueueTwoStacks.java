package stacksandqueue;

import java.util.Stack;

class LocalQueue {
	
	int size;
	Stack<Integer> stackNew ;
	Stack<Integer> stackOld;
	
	public LocalQueue(){
		stackNew = new Stack<Integer>();
		stackOld = new Stack<Integer>();
		size = stackNew.size() + stackOld.size();
	}
	
	public void enQueue(int data){
		this.stackNew.push(data);
	}
	
	public void shiftStack(){
		
		if(this.stackOld.isEmpty()){
			while(!this.stackNew.isEmpty()){
				this.stackOld.push(this.stackNew.pop());
			}
		}
	}
	
	public int deQueue(){
		shiftStack();
		return this.stackOld.pop();
	}
	
	public int peek(){
		shiftStack();
		return this.stackOld.peek();
	}
	
	public void printQueue(){
		System.out.println(this.stackOld.toString()+""+this.stackNew.toString());
	}
}

public class OneQueueTwoStacks {

	public static void main(String[] args) {
		
		LocalQueue lq = new LocalQueue();
		lq.enQueue(1);
		lq.enQueue(2);
		lq.enQueue(3);
		System.out.println("Peek "+lq.peek());
		lq.enQueue(4);
		System.out.println("Pop "+lq.deQueue());
		System.out.println("Peek "+lq.peek());
		lq.printQueue();

	}

}
