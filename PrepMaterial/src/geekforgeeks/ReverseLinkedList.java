package geekforgeeks;

public class ReverseLinkedList {

	private class ListNode {
		int data;
		ListNode next;
		ListNode(int data)
		{
			this.data = data;
			this.next = null;
		}
	}
	
	public ListNode l1 = new ListNode(1);
	
	public void createList()
	{
		this.l1.next = new ListNode(2);
		this.l1.next.next = new ListNode(3);
		this.l1.next.next.next = new ListNode(4);
	}
	
	public void reverseList(ListNode curr)
	{
		 ListNode prev = null;
		 while(curr != null)
		 {
			 ListNode temp = curr.next;
			 curr.next = prev;
			 prev = curr;
			 curr = temp;
		 }
		 while(prev != null)
		 {
			 System.out.print(prev.data + " ");
			 prev = prev.next;
		 }
	}
	
	public static void main(String[] args) {
		ReverseLinkedList r = new ReverseLinkedList();
		r.createList();
		r.reverseList(r.l1);

	}

}
