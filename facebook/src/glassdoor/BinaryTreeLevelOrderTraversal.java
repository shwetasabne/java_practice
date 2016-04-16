package glassdoor;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

	private class BinaryTreeNode {
		
		int data;
		BinaryTreeNode left; 
		BinaryTreeNode right; 
		
		public BinaryTreeNode(int data)
		{
			this.data = data; 
			this.left = null;
			this.right = null;
		}
	}
	
	public BinaryTreeNode root;
	
	public void createTree()
	{
		this.root = new BinaryTreeNode(10);
		
		this.root.left = new BinaryTreeNode(5);
		this.root.left.left = new BinaryTreeNode(4);
		this.root.left.right = new BinaryTreeNode(6);
		
		this.root.right = new BinaryTreeNode(15);
		this.root.right.left = new BinaryTreeNode(11);
		this.root.right.right = new BinaryTreeNode(22);
		
		this.root.right.right.left = new BinaryTreeNode(20);
		this.root.right.right.right = new BinaryTreeNode(27);
	}
	
	public void levelOrderTraversal(BinaryTreeNode root)
	{
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.add(root);
		while(!q.isEmpty())
		{
			BinaryTreeNode temp = q.poll();
			System.out.println(temp.data);
			
			if(temp.left != null)
				q.add(temp.left);
			if(temp.right != null)
				q.add(temp.right);
		}
	}
	
	public static void main(String[] args) {
		
		BinaryTreeLevelOrderTraversal b = new BinaryTreeLevelOrderTraversal();
		b.createTree();
		b.levelOrderTraversal(b.root);
	}

}
