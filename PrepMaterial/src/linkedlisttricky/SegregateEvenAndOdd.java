package linkedlisttricky;

public class SegregateEvenAndOdd {

	private class ListNode {
		int data ;
		ListNode next ; 
		public ListNode(int data)
		{
			this.data = data;
			this.next = null;
		}
		
		public String toString()
		{
			return String.valueOf(this.data);
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
	
	public ListNode segregateList(ListNode head)
	{
		ListNode prev = null;
		ListNode oddHead = new ListNode(-1);
		ListNode evenHead = new ListNode(-2);
		ListNode lastEven = null;
		ListNode oH = oddHead;
		ListNode eH = evenHead;
		
		
		while(head != null)
		{
			if(head.data %2 != 0)
			{
				oH.next = new ListNode(head.data);
				oH = oH.next;
		//		System.out.println("oh i s "+oH.data);
			}
			else
			{
				eH.next = new ListNode(head.data);
			
				eH = eH.next;
			}
			head = head.next;
		}
		
	//	System.out.println("alst even is "+lastEven.data);
		eH.next = oddHead.next;
		
		return evenHead.next;
	}
	
	
	public static void main(String[] args) {
		
		SegregateEvenAndOdd s = new SegregateEvenAndOdd();
		s.constructList();
		ListNode out = s.segregateList(s.head);
		s.printList(out);

	}

}
