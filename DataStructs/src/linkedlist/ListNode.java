package linkedlist;

public class ListNode {
	
	private int data;
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	private ListNode next;
	
	public ListNode(int data){
		this.data = data;
	}
	
	
}
