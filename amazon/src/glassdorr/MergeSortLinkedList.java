package glassdorr;

public class MergeSortLinkedList {

	private class ListNode {
		int data; 
		ListNode next;
		
		public ListNode(int data)
		{
			this.data = data;
			this.next = null;
		}
	}
	
	public ListNode head ; 
	
	public void createList()
	{
		this.head = new ListNode(1);
		this.head.next = new ListNode(3);
		this.head.next.next = new ListNode(5);
		this.head.next.next.next = new ListNode(7);
		this.head.next.next.next.next = new ListNode(2);
		this.head.next.next.next.next.next = new ListNode(4);
		this.head.next.next.next.next.next.next = new ListNode(6);
		this.head.next.next.next.next.next.next.next = new ListNode(8);
		this.head.next.next.next.next.next.next.next.next = new ListNode(9);
	}

	public ListNode mergeList(ListNode head)
	{
		if(head == null || head.next == null)
			return head;
		
		int count = 0;
		ListNode p = head;
		while(p != null)
		{
			p = p.next;
			count++;
		}
		
		int count_middle = count/2;
		ListNode l = head;
		ListNode r = null;
		p = head;
		int cntr = 0;
		while(p != null)
		{
			cntr++;
			ListNode next = p.next;
			if(cntr == count_middle)
			{
				p.next = null;
				r = next;
			}
			p = next;
		}
		ListNode h1 = mergeList(l);
		ListNode h2 = mergeList(r);
		
		ListNode merged = merged(h1, h2);
		return merged;
	}
	
	public ListNode merged(ListNode h1, ListNode h2)
	{
		ListNode fakeHead = new ListNode(-1);
		ListNode pHead = fakeHead;
		
		ListNode l =h1;
		ListNode r = h2;
		
		while(l != null || r != null)
		{
			if(l == null)
			{
				pHead.next = new ListNode(r.data);
				r = r.next;
				pHead = pHead.next;
			}
			else if(r == null)
			{
				pHead.next = new ListNode(l.data);
				l = l.next;
				pHead = pHead.next;
			}
			else
			{
				if(l.data < r.data)
				{
					pHead.next = new ListNode(l.data);
					pHead = pHead.next;
					l = l.next;
				}
				else if(l.data == r.data)
				{
					pHead.next = new ListNode(l.data);
					pHead = pHead.next;
					
					pHead.next = new ListNode(r.data);
					pHead = pHead.next;
					
					l = l.next;
					r = r.next;
				}
				else
				{
					pHead.next = new ListNode(r.data);
					pHead = pHead.next;
					r = r.next;
				}
			}
		}
		return fakeHead.next;
	}
	
	public void printList(ListNode head)
	{
		ListNode newHead = head;
		while(newHead != null)
		{
			System.out.print(newHead.data + " -> ");
			newHead = newHead.next;
		}
		
	}
	public static void main(String[] args) {
		
		MergeSortLinkedList m = new MergeSortLinkedList();
		m.createList();
	//	m.printList(m.head);
		System.out.println();
		ListNode out = m.mergeList(m.head);
		m.printList(out);

	}

}
