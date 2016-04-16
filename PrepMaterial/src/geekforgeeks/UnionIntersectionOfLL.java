package geekforgeeks;

// Assuming that both lists are sorted
public class UnionIntersectionOfLL {

	 ListNode l1 ;
	 ListNode l2;
	private class ListNode {
		int data ;
		ListNode next ;
		ListNode(int a)
		{
			this.data = a;
			this.next = null;
		}
	}
	
	public void printList(ListNode head)
	{
		while(head!=null)
		{
			System.out.print(head.data+"  ");
			head = head.next;
		}
	}
	
	public void createList1()
	{
		this.l1 = new ListNode(4);
		this.l1.next = new ListNode(10);
		this.l1.next.next = new ListNode(15);
		this.l1.next.next.next = new ListNode(20);
	}
	
	public void createList2()
	{
		this.l2 = new ListNode(2);
		this.l2.next = new ListNode(4);
		this.l2.next.next = new ListNode(8);
		//l1.next.next.next = new ListNode(20);
	}
	
	public void unionAndIntersect(ListNode l1, ListNode l2)
	{
		
		ListNode union = new ListNode (10000) ; // fake head
		ListNode pU = union;
		ListNode inter = new ListNode( 100000 ); // fake head
		ListNode pI = inter;
		
		while(l1 != null || l2 != null)
		{
			//System.out.println("Processing "+l1.data+" "+l2.data);
			if(l1 == null)
			{
				pU.next = new ListNode(l2.data) ;
				pU = pU.next;
				l2 = l2.next;
			}
			else if(l2 == null)
			{
				pU.next = new ListNode(l1.data);
				pU = pU.next;
				l1 = l1.next;
			}
			else{
				if(l1.data < l2.data)
				{
					
					pU.next = new ListNode(l1.data);
					System.out.println("pU is "+pU.data);
					pU = pU.next;
					l1 = l1.next;
				}
				else if(l1.data == l2.data)
				{
					pI.next = new ListNode(l1.data);
					pI = pI.next;
					System.out.println("pI is "+pI.data);
					pU.next = new ListNode(l1.data);
					System.out.println("pU is "+pU.data);
					pU = pU.next;
					l1= l1.next;
					l2 = l2.next;
				}
				else
				{
					pU.next = new ListNode(l2.data);
					System.out.println("pU is "+pU.data);
					pU = pU.next;
					l2 = l2.next;
				}
			}
			
		}
		
		this.printList(union.next);
		System.out.println("hey");
		this.printList(inter.next);
		
	}
	public static void main(String [] args)
	{
		UnionIntersectionOfLL u = new UnionIntersectionOfLL();
		u.createList1();
		u.createList2();
		u.unionAndIntersect(u.l1, u.l2);
	}
}
