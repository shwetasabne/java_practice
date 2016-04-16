package glassdoor;

public class MergeSortLinkedList {

	private class ListNode {
		int data;
		ListNode next;
		ListNode(int data)
		{
			this.data = data;
			this.next = null;
		}
	}

	
	
	public ListNode mergeLists(ListNode n1, ListNode n2)
	{
	    ListNode mergedHead = new ListNode(-1000); // fake head
		ListNode newHead = mergedHead;
		while(n1 != null || n2 != null)
		{
			if(n2 == null)
			{
				newHead.next = new ListNode(n1.data);
				n1 = n1.next;
				newHead = newHead.next;
			}
			else if(n1 == null)
			{
				newHead.next = new ListNode(n2.data);
				n2 = n2.next;
				newHead = newHead.next;
			}
			else if(n1.data > n2.data)
			{
				newHead.next = new ListNode(n2.data);
				n2 = n2.next;
				newHead = newHead.next;
			}
			else if(n1.data == n2.data)
			{
				newHead.next = new ListNode(n1.data);
				n1 = n1.next;
				newHead = newHead.next;
				newHead.next= new ListNode(n2.data);
				newHead = newHead.next;
				n2 = n2.next;
			}
			else
			{
				newHead.next = new ListNode(n1.data);
				n1 = n1.next;
				newHead = newHead.next;
			}
		}
		
		return mergedHead.next;
	}
	
	public static void main(String[] args) {
		
		MergeSortLinkedList m = new MergeSortLinkedList();
		ListNode n1 = m.new ListNode(1);
		n1.next = m.new ListNode(3);
		n1.next.next = m.new ListNode(5);
		n1.next.next.next = m.new ListNode(5);
		n1.next.next.next.next = m.new ListNode(7);
		
		ListNode n2 = m.new ListNode(2);
		n2.next = m.new ListNode(4);
		n2.next.next = m.new ListNode(6);
		
		ListNode out = m.mergeLists(n1, n2);
		while(out != null)
		{
			System.out.print(out.data + " ");
			out = out.next;
		}

	}

}
