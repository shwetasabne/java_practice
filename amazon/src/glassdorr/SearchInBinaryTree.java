package glassdorr;

public class SearchInBinaryTree {

	private class BinaryTreeNode {
		
		int data; 
		BinaryTreeNode left; 
		BinaryTreeNode right ;
		
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
		this.root.left = new BinaryTreeNode(1);
		this.root.right = new BinaryTreeNode(2);
		
		this.root.left.left = new BinaryTreeNode(3);
		this.root.left.right = new BinaryTreeNode(4);
		
		this.root.left.right.left = new BinaryTreeNode(5);
		this.root.left.right.right = new BinaryTreeNode(6);
		
		this.root.left.right.right.left = new BinaryTreeNode(7);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
