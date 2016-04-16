package tree;

import java.util.*;





public class PrintMirrorTree {

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
	
	public void inOrder(BinaryTreeNode root)
	{
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print (root.data + " ");
		inOrder(root.right);
	}
	
	
	public void printTreeSpiral(BinaryTreeNode root)
	{
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		
		Queue<Integer> spiralEven = new LinkedList<Integer>();
		Queue<Integer> spiralOdd = new LinkedList<Integer>();
		
		
		int level = 1;
		q.add(root);
		
		BinaryTreeNode marker = new BinaryTreeNode(-1);
		q.add(marker);
		while(!q.isEmpty())
		{
			BinaryTreeNode temp = q.poll();
			if(temp == marker && q.size() > 1)
			{
				level++;
				q.add(marker);
				continue;
			}
			if(level%2 == 0)
			{
				spiralEven.add(temp.data);
			}
			else
			{
				//System.out.println("Pusing "+temp.data);
				spiralOdd.add(temp.data);
			}
			if(temp.left !=null) q.add(temp.left);
			if(temp.right!=null) q.add(temp.right);
		}
		
		System.out.println(spiralEven.toString());
		System.out.println(spiralOdd.toString());
		
	}
	public void createMirror(BinaryTreeNode root)
	{
		if(root == null)
			return;
		else
		{
			createMirror(root.left);
			createMirror(root.right);
			BinaryTreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintMirrorTree a = new PrintMirrorTree();
		a.root1 = a.new BinaryTreeNode(1);
		
		a.root1.left = a.new BinaryTreeNode(2);
		a.root1.right = a.new BinaryTreeNode(3);
		
		a.root1.left.left = a.new BinaryTreeNode(4);
		a.root1.left.right = a.new BinaryTreeNode(5);
		a.root1.right.left = a.new BinaryTreeNode(6);
		a.root1.right.right = a.new BinaryTreeNode(7);
		a.inOrder(a.root1);
		//a.createMirror(a.root1);
		System.out.println("");
		//a.inOrder(a.root1);
		a.printTreeSpiral(a.root1);
	}

}
