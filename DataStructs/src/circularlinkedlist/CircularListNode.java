package circularlinkedlist;

public class CircularListNode {
	
	private int data;
	private CircularListNode next;

	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public CircularListNode getNext() {
		return next;
	}
	public void setNext(CircularListNode next) {
		this.next = next;
	}

	public CircularListNode(int val){
		this.data = val;
	}
	
}
