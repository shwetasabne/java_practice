package tree;



public class PrintAncestors {

	private class BinaryTreeNode {
		
		int data; 
		BinaryTreeNode left; 
		BinaryTreeNode right; 
		
		BinaryTreeNode(int data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public BinaryTreeNode root = new BinaryTreeNode(1);
	
	public void createTree()
	{
		this.root.left = new BinaryTreeNode(2);
		this.root.right = new BinaryTreeNode(3);
		
		this.root.left.left = new BinaryTreeNode(4);
		this.root.left.right = new BinaryTreeNode(5);
		
		this.root.right.left = new BinaryTreeNode(6);
		this.root.right.right = new BinaryTreeNode(7);
		
		this.root.right.left.right = new BinaryTreeNode(8);
		
	}
	
	public boolean printAncestors(BinaryTreeNode root, BinaryTreeNode n1)
	{
		if(root == null)
			return false;
		if(root.data == n1.data)
		{
			return true;
		}
		if(printAncestors(root.left, n1) || printAncestors(root.right, n1))
		{
			System.out.println(root.data);
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		PrintAncestors p = new PrintAncestors();
		p.createTree();
		BinaryTreeNode n = p.new BinaryTreeNode(8);
		p.printAncestors(p.root, n);
	}

}
