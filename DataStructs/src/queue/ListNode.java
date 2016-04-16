package queue;

public class ListNode {
	
	private Object data;
	public Object getData() {
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
	
	public ListNode(Object data2){
		this.data = data2;
	}
	
	
}
