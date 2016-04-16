package linkedlisttricky;

import java.util.Arrays;

public class MergeLiss {

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
		this.head1.next = new ListNode(2);
		this.head1.next.next = new ListNode(3);
		
		this.head2 = new ListNode(4);
		this.head2.next = new ListNode(5);
		this.head2.next.next = new ListNode(6);
		this.head2.next.next.next = new ListNode(7);
		this.head2.next.next.next.next = new ListNode(8);
	}	
	
	public void mergeLists(ListNode head1, ListNode head2)
	{
		ListNode [] nodes = new ListNode[2];
		ListNode prev = null;
		while(head1 != null)
		{
			if(prev == null)
			{
				prev = head1;
			}
			else 
			{
				ListNode origHead2Next = head2.next;
				prev.next = head2 ;
				head2.next = head1;
				head2 = origHead2Next;
				prev = head1;
			}
			head1 = head1.next;
		}
		
		ListNode origHead2 = head2;
		prev.next = head2;
	//	System.out.println(prev.next.data);
		
	//	head2 = head2.next;
		this.head2 = head2.next;
		prev.next.next = null;
		//return nodes;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeLiss m = new MergeLiss();
		m.constructList();
		m.mergeLists(m.head1, m.head2);
		m.printList(m.head1);
		System.out.println();
		m.printList(m.head2);
		
	}

}
