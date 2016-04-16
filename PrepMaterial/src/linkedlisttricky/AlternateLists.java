package linkedlisttricky;



public class AlternateLists {

	private class ListNode {
		int data ;
		ListNode next ; 
		public ListNode(int data)
		{
			this.data = data;
			this.next = null;
		}
	}
	
	public ListNode head;
	public void printList(ListNode head)
	{
		ListNode newHead = head;
		while(newHead != null)
		{
			System.out.print(newHead.data + " -> ");
			newHead = newHead.next;
		}
		
	}
	public void constructList()
	{
		this.head = new ListNode(1);
		this.head.next = new ListNode(2);
		this.head.next.next = new ListNode(3);
		this.head.next.next.next = new ListNode(4);
		this.head.next.next.next.next = new ListNode(5);
//		this.head.next.next.next.next.next = new ListNode(6);
	}
	
	public ListNode[] alternodes(ListNode head, ListNode a, ListNode b)
	{
		ListNode [] nodes =  new ListNode[2];
		int count = 0;
		while(head != null && head.next != null)
		{
			a.next = new ListNode(head.data);
			a = a.next;
			head = head.next;
			
			b.next = new ListNode(head.data);
			b = b.next;
			head = head.next;
			count++;
		}
		if(head != null)
		{
			if(count%2 == 0)
				a.next = new ListNode(head.data);
			else
				b.next  = new ListNode(head.data);
		}
		nodes[0] = a.next;
		nodes[1] = b.next;
		return nodes;
	}
	
	public static void main(String[] args) {
		
		AlternateLists a = new AlternateLists();
		a.constructList();
		a.printList(a.head);
		
		ListNode a1  = a.new ListNode(-1);
		ListNode b1  = a.new ListNode(-2);

 		ListNode [] out = a.alternodes(a.head, a1, b1);
 		System.out.println();
 		a.printList(a1.next);
 		System.out.println();
 		a.printList(b1.next);
	}

}
