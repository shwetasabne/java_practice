package geekforgeeks;

public class InterLeavingLinkedList {

	private class ListNode {
		int data;
		ListNode next;
		ListNode(int data)
		{
			this.data = data;
			this.next = null;
		}
	
		public String toString()
		{
			return String.valueOf(this.data);
		}
	}
	
	
	public ListNode list1 = new ListNode(1) ;
	public ListNode list2 = new ListNode(2);
	
	public void createList ()
	{
		this.list1.next = new ListNode(3);
		this.list1.next.next = new ListNode(5);
		this.list1.next.next.next = new ListNode(7);
		this.list1.next.next.next.next = new ListNode(9);
		
		this.list2.next = new ListNode(4);
		this.list2.next.next = new ListNode(6);
		this.list2.next.next.next = new ListNode(8);
	}
	
	public void interLeave(ListNode l1, ListNode l2)
	{
		ListNode l3Head = new ListNode(-1); // fake head
		ListNode l3 = l3Head;
		boolean list1 = true;
	//	System.out.println(l1.next.data);
		while(l1 != null || l2 != null)
		{

			if(list1)
			{
				l3.next = new ListNode(l1.data);
				l3 = l3.next;
				l1 = l1.next;
				list1 = false;
			}
			else
			{
				l3.next = new ListNode(l2.data);
				l3 = l3.next;
				l2 = l2.next;
				list1 = true;
			}
		}
		while(l3Head != null)
		{
			System.out.print(l3Head.data+" ");
			l3Head = l3Head.next;
		}
		//return l3Head.next;
	}
	
	public static void main(String[] args) {
		
		InterLeavingLinkedList i = new InterLeavingLinkedList();
		i.createList();
		i.interLeave(i.list1, i.list2);

	}

}
