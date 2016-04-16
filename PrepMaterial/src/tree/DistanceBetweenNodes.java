package tree;

public class DistanceBetweenNodes {

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
	
	public BinaryTreeNode lca(BinaryTreeNode root, int n1, int n2)
	{
		if(root == null)
			return null;
		if(root.data == n1 || root.data == n2)
		{
			return root;
		}
		BinaryTreeNode l = this.lca(root.left, n1, n2);
		BinaryTreeNode r = this.lca(root.right, n1, n2);
		if(l != null && r != null)
			return root;
		return l != null ? l : r;
	}
	
	public int distFromRoot(BinaryTreeNode root, BinaryTreeNode n, int lvl)
	{
		if(root == null)
			return -1;
		if(root.data == n.data)
		{
			return lvl;
		}
		
		int l = this.distFromRoot(root.left, n, lvl+1);
		return  (l != -1) ?  l : this.distFromRoot(root.right, n, lvl+1);
		
	}
	public static void main(String[] args) {
		
		DistanceBetweenNodes d = new DistanceBetweenNodes();
		d.createTree();
		BinaryTreeNode b = d.lca(d.root, 4, 6);
		System.out.println(b.data);
		
		BinaryTreeNode n1 = d.new BinaryTreeNode(8);
		System.out.println("Dist of n1 "+ d.distFromRoot(d.root, n1, 0));
		
		BinaryTreeNode n2 = d.new BinaryTreeNode(5);
		System.out.println("Dist of n2 "+ d.distFromRoot(d.root, n2, 0));
		
		System.out.println("Dist of lc "+ d.distFromRoot(d.root, b, 0));
		
		//int dist between 2 nodes =  dist (root, n1) + dist (root, n2) - dist (root, lca);
	}

}
