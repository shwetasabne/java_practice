package glassdorr;

public class SwapPairWiseListNodes {
	
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
	
	public void createList()
	{
		this.head = new ListNode(1);
		this.head.next = new ListNode(2);
		this.head.next.next = new ListNode(3);
		this.head.next.next.next = new ListNode(4);
		this.head.next.next.next.next = new ListNode(5);
		this.head.next.next.next.next.next = new ListNode(6);
		this.head.next.next.next.next.next.next = new ListNode(7);
		this.head.next.next.next.next.next.next.next = new ListNode(8);
		this.head.next.next.next.next.next.next.next.next = new ListNode(9);
	}

	public void printList(ListNode head)
	{
		ListNode newHead = head;
		while(newHead != null)
		{
			System.out.print(newHead.data + " -> ");
			newHead = newHead.next;
		}
	}

	
	public void swapPairWise(ListNode head)
	{
		ListNode prev = null;
		ListNode curr = head;
		ListNode origNext;
		ListNode origNextNext;
		
		while(curr != null && curr.next != null)
		{
			origNext = curr.next;
			origNextNext = curr.next.next;
			
			if(prev == null)
			{
				this.head = origNext;
			}
			else
			{
				prev.next = origNext;
			}
			origNext.next = curr;
			curr.next = origNextNext;
			prev = curr;
			curr = origNextNext;
			
		}
		
	}
	
	public static void main(String[] args) {
		
		SwapPairWiseListNodes s = new SwapPairWiseListNodes();
		s.createList();
		s.printList(s.head);
		s.swapPairWise(s.head);
		System.out.println();
		s.printList(s.head);
	}

}
