package geekforgeeks;

public class MergeSortLinkedList {

	ListNode head = new ListNode(14);
	
	public void createList()
	{
		this.head.next = new ListNode(4);
		this.head.next.next = new ListNode(9);
		this.head.next.next.next = new ListNode(1);
	//	this.head.next.next.next.next = new ListNode(15);
	//	this.head.next.next.next.next.next = new ListNode(10);
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
	
	public ListNode mergeSort(ListNode head)
	{
		if(head == null || head.next == null)
			return head;
		
		int countNodes = 0;
		ListNode newHead = head;
		while(newHead != null)
		{
			countNodes++;
			newHead = newHead.next;
		}
		
		int mid = countNodes/2;
		int halfCntr = 0;
		ListNode l = head; ListNode r = null;
		ListNode p2 = head;
		
		while(p2 != null)
		{
			halfCntr++;
			ListNode p2Next = p2.next;
			if(halfCntr == mid)
			{
				p2.next = null;
				r= p2Next;
			}
			p2 = p2Next;
		}
		
		// now we have two parts l and r, recursively sort them
		ListNode h1 = mergeSort(l);
		ListNode h2 = mergeSort(r);
 
		// merge together
		ListNode merged = merge(h1, h2);
 
		return merged;
	}
	
	public ListNode merge(ListNode l, ListNode r)
	{
		ListNode fake = new ListNode(1000000000);
		ListNode pNew = fake;
		
		while(l!= null || r!= null)
		{
			if(l == null)
			{
				pNew.next = new ListNode(r.data);
				pNew = pNew.next;
				r = r.next;
			}
			if( r == null)
			{
				pNew.next = new ListNode(l.data);
				pNew = pNew.next;
				l = l.next;
			}
			else
			{
				
					if(l.data < r.data)
					{
						pNew.next = new ListNode(l.data);
						pNew = pNew.next;
						l = l.next;
					}
					else if(l.data == r.data)
					{
						pNew.next = new ListNode(l.data);
						pNew.next.next = new ListNode(r.data);
						pNew = pNew.next.next;
						l = l.next;
						r = r.next;
					}
					else
					{
						pNew.next = new ListNode(r.data);
						pNew = pNew.next;
						r = r.next;
					}
				}
				
			
		}
		return fake.next;
	}
	
	public void reverseList(ListNode head)
	{
		ListNode curr = head;
		ListNode prev = null;
		ListNode temp = null;
		while(curr != null)
		{
			
			if(curr.next != null)
			{
				temp = curr.next;
			}
			else
			{
				temp = null;
			}
			
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		this.head = prev;
	}

	public static void main(String [] args)
	{
		MergeSortLinkedList m = new MergeSortLinkedList();
		m.createList();
	//	ListNode r = m.mergeSort(m.head);
	//	m.head = r;
		m.printList();
		System.out.println("Rev");
		m.reverseList(m.head);
		//m.head = r;
		m.printList();
		
		ListNode l1 = new ListNode(12);
		l1.next = new ListNode(6);
		l1.next.next = new ListNode(29);
		
		ListNode l2 = new ListNode(23);
		l2.next = new ListNode(5);
		l2.next = new ListNode(8);
		
		ListNode l3 = new ListNode(90);
		l3.next = new ListNode(20);
		l3.next.next = new ListNode(59);
		
		
	}
	
}
