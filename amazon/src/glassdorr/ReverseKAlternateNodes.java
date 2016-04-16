package glassdorr;

public class ReverseKAlternateNodes {

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

	public ListNode reverseAlterNate(ListNode head, int k, boolean b)
	{
		if(head == null)
			return null;
		
		int count = 1; 
		ListNode curr = head; 
		ListNode prev = null;
		ListNode next;
		
		while(curr != null && count <= k)
		{
			next = curr.next;
			
			if(b)
			{
				curr.next = prev;
			}
			prev = curr;
			curr = next;
			count++;
		}
		if(b)
		{
			head.next = reverseAlterNate(curr, k, !b);
			return prev;
		}
		else
		{
			prev.next = reverseAlterNate(curr, k, !b);
			return head;
		}
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
	public static void main(String[] args) {
	
		ReverseKAlternateNodes r = new ReverseKAlternateNodes();
		r.createList();
		//r.printList(r.head);
		System.out.println();
		ListNode out = r.reverseAlterNate(r.head, 3, true);
		r.printList(out);
	}

}
