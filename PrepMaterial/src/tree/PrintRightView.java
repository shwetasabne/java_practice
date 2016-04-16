package tree;

import java.util.*;



public class PrintRightView {

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
	
	public void printRightView(BinaryTreeNode root)
	{
		Queue<BinaryTreeNode> q  = new LinkedList<BinaryTreeNode>();
		BinaryTreeNode marker = this.new BinaryTreeNode(-1);
		q.add(root);
		q.add(marker);
		while(!q.isEmpty())
		{
		//	System.out.println("*****");
		//	System.out.println(q.toString());
			BinaryTreeNode temp = q.poll();
			
			if(temp == marker && q.size() > 1)
			{
				q.add(marker);
			}
			else
			{
				if(q.peek() == marker)
					System.out.println(temp.data+" ");
				if(temp.left != null) q.add(temp.left);
				if(temp.right != null) q.add(temp.right);
			}
		}
	}
	
	public BinaryTreeNode root1; 
	
	public static void main(String[] args) {
		PrintRightView a = new PrintRightView();
		a.root1 = a.new BinaryTreeNode(1);
		a.root1.left = a.new BinaryTreeNode(2);
		a.root1.right = a.new BinaryTreeNode(3);
		a.root1.left.left = a.new BinaryTreeNode(4);
		a.root1.left.right = a.new BinaryTreeNode(5);

		a.printRightView(a.root1);
	}

}
