package tree;

public class MaxDepth {

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
	
	public BinaryTreeNode root;
	
	public int maxDepth(BinaryTreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		else
		{
			return Math.max(maxDepth(root.right), maxDepth(root.left))+1;
		}
	}
	
	public static void main(String[] args) {
		

	}

}
