package glassdoor;

public class ConvertBTtoDLLInPlace {

private class BinaryTreeNode {
		
		int data;
		BinaryTreeNode left; 
		BinaryTreeNode right; 
		
		public BinaryTreeNode(int data)
		{
			this.data = data; 
			this.left = null;
			this.right = null;
		}
	}
	
	public BinaryTreeNode root;
	
	public void createTree()
	{
		this.root = new BinaryTreeNode(10);
		
		this.root.left = new BinaryTreeNode(5);
		this.root.left.left = new BinaryTreeNode(4);
		this.root.left.right = new BinaryTreeNode(6);
		
		this.root.right = new BinaryTreeNode(15);
		this.root.right.left = new BinaryTreeNode(11);
		this.root.right.right = new BinaryTreeNode(22);
		
		this.root.right.right.left = new BinaryTreeNode(20);
		this.root.right.right.right = new BinaryTreeNode(27);
	}
	
	static BinaryTreeNode pre = null;
	static BinaryTreeNode prev = null;
	public  static void fixPrevPntr(BinaryTreeNode root)
	{
		
		if(root != null)
		{
			fixPrevPntr(root.left);
			root.left = pre;
			pre = root;
			fixPrevPntr(root.right);
		}
	}
	
	public static BinaryTreeNode fixRightPntr(BinaryTreeNode root)
	{
		while(root != null && root.right != null)
			root = root.right;
		
		while(root != null && root.left != null)
		{
			prev = root;
			root = root.left;
			root.right = prev;
		}
		return root;
	}
	
	public static BinaryTreeNode convert(BinaryTreeNode root)
	{
		fixPrevPntr(root);
		
		return fixRightPntr(root);
	}
	
	public static void printList(BinaryTreeNode head)
	{
		while(head!= null)
		{
			System.out.print(" "+head.data);
			head = head.right;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConvertBTtoDLLInPlace b = new ConvertBTtoDLLInPlace();
		b.createTree();
		
		BinaryTreeNode head = b.convert(b.root);
		printList(head);
	}

}
