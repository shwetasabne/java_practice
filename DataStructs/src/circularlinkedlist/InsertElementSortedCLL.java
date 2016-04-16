package circularlinkedlist;

public class InsertElementSortedCLL {

	private class Node {
		int data;
		//Node prev;
		Node next;
		
		public Node(int data)
		{
			this.data = data;
		//	this.prev = null;
			this.next = null;
		}
	}
	
	public Node head ;
	
	public Node createCircularLinkedList()
	{
		head = new Node(1);
		
		Node element1 = new Node(3);
		head.next = element1;
		element1.next = head;
		
		return head;
	}

	public void insertNode(Node newNode)
	{
		if(this.head == null)
		{
			this.head = newNode;
			this.head.next = newNode;
			return;
		}
		//First node is the head
		Node fNode = this.head;
		//Get last Node
		Node curr = this.head.next;
		Node prev = this.head;
		while(curr != null && curr != this.head)
		{
			prev = curr;
			curr = curr.next;
		}
		Node lNode = prev;
		if(newNode.data < this.head.data)
		{
			Node temp = this.head;
			this.head = newNode;
			newNode.next = temp;
			lNode.next = this.head;
			return;
		}
		
		else if(newNode.data > lNode.data)
		{
			lNode.next = newNode;
			newNode.next = this.head;
			return;
		}
		else
		{
			Node curr1 = this.head.next;
			Node prev1 = this.head;
			while(curr1 != null && curr1 != this.head)
			{
				if(newNode.data < curr1.data)
				{
					break;
				}
				prev1 = curr1;
				curr1 = curr1.next;
			}
			prev1.next = newNode;
			newNode.next = curr1;
			
		}
		
	}
	
	public void printList()
	{
		Node curr = this.head.next;
		System.out.print(this.head.data +" ");
		while(curr != null && curr != this.head)
		{
			System.out.print(" "+curr.data);
			curr = curr.next;
		}
	}
	public static void main(String[] args) {
	
		InsertElementSortedCLL i = new InsertElementSortedCLL();
		i.createCircularLinkedList();
		i.printList();
		i.insertNode(i.new Node(0));
		System.out.println();
		i.printList();
		i.insertNode(i.new Node(5));
		System.out.println();
		i.printList();
		i.insertNode(i.new Node(2));
		System.out.println();
		i.printList();
	}

}
