package tree;




public class PrintAllPathsFromRootToLeaves {

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
		
		public String toString()
		{
			return String.valueOf(this.data);
		}
	}

	public BinaryTreeNode root1 ;
	public static int totalSum = 0;
	public void printPaths(BinaryTreeNode root, String temp)
	{
		if(root == null)
			System.out.println(temp);
		else
		{
			
				printPaths(root.left, temp + String.valueOf(root.data));
			
				printPaths(root.right, temp + String.valueOf(root.data));
		}
	}
	
	public int sumPaths(BinaryTreeNode root, Integer pathSum)
	{
		if(root == null)
			totalSum+=pathSum;
		else
		{

			sumPaths(root.left , pathSum+root.data);
			sumPaths(root.right, pathSum+root.data);
		}
		return totalSum;
	}
	
	public int sumFored(BinaryTreeNode root, Integer value)
	{
		if(root == null)
			return value;
		
		value = value * 10 + root.data;
		
		if(root.left == null && root.right == null)
			return value;
		
		return (sumFored(root.left, value) + sumFored(root.right, value));
	}
	
	public static void main(String[] args) {
		
		PrintAllPathsFromRootToLeaves a = new PrintAllPathsFromRootToLeaves();
		a.root1 = a.new BinaryTreeNode(1);
		
		a.root1.left = a.new BinaryTreeNode(2);
		a.root1.right = a.new BinaryTreeNode(3);
		
		a.root1.left.left = a.new BinaryTreeNode(4);
		a.root1.left.right = a.new BinaryTreeNode(5);
		a.root1.right.left = a.new BinaryTreeNode(6);
		a.root1.right.right = a.new BinaryTreeNode(7);
		a.printPaths(a.root1, "");
		System.out.println(" ");
		System.out.println(a.sumPaths(a.root1, 0)/2);
		System.out.println(" ");
		System.out.println(a.sumFored(a.root1, 0));
	}

}
