package tree;

public class KSmallestElement {

	private class BinarySearchTreeNode {
		int data;
		BinarySearchTreeNode left ;
		BinarySearchTreeNode right ;
		
		BinarySearchTreeNode (int data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public BinarySearchTreeNode root = new BinarySearchTreeNode(20);
	
	public void createTree()
	{
		this.root.left = new BinarySearchTreeNode(8);
		this.root.right = new BinarySearchTreeNode(22);
		
		this.root.left.left = new BinarySearchTreeNode(4);
		this.root.left.right = new BinarySearchTreeNode(12);
		
		this.root.left.right.left = new BinarySearchTreeNode(10);
		this.root.left.right.right = new BinarySearchTreeNode(14);
	}
	
	public static int i = 0;
	
	public void kthSmallest(BinarySearchTreeNode root, int k)
	{
		if(root == null)
			return ;
		kthSmallest(root.left, k);
		if(++i == k)
			System.out.print(root.data);
		kthSmallest(root.right, k);
	}
	
	public static void main(String[] args) {
		
		KSmallestElement k = new KSmallestElement();
		k.createTree();
		k.kthSmallest(k.root, 3);
	}

}
