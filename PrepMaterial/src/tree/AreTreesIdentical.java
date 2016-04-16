package tree;

public class AreTreesIdentical {


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
	
	public BinaryTreeNode root1; 
	public BinaryTreeNode root2;
	
	public boolean isSame(BinaryTreeNode root1, BinaryTreeNode root2)
	{
		if(root1 == null && root2 != null)
			return false;
		if(root2 == null && root1 != null)
			return false;
		if(root1 == null && root2 == null)
			return true;
		if(root1.data == root2.data && 
				isSame(root1.left, root2.left) &&
				isSame(root1.right, root2.right))
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		
		AreTreesIdentical a = new AreTreesIdentical();
		a.root1 = a.new BinaryTreeNode(1);
		a.root1.left = a.new BinaryTreeNode(2);
		a.root1.right = a.new BinaryTreeNode(3);
		a.root1.left.left = a.new BinaryTreeNode(4);
		a.root1.left.right = a.new BinaryTreeNode(5);

		a.root2 = a.new BinaryTreeNode(1);
		a.root2.left = a.new BinaryTreeNode(2);
		a.root2.right = a.new BinaryTreeNode(3);
		a.root2.left.left = a.new BinaryTreeNode(4);
	//	a.root2.left.right = a.new BinaryTreeNode(5);
		
		System.out.println(a.isSame(a.root1, a.root2));
	}

}
