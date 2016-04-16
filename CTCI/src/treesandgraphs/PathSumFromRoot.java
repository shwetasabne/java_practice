package treesandgraphs;

import java.util.ArrayList;

public class PathSumFromRoot {

	private class Node {
		int data; 
		Node left;
		Node right;
		
		public Node(int data)
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
	
	public Node createTree()
	{
		Node root = new Node(2);
		
		root.left = new Node(3);
		root.left.left = new Node(-4);
		root.left.left.right = new Node(-2);
		root.left.left.right.left = new Node(6);
		
		root.right = new Node(1);
		root.right.left = new Node(2);
	
		return root;
	}
	
	public void printSumPath(Node root, ArrayList<Node> list, int sum)
	{
		if(sum == 5)
		{
			ArrayList<Node> t = new ArrayList<Node>(list);
			System.out.println(t.toString());
		}
		if(root == null)
		{
			return ;
		}

	//	System.out.println(" Node is "+root.data +" sum is "+sum);
		list.add(root);		
		printSumPath(root.left, list , sum + root.data);	
		printSumPath(root.right, list, sum + root.data);
		list.remove(list.size()-1);
		
	}

	public void preOrder(Node root)
	{
		if(root == null)
			return;
		System.out.print(" " + root.data);
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void main(String[] args) {
		
		PathSumFromRoot p = new PathSumFromRoot();
		Node m = p.createTree();
		p.preOrder(m);
		ArrayList<Node> list = new ArrayList<Node>();
		System.out.println();
		p.printSumPath(m, list, 0);

	}

}
