package linkedlisttricky;

public class SwapNodesLinkedList {

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
		this.head.next.next.next.next.next = new ListNode(6);
	}
	
	public int countNodes (ListNode head)
	{
		ListNode temp = head;
		int count = 0;
		while(head != null)
		{
			count++;
			head = head.next;
		}
		return count;
	}

	public void swapNodes(int k)
	{
		int count = this.countNodes(this.head);
		
		if(k > count)
			return;
		if(2*k -1  == count)
			return;
		
		
		ListNode x_prev = null;
		ListNode x = this.head;
		for(int i=1; i < k ;i++)
		{
			x_prev = x;
			x = x.next;
		}
		
		ListNode y_prev = null;
		ListNode y = this.head;
		for(int i=1; i < count-k+1 ;i++)
		{
			y_prev = y;
			y = y.next;
		}
		
		if(x_prev != null)
			x_prev.next = y;
		if(y_prev != null)
			y_prev.next  = x;
		
		ListNode temp = x.next;
		x.next = y.next;
		y.next = temp;
		
		if(k == 1)
			this.head = y;
		if(k == count)
			this.head = x;
		
	}
	
	public static void main(String[] args) {
		
		SwapNodesLinkedList s = new SwapNodesLinkedList();
		s.constructList();
		s.printList(s.head);
		s.swapNodes(1);
		System.out.println();
		s.printList(s.head);

	}

}
