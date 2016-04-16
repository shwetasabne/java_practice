package tree;

public class DeepestDepthOddLevel {

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
	
	public int deepestLeaf(BinaryTreeNode root, int level)
	{
		if(root == null)
			return 0;
		if(root.left == null && root.right == null && (level%2) != 0)
		{
			return level;
		}
		return Math.max(deepestLeaf(root.left, level+1), deepestLeaf(root.right, level+1));
	}
	
	public void createTree()
	{
		this.root.left = new BinaryTreeNode(2);
		this.root.right = new BinaryTreeNode(3);
		
		
		this.root.left.left = new BinaryTreeNode(4);
		
		this.root.right.left = new BinaryTreeNode(5);
		this.root.right.right = new BinaryTreeNode(6);
		
		this.root.right.left.right = new BinaryTreeNode(7);
		this.root.right.right.right = new BinaryTreeNode(8);
		
		this.root.right.left.right.left = new BinaryTreeNode(9);
		this.root.right.right.right.right = new BinaryTreeNode(10);
		this.root.right.right.right.left = new BinaryTreeNode(11);
	}

	public static void main(String[] args) {
		
		DeepestDepthOddLevel d = new DeepestDepthOddLevel();
		d.createTree();
		System.out.println(d.deepestLeaf(d.root, 1));
	}

}
