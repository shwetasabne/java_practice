package tree;

import java.util.Arrays;

public class BTToBST {

	private class BinaryTreeNode {
		
		int data;
		BinaryTreeNode left ;
		BinaryTreeNode right ;
		BinaryTreeNode (int data)
		{
			this.data = data; 
			this.left = null;
			this.right = null;
		}
	}
	
	public BinaryTreeNode root = new BinaryTreeNode(10);
	
	public void createTree()
	{
		this.root.left = new BinaryTreeNode(2);
		this.root.right = new BinaryTreeNode(7);
		
		this.root.left.left = new BinaryTreeNode(8);
		this.root.left.right = new BinaryTreeNode(4);
	}
	
	public void inOrder(BinaryTreeNode root, int [] count)
	{
		if(root == null)
			return;
		inOrder(root.left, count);

		count[id++] = root.data;
		inOrder(root.right, count);
	}
	
	
	
	public static int id = 0;

	public static void main(String[] args) {
		
		BTToBST b = new BTToBST();
		
		int [] count = new int[5];
		
		b.createTree();
		b.inOrder(b.root, count);
		System.out.println(Arrays.toString(count));
	}

}
