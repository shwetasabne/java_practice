package geekforgeeks;

class ListNode {
	
	int data ;
	ListNode next ; 
	
	public ListNode(int data)
	{
		this.data = data;
		next = null;
	}
	
	public String toString()
	{
		return ((Integer)this.data).toString();
	}
}

public class LinkedListRemoveAlternate {

	ListNode head = new ListNode(1);
	
	public void createList()
	{
	//	head.next = new ListNode(2);
	//	head.next.next = new ListNode(3);
	//	head.next.next.next = new ListNode(4);
	//	head.next.next.next.next = new ListNode(5);
	}
	
	public void printList()
	{
		ListNode curr = this.head;
		while(curr != null)
		{
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
	}
	
	public void removeAlternates()
	{
		if(this.head.next == null)
			return;
		ListNode slow = this.head;
		// Fast pointer is twice as fast
		ListNode fast = this.head.next.next;
		while(fast != null)
		{
			//System.out.println("Slow is "+slow.data + " fast is "+fast.data);
			if(slow.next != null)
			{
				ListNode slowNext = slow.next;
				slowNext.next = null; // Remove the second one
			}
			slow.next = fast; // Make slow point to fast
			slow = slow.next;
			if(fast.next !=null && fast.next.next != null)
				fast = fast.next.next;
			else
				fast = null;
			
		}
		if(slow.next != null)
			slow.next = null;
	}
	
	public static void main(String [] args)
	{
		LinkedListRemoveAlternate lra  = new LinkedListRemoveAlternate();
		lra.createList();
		lra.printList();
		System.out.println("After removal");
		lra.removeAlternates();
		lra.printList();
	}
}
