package linkedlisttricky;



public class MixedSwapping {

private class ListNode {
		
		int data ;
		ListNode next;
		
		public ListNode(int i)
		{
			this.data = i;
			this.next = null;
		}
	}
	
	public ListNode head;
	
	public void constructList()
	{
		this.head = new ListNode(1);
		this.head.next = new ListNode(2);
		this.head.next.next = new ListNode(3);
		this.head.next.next.next = new ListNode(4);
		this.head.next.next.next.next = new ListNode(5);
//		this.head.next.next.next.next.next = new ListNode(6);
	}
	
	public void printList()
	{
		ListNode newHead = this.head;
		while(newHead != null)
		{
			System.out.print(newHead.data + " -> ");
			newHead = newHead.next;
		}
		
	}
	
	public void swapMixed()
	{
		ListNode curr = this.head;
		ListNode prev = null;
		
		while(curr != null && curr.next != null)
		{
			ListNode origNext = curr.next;
			ListNode newNext = curr.next.next;
			curr.next = newNext;
			origNext.next = curr;
			if(prev == null)
			{
				this.head = origNext;
			}
			else
			{
				prev.next = origNext;
			}
			prev = curr;
			curr = newNext;
		}
	}

	public static void main(String[] args) {
		
		MixedSwapping  m = new MixedSwapping();
		m.constructList();
		m.printList();
		System.out.println();
		m.swapMixed();
		m.printList();
	}

}
