package tree;

public class NumberInRange {

	private class BinaryTreeNode {
		int data ;
		BinaryTreeNode left; 
		BinaryTreeNode right;
		BinaryTreeNode(int data)
		{
			this.data = data; 
			this.left = null;
			this.right = null;
		}
	}
	
	public BinaryTreeNode root = new BinaryTreeNode(20);
	
	public void createTree()
	{
		this.root.left = new BinaryTreeNode(8);
		this.root.right = new BinaryTreeNode(22);
		
		this.root.left.left = new BinaryTreeNode(4);
		this.root.left.right = new BinaryTreeNode(12);
	}
	
	public void printInRange(BinaryTreeNode root, int k1, int k2)
	{
		if(root == null)
			return;
		if(k1 <= root.data && root.data <= k2)
		{
			System.out.println(root.data);
		}
		printInRange(root.left, k1, k2);
		printInRange(root.right, k1, k2);
	}
	
	public static void main(String[] args) {
		
		NumberInRange n = new NumberInRange();
		n.createTree();
		n.printInRange(n.root, 10, 22);

	}

}
