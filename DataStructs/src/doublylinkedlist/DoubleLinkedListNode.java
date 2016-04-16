package doublylinkedlist;

public class DoubleLinkedListNode {
	
	private int data;
	private DoubleLinkedListNode next;
	private DoubleLinkedListNode prev;
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public DoubleLinkedListNode getNext() {
		return next;
	}
	public void setNext(DoubleLinkedListNode next) {
		this.next = next;
	}
	public DoubleLinkedListNode getPrev() {
		return prev;
	}
	public void setPrev(DoubleLinkedListNode prev) {
		this.prev = prev;
	}
	
	public DoubleLinkedListNode(int val){
		this.data = val;
	}
	

}
