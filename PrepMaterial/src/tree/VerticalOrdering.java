package tree;

import java.util.*;


public class VerticalOrdering {

	private class BinaryTreeNode {
		int data;
		BinaryTreeNode left ;
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
	
	private class QueueItem {
		BinaryTreeNode node;
		int dist;
		QueueItem(BinaryTreeNode root, int hd)
		{
			this.node = root;
			this.dist = hd;
		}
	}
	
	public void printVerticalOrder(BinaryTreeNode root)
	{
		System.out.println("here");
		HashMap<Integer, BinaryTreeNode> m = new HashMap<Integer, BinaryTreeNode>();
		Queue<QueueItem> q = new LinkedList<QueueItem>();
		
		QueueItem base = new QueueItem(root, 0);
	//	m.put(0, root);
		q.add(base);
		while(!q.isEmpty())
		{
			
			QueueItem i = q.poll();
			//System.out.println("Processing "+i.node.data+" "+i.dist);
			if(!m.containsKey(i.dist))
			{
				System.out.println(" "+i.node.data+" ");
				m.put(i.dist, i.node);
			}
			if(i.node.left!=null)q.add(new QueueItem(i.node.left, i.dist-1));
			if(i.node.right != null) q.add(new QueueItem(i.node.right, i.dist+1));
		}
	}
	
	public BinaryTreeNode root = new BinaryTreeNode(1);
	public static void main(String[] args) {
	
		VerticalOrdering a = new VerticalOrdering();
		
		a.root.left = a.new BinaryTreeNode(2);
		a.root.right = a.new BinaryTreeNode(3);
		
		a.root.left.right = a.new BinaryTreeNode(4);
		a.root.left.right.right = a.new BinaryTreeNode(5);
		a.root.left.right.right.right = a.new BinaryTreeNode(6);
		
		a.printVerticalOrder(a.root);
		
	}

}
