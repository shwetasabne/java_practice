package linkedlisttricky;

public class MaxSumAcrossLL {

	private class ListNode {
		int data ;
		ListNode next ; 
		public ListNode(int data)
		{
			this.data = data;
			this.next = null;
		}
	}
	
	public ListNode head1;
	public ListNode head2;
	
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
		this.head1 = new ListNode(1);
		this.head1.next = new ListNode(3);
		this.head1.next.next = new ListNode(30);
		this.head1.next.next.next = new ListNode(90);
		this.head1.next.next.next.next = new ListNode(120);
		this.head1.next.next.next.next.next = new ListNode(240);
		this.head1.next.next.next.next.next.next = new ListNode(511);
		
		
		this.head2 = new ListNode(0);
		this.head2.next = new ListNode(3);
		this.head2.next.next = new ListNode(12);
		this.head2.next.next.next = new ListNode(32);
		this.head2.next.next.next.next = new ListNode(90);
		this.head2.next.next.next.next.next = new ListNode(125);
		this.head2.next.next.next.next.next.next = new ListNode(240);
		this.head2.next.next.next.next.next.next.next = new ListNode(249);
		
	}
	
	public ListNode generateMaxList(ListNode head1, ListNode head2)
	{
		ListNode result = new ListNode(-1);
		
		ListNode preva = head1; 
		ListNode prevb = head2;
		
		ListNode h1= head1;
		ListNode h2 = head2;
		
		while(head1 != null || head2 != null)
		{
			int sum1 = 0;
			int sum2 = 0;
			
			while(head1 != null && head2 != null && head1.data != head2.data)
			{
				if(head1.data < head2.data)
				{
					sum1+= head1.data;
					head1 = head1.next;
				}
				else
				{
					sum2 += head2.data;
					head2 = head2.next;
				}
			}	
				if (head1 == null)
				{
					while(head2 != null)
					{
						sum2+= head2.data;
						head2 = head2.next;
					}
				}
				if (head2 == null)
				{
					while(head1 != null)
					{
						sum1+= head1.data;
						head1 = head1.next;
					}
				}
				
				if(preva == h1 && prevb == h2)
				{
					result = (sum1 > sum2 ) ? preva : prevb;
				}
				else
				{
					if(sum1 > sum2)
					{
						prevb.next = preva.next;
					}
					else
					{
						preva.next = prevb.next;
					}
				}
				preva = head1; 
				prevb = head2;
				if(head1 != null)
					head1 = head1.next;
				if(head2 != null)
					head2 = head2.next;
			
		}
		
		return result;
	}
	public static void main(String[] args) {
		
		MaxSumAcrossLL m  = new MaxSumAcrossLL();
		m.constructList();
		ListNode out = m.generateMaxList(m.head1, m.head2);
		m.printList(out);
	}

}
