package stack;

import java.util.EmptyStackException;

import linkedlist.ListNode;

public class ListStack {
	
	private ListNode topNode;
	
	public void printStack(){

		System.out.println("");
		ListNode curr = this.topNode;
		while(curr.getNext() != null){
			System.out.print(curr.getData() + "::");
			curr = curr.getNext();
		}
		System.out.print(curr.getData());
	}
	
	public void push(int data){
		if(this.topNode == null){
			this.topNode = new ListNode(data);
		}
		else{
			ListNode temp = new ListNode(data);
			temp.setNext(this.topNode);
			this.topNode = temp;
		}
	}
	
	public int pop() throws Exception{
		if(isStackEmpty()){
			throw new Exception("Stack empty");
		}
		else{
			int data = this.topNode.getData();
			topNode = topNode.getNext();
			return data;
		}
	}
	
	public boolean isStackEmpty(){
		if(this.topNode == null){
			return true;
		}
		else{
			return false;
		}
		
	}
	

}
