package geekforgeeks;

public class IntersectionOfLinkedLists {

	private class ListNode {
		int data;
		ListNode next;
		ListNode(int data)
		{
			this.data = data;
		}
	}
	
	ListNode l1 = new ListNode(3);
	ListNode l2 = new ListNode(10);
	
	public void createLists()
	{
		this.l1.next = new ListNode(6);
		this.l1.next.next = new ListNode(9);
		this.l1.next.next.next = new ListNode(15);
		this.l1.next.next.next.next = new ListNode(30);
		
		this.l2.next = this.l1.next.next.next;
		this.l2.next.next = new ListNode(30);
	}
	
	public ListNode getIntersectingNodeUtil(ListNode l1, ListNode l2)
	{
		ListNode ret = null;
		ListNode l1Head = l1;
		ListNode l2Head = l2;
		//Count the nodes in l1
		int cntr1 = 0;
		while(l1 != null)
		{
			cntr1++;
			l1=l1.next;
		}
		
		//Count nodes in l2
		int cntr2 = 0;
		while(l2 != null)
		{
			cntr2++;
			l2 = l2.next;
		}
		
		int diff = cntr1 - cntr2;
		
		int newCntr = 0;
		while(l1Head != null)
		{
			if(newCntr == diff)
				break;
			else
				newCntr++;
				l1Head = l1Head.next;
				
		}
		System.out.println("cntr1 "+cntr1+"  cntr2 "+cntr2+"  newCntr "+newCntr+" diff "+diff+" ne "+l1Head.data);
		while(l1Head!= null && l2Head != null)
		{
			if(l1Head.data == l2Head.data)
			{
				System.out.println("Found intersectin node "+l1Head.data);
				return l1Head;
			}
			else
			{
				l1Head = l1Head.next;
				l2Head = l2Head.next;
			}
					
		}
		
		return ret;
	}
	
	public static void main(String [] args)
	{
		IntersectionOfLinkedLists i = new IntersectionOfLinkedLists();
		i.createLists();
		i.getIntersectingNodeUtil(i.l1, i.l2);
	}
}
