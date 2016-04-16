package geekforgeeks;


public class DeleteNnodesAferM {

	private class ListNode {
		int data ;
		ListNode next;
		
		ListNode(int data)
		{
			this.data = data;
			this.next = null;
		}
	}
	
	ListNode head = new ListNode(1);
	
	public void createList()
	{
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
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
	
	
	public void deleteNafterM(int M, int N)
	{
		if( M <= 0 && N <= 0)
			return;
		
		ListNode slow = this.head;
		ListNode fast = this.head;
		int mCntr = 0;
		int nCntr = 0;
		while(fast != null)
		{
			System.out.println("SLow is "+slow.data+" fast "+fast.data+" mCntr "+mCntr+" nCntr "+nCntr);
			if(mCntr == M-1)
			{
				if(nCntr == N)
				{
					
					slow.next = fast.next;
					fast.next = null;
					slow = slow.next;
					fast = slow;
					mCntr = 0;
					nCntr = 0;
					//System.out.println("AFter removal "+ "SLow is "+slow.data+" fast "+fast.data+" mCntr "+mCntr+" nCntr "+nCntr);
				}
				else
				{
					fast = fast.next;
					nCntr++;
				}
			}
			else
			{
				slow = slow.next;
				fast = fast.next;
				mCntr++;
			}
		}
	}
	public static void main(String [] args)
	{
		DeleteNnodesAferM d = new DeleteNnodesAferM();
		d.createList();
		d.printList();
		System.out.println("Afte removal");
		d.deleteNafterM(2, 2);
		d.printList();
	}
	
}
