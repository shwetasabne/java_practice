package glassdoor;

import java.util.LinkedList;
import java.util.Queue;

public class SamFringeProblem {

	private class BinaryTreeNode
	{
		int data; 
		BinaryTreeNode left ;
		BinaryTreeNode right ;
		
		public BinaryTreeNode(int data)
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
	
	public BinaryTreeNode root1;
	public BinaryTreeNode root2;
	
	public void createTrees()
	{
		this.root1 = new BinaryTreeNode(10);
		this.root1.left = new BinaryTreeNode(3);
		this.root1.right = new BinaryTreeNode(5);
		this.root1.right.left = new BinaryTreeNode(7);
		this.root1.right.right = new BinaryTreeNode(8);
		
		
		this.root2 = new BinaryTreeNode(11);
		this.root2.left = new BinaryTreeNode(6);
		this.root2.left.left = new BinaryTreeNode(3);
		this.root2.right = new BinaryTreeNode(5);
		this.root2.right.left = new BinaryTreeNode(8);
		this.root2.right.right = new BinaryTreeNode(7);
		
	}
	
	public boolean isSameFringe(BinaryTreeNode root1, BinaryTreeNode root2)
	{
		Queue<BinaryTreeNode> leafNodes = new LinkedList<BinaryTreeNode>();
		
		Queue<BinaryTreeNode> levelOrderTree1 = new LinkedList<BinaryTreeNode>();
		levelOrderTree1.add(root1);
		while(!levelOrderTree1.isEmpty())
		{
			BinaryTreeNode temp = levelOrderTree1.poll();
			if(temp.left == null && temp.right == null)
			{
				leafNodes.add(temp);
			}
			if(temp.left != null)
				levelOrderTree1.add(temp.left);
			if(temp.right != null)
				levelOrderTree1.add(temp.right);
		}
		System.out.println(leafNodes.toString());
		
		levelOrderTree1 = new LinkedList<BinaryTreeNode>();
		levelOrderTree1.add(root2);
		while(!levelOrderTree1.isEmpty())
		{
			BinaryTreeNode temp = levelOrderTree1.poll();
			System.out.println("Processing "+temp.toString());
			if(temp.left == null && temp.right == null)
			{
				if(leafNodes.size() == 0)
					return false;
				BinaryTreeNode origLeaf = leafNodes.poll();
				if(origLeaf.data != temp.data)
					return false;
			}
			if(temp.left != null)
				levelOrderTree1.add(temp.left);
			if(temp.right != null)
				levelOrderTree1.add(temp.right);
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SamFringeProblem  s = new SamFringeProblem();
		s.createTrees();
		System.out.println(s.isSameFringe(s.root1, s.root2));
	}

}
