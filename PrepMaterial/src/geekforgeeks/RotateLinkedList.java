package geekforgeeks;

public class RotateLinkedList {

	private class ListNode {
		int data ;
		ListNode next ;
		ListNode(int data)
		{
			this.data = data;
			this.next = null;
		}
	}
	
	ListNode head = new ListNode(10);
	public void createListNode()
	{
		this.head.next = new ListNode(20);
		this.head.next.next = new ListNode(30);
		this.head.next.next.next = new ListNode(40);
		this.head.next.next.next.next = new ListNode(50);
		this.head.next.next.next.next.next = new ListNode(60);
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
	
	public ListNode rotateList(int K)
	{
		ListNode newHead = null;
		ListNode curr = this.head;
		int cntr = 0;
		ListNode k = null;
		ListNode kPlusOne = null;
		while(curr.next != null)
		{
		//	System.out.println("Curr is "+curr.data);
			cntr++;
			if(cntr == K)
			{
				k = curr;
				kPlusOne = curr.next;
			}
			curr = curr.next;
		}
	//	System.out.println("Curr is "+curr.data);
		k.next = null;
		curr.next = this.head;
		this.head = kPlusOne;
		
		return this.head;
	}
	
	public static void main(String [] args)
	{
		RotateLinkedList rll = new RotateLinkedList();
		rll.createListNode();
		rll.printList();
		System.out.println("*");
		rll.rotateList(3);
		rll.printList();
	}
}
