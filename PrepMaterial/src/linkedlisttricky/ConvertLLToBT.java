package linkedlisttricky;


public class ConvertLLToBT {

	private class BinaryTreeNode {
		
		int data;
		BinaryTreeNode left ;
		BinaryTreeNode right;
		public BinaryTreeNode(int i)
		{
			this.data = i;
			this.left = null;
			this.right = null;
		}
	}
	
	private class ListNode {
		
		int data ;
		ListNode next;
		
		public ListNode(int i)
		{
			this.data = i;
			this.next = null;
		}
	}
	
	public ListNode head;
	
	public void constructList()
	{
		this.head = new ListNode(1);
		this.head.next = new ListNode(2);
		this.head.next.next = new ListNode(3);
		this.head.next.next.next = new ListNode(4);
		this.head.next.next.next.next = new ListNode(5);
		this.head.next.next.next.next.next = new ListNode(6);
	}
	
	public void printList()
	{
		ListNode newHead = this.head;
		while(newHead != null)
		{
			System.out.print(newHead.data + " -> ");
			newHead = newHead.next;
		}
		
	}
	
	public static ListNode h ;
	public BinaryTreeNode constructTree(int n)
	{
		if(n <= 0)
			return null;
		
		BinaryTreeNode left = constructTree(n/2);
		
		BinaryTreeNode root = new BinaryTreeNode(h.data);
		root.left = left;
		h = h.next;
		
		BinaryTreeNode right = constructTree(n-n/2-1);
		root.right = right;
		
		return root;
	}
	
	public void inOrder(BinaryTreeNode root)
	{
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	

	public int countNodes(ListNode head)
	{
		ListNode newHead = head;
		int count = 0;
		while(newHead != null)
		{
			count++;
			newHead = newHead.next;
		}
		return count;
	}
	
	public static void main(String[] args) {
		
		ConvertLLToBT c = new ConvertLLToBT();
		c.constructList() ;
		c.printList();
		int n = c.countNodes(c.head);
		h = c.head;
		//System.out.println("Nodes are "+n);
		BinaryTreeNode root = c.constructTree(n);
		c.inOrder(root);
		
	}

}
