package careercup;

public class SecondLastNodeofLinkedList {

	private class ListNode {
		int data;
		ListNode next;
		
		public ListNode(int data)
		{
			this.data = data;
			this.next = null;
		}
	}
	
	public ListNode head ;
	
	public  void createList()
	{
	//	this.head = new ListNode(1);
	//	this.head.next = new ListNode(2);
	//	this.head.next.next = new ListNode(3);
	}
	
	public int secondLast(ListNode head)
	{
		if(head == null)
			return -1;
		if(head.next == null)
			return head.data;
		ListNode slowPntr = head;
		ListNode fastPntr = head.next;
		

		while(fastPntr.next != null)
		{
			slowPntr = slowPntr.next;
			fastPntr = fastPntr.next;
		}
		return slowPntr.data;
	}
	
	public static void main(String[] args) {
		
		SecondLastNodeofLinkedList s = new SecondLastNodeofLinkedList();
		s.createList();
		System.out.println(s.secondLast(s.head));

	}

}
