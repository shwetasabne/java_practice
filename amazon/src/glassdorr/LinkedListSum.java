package glassdorr;


public class LinkedListSum {

	private class ListNode {
		
		int data ;
		ListNode next ;
		
		public ListNode(int data)
		{
			this.data = data;
			this.next = null;
		}
	}


	public ListNode sum(ListNode h1, ListNode h2)
	{
		ListNode fakeHead = new ListNode(-1);
		ListNode curr = fakeHead;
		
		int carry = 0;
		int sum = 0;
		while(h1 != null || h2 != null)
		{
			if(h1 != null && h2 != null)
			{
				sum = h1.data + h2.data + carry;
				//System.out.println("sum is "+sum);
			}
			else if(h1 == null)
			{
				sum = h2.data + carry;
			}
			else if(h2 == null)
			{
				sum = h1.data + carry;
			}
			
			if(sum >= 10)
			{
				curr.next = new ListNode(sum % 10);
				carry = sum / 10;
			}
			else
			{
				curr.next = new ListNode(sum);
			}
			if(h1 != null)
				h1 = h1.next;
			if(h2 != null)
				h2 = h2.next;
			curr = curr.next;
		}

		if(carry != 0)
			curr.next = new ListNode(1);
		
		return fakeHead.next;
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
	
		LinkedListSum s = new LinkedListSum();
		ListNode head1 = s.new ListNode(3);
		head1.next = s.new ListNode(2);
		head1.next.next = s.new ListNode(1);
		
		ListNode head2 = s.new ListNode(9);
		head2.next = s.new ListNode(8);
		head2.next.next = s.new ListNode(9);

		ListNode out = s.sum(head1, head2);
		s.printList(out);
	}

}
