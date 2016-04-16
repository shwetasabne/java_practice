package tree;

import java.util.*;


public class ReverseLevelOrder {


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
	
	public BinaryTreeNode root;
	
	public void printNodes(BinaryTreeNode root)
	{
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		
		q.add(root);
		while(!q.isEmpty())
		{
			BinaryTreeNode temp = q.poll();
			s.push(temp);
			if(temp.left != null)q.add(temp.left);
			if(temp.right!=null)q.add(temp.right);
		}
		
		while(!s.isEmpty())
		{
			System.out.print(s.pop().data+" ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLevelOrder p = new ReverseLevelOrder();
		p.root = p.new BinaryTreeNode(20);
		p.root.left = p.new BinaryTreeNode(8);
		p.root.right = p.new BinaryTreeNode(22);
		
		p.root.left.left = p.new BinaryTreeNode(4);
		p.root.left.right = p.new BinaryTreeNode(12);
		
		p.root.left.right.left = p.new BinaryTreeNode(10);
		p.root.left.right.right = p.new BinaryTreeNode(14);
		
		p.printNodes(p.root);
	}

}
