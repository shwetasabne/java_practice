package tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintNodesBetweenLevels {

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
	
	
	public void printNodes(BinaryTreeNode root, int low, int high)
	{
		int level = 1;
		BinaryTreeNode marker = new BinaryTreeNode(-1);
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.add(root);
		q.add(marker);
		while(!q.isEmpty())
		{
			
			BinaryTreeNode temp = q.poll();
			//System.out.println("***");
			//System.out.println("After " + temp.data+" level "+level);
			if(temp == marker)
			{
		//		System.out.println(" marker found");
				level++;
				
				if(q.isEmpty() || level > high)
					break;
				
				q.add(marker);
				continue;
			}
			if(level >= low)
			{
				System.out.print(" " + temp.data+" ");
			}
			if(temp.left != null)q.add(temp.left);
			if(temp.right != null) q.add(temp.right);
		}
		
	}
	
	public BinaryTreeNode root;
	
	public static void main(String[] args) {
		
		PrintNodesBetweenLevels p = new PrintNodesBetweenLevels();
		p.root = p.new BinaryTreeNode(20);
		p.root.left = p.new BinaryTreeNode(8);
		p.root.right = p.new BinaryTreeNode(22);
		
		p.root.left.left = p.new BinaryTreeNode(4);
		p.root.left.right = p.new BinaryTreeNode(12);
		
		p.root.left.right.left = p.new BinaryTreeNode(10);
		p.root.left.right.right = p.new BinaryTreeNode(14);
		
		p.printNodes(p.root, 2, 4);
	}

}
