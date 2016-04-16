package tree;

import java.util.Arrays;

public class MaxWidth {

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
		
		this.root.right.left = new BinaryTreeNode(10);
		this.root.right.right = new BinaryTreeNode(8);
		
		this.root.right.right.left = new BinaryTreeNode(6);
		this.root.right.right.right = new BinaryTreeNode(7);
	}
	
	public void maxWidth(BinaryTreeNode root, int [] count, int level)
	{
		if(root != null)
		{
			count[level]++;
			maxWidth(root.left, count, level+1);
			maxWidth(root.right, count, level+1);
		}
	}
	public int getHeight(BinaryTreeNode root)
	{
		if(root == null)
			return 0;
		int l = getHeight(root.left);
		int r = getHeight(root.right);
		
		return l > r ? (l+1) : (r+1);
	}
	
	public void deepestLeftNode(BinaryTreeNode root, int [] count, int level, boolean isLeft)
	{
		if(root != null)
		{
			if(isLeft && count[level] == -1)
			{
				count[level] = root.data;
			}
			deepestLeftNode(root.left, count, level+1, true);
			deepestLeftNode(root.right, count, level+1, false);
		}
	}
	
	public static void main(String[] args) {
		
		MaxWidth m = new MaxWidth();
		m.createTree();
		
		int out = m.getHeight(m.root);
		System.out.println(out);

		int [] count = new int[out];
		m.maxWidth(m.root, count, 0);
		System.out.println(Arrays.toString(count));
		
		int []left = new int[out];
		for(int i=0; i < left.length; i++)
		{
			left[i] = -1;
		}
		m.deepestLeftNode(m.root, left, 0, true);
		System.out.println(Arrays.toString(left));
	}

}
