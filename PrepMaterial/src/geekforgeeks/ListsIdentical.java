package geekforgeeks;

public class ListsIdentical {

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
	ListNode l2 = new ListNode(1);
	
	public void createLists()
	{
		this.l1.next = new ListNode(2);
		this.l1.next.next = new ListNode(3);
		
		this.l2.next = new ListNode(2);
		this.l2.next.next = new ListNode(6);
	}
	
	public boolean areListsIdentical(ListNode l1, ListNode l2)
	{
		ListNode curr1 = l1;
		ListNode curr2 = l2;
		
		while(curr1 != null || curr2 != null)
		{
			if((curr1 == null && curr2 != null) || (curr1 !=null && curr2 == null))
				return false;
			
			if(curr1.data != curr2.data)
				return false;
			
			curr1 = curr1.next;
			curr2 = curr2.next;
		}
		return true;
	}
	
	public static void main(String [] args)
	{
		ListsIdentical li = new ListsIdentical();
		li.createLists();
		
		System.out.println(li.areListsIdentical(li.l1, li.l2));
	}
}
