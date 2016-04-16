package glassdoor;

public class PrintPathsFromRoot {

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
	
	public void printR2L(BinaryTreeNode root, String temp)
	{
		if(root == null)
			System.out.println(temp);
		else
		{
			printR2L(root.left, temp+" "+root.data);
			printR2L(root.right, temp+" "+root.data);
		}
	}
	
	public static int sum = 0;
	
	public void sumPaths(BinaryTreeNode root, int pathSum)
	{
		if(root == null)
			sum+=pathSum;
		else
		{
			sumPaths(root.left , root.data+pathSum);
			sumPaths(root.right, root.data +pathSum);
		}
	}
	
	public int sumOfAllPaths(BinaryTreeNode root, int val)
	{
		if(root == null)
			return 0;
		
		val = val * 10 + root.data;
		
		if(root.left == null && root.right == null)
			return val;
		
		else
			return sumOfAllPaths(root.left, val) + sumOfAllPaths(root.right, val);
	}
	
	public static void main(String[] args) {
		PrintPathsFromRoot p = new PrintPathsFromRoot();
		p.createTree();
		p.printR2L(p.root, "");
	}

}
