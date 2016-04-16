package geekforgeeks;


public class DeleteNodesGreaterOnRight {

	private class ListNode {
		
		int data;
		ListNode next;
		ListNode(int data)
		{
			this.data = data;
			this.next = null;
		}
	}
	
	ListNode l1 = new ListNode(1);
	public void createLists()
	{
		this.l1.next = new ListNode(10);
		this.l1.next.next = new ListNode(7);
		this.l1.next.next.next = new ListNode(9);
		this.l1.next.next.next.next = new ListNode(10);
		this.l1.next.next.next.next.next = new ListNode(6);
		this.l1.next.next.next.next.next.next = new ListNode(2);
		this.l1.next.next.next.next.next.next.next = new ListNode(3);
	}
	
	public void removeNodes()
	{
		ListNode curr = this.l1;
//		System.out.println("cur us "+curr.data);
		ListNode prev = null;
		ListNode slow = null;
		ListNode newHead = null;
		while(curr != null)
		{
	//		System.out.println("curr next is "+curr.data+" prev is "+prev.data);
			if(prev != null && (curr.data > prev.data))
			{
				System.out.println("curr next is "+curr.data+" prev is "+prev.data);
				prev.next = null;
				if(slow == null || slow.data <= prev.data)
				{
					
					newHead = curr;
					System.out.println("new head is " +newHead.data);
				}
				else
				{
					slow.next = curr;
				}
				prev = curr;
				slow = curr;
				System.out.println("slow is "+slow.data);
				curr = curr.next;
			}
			else
			{
				prev = curr;
				curr = curr.next;
				//System.out.println(" "+"slwo "+slow.data );
			}
			
			//System.out.println(" slow "+slow.data);
		}
		if(newHead == null)
			newHead =this.l1;
		System.out.println("**");
		ListNode newCurr = newHead;
		while(newCurr != null)
		{
			System.out.print(" "+newCurr.data+" ");
			newCurr = newCurr.next;
		}
	}
	
	public static void main(String [] args)
	{
		DeleteNodesGreaterOnRight d = new DeleteNodesGreaterOnRight();
		d.createLists();
		d.removeNodes();
	}
}
