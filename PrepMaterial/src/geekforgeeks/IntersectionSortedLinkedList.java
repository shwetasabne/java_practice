package geekforgeeks;

public class IntersectionSortedLinkedList {
	
	private class ListNode {
		int data;
		ListNode next;
		
		ListNode(int data)
		{
			this.data = data;
			this.next = next;
		}
	}
	
	ListNode l1 = new ListNode(1);
	ListNode l2 = new ListNode(2);
	
	public void createLists()
	{
		this.l1.next = new ListNode(2);
		this.l1.next.next = new ListNode(3);
		this.l1.next.next.next = new ListNode(4);
		this.l1.next.next.next.next = new ListNode(5);
		this.l1.next.next.next.next.next = new ListNode(6);
		
		this.l2.next = new ListNode(4);
		this.l2.next.next = new ListNode(6);
		this.l2.next.next.next = new ListNode(8);
	}
	
	public ListNode intersectingList(ListNode l1, ListNode l2)
	{
		ListNode retHead = new ListNode(10000);
		ListNode temp = retHead;
		
		while(l1 != null && l2 != null)
		{
			if(l1.data < l2.data)
			{
				l1 = l1.next;
			}
			else if(l1.data == l2.data)
			{
				
				temp.next = new ListNode(l1.data);
				l1 = l1.next;
				l2 = l2.next;
				
				temp = temp.next;
			}
			else
			{
				l2 = l2.next;
			}
		}
		return retHead.next;
	}
	
	public static void main (String [] args)
	{
		IntersectionSortedLinkedList i = new IntersectionSortedLinkedList();
		i.createLists();
		
		ListNode out = i.intersectingList(i.l1, i.l2);
		while(out !=null)
		{
			System.out.println(" "+out.data+" ");
			out  = out.next;
		}
	}
	
	
}
