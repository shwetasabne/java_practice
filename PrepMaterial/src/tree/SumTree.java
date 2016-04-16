package tree;

import java.util.*;



public class SumTree {

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
	
	public boolean isSum(BinaryTreeNode root)
	{
		if(root == null)
			return true;
		if(root.right == null && root.left == null)
			return true;
		int leftData = root.left != null ? root.left.data : 0;
		int rightData = root.right != null ? root.right.data : 0;
		System.out.println(" "+root.data +" "+leftData+" "+rightData);
		if(root.data == (leftData+rightData))
		{
			return ( isSum(root.left) && isSum(root.right));
		}
		else
			return false;
	}
	
	public void inOrder(BinaryTreeNode root)
	{
		if(root == null)
			return;
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}
	public static void main(String[] args) {

		SumTree a = new SumTree();
		
		a.root1 = a.new BinaryTreeNode(10);
		a.root1.left = a.new BinaryTreeNode(8);
		a.root1.right = a.new BinaryTreeNode(2);
		a.root1.left.left = a.new BinaryTreeNode(3);
		a.root1.left.right = a.new BinaryTreeNode(5);
		a.root1.right.left = a.new BinaryTreeNode(2);
	//	a.inOrder(a.root1);
		System.out.println ( a.isSum(a.root1) );
	}

}
