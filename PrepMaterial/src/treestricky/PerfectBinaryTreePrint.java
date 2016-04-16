package treestricky;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectBinaryTreePrint {

	private class Node {
		int data;
		Node left ;
		Node right ;
		
		public Node(int data)
		{
			this.data = data;
		}
	}
	
	public Node createTree(){
		
		Node root = new Node(11);
		
		root.left = new Node(2);
		root.right = new Node(29);
		
		root.left.left = new Node(1);
		root.left.right = new Node(7);
		
		root.right.left = new Node(15);
		root.right.right = new Node(40);
		
		root.right.right.left = new Node(35);
		return root;
	}
	
	public void inOrder(Node root)
	{
		if(root == null)
			return;
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}
	
	public void printInOneOrder(Node root)
	{
		if(root != null)
			System.out.print(" " + root.data);
		Queue<Node> q = new LinkedList<Node>();
		if(root.left  != null)
		{
			System.out.print(" " + root.left.data);
			q.add(root.left);
		}
		if(root.right != null)
		{
			System.out.print(" " + root.right.data);
			q.add(root.right);
		}
		
		while(!q.isEmpty())
		{
			Node l = q.poll();
			Node r = null ;
			if(!q.isEmpty()){
				 r = q.poll();
			}
			
			if(l != null && l.left != null)
			{
				System.out.print(" " + l.left.data);
				q.add(l.left);
			}
			if(r != null && r.right != null)
			{
				System.out.print(" " + r.right.data);
				q.add(r.right);
			}
			if(l!= null && l.right != null)
			{
				System.out.print(" " + l.right.data);
				q.add(l.right);
			}
			if(r!= null && r.left != null)
			{
				System.out.print(" " + r.left.data);
				q.add(r.left);
			}
		}
	}
	
	public static void main(String[] args) {
		
		PerfectBinaryTreePrint p = new PerfectBinaryTreePrint();
		Node root = p.createTree();
		//p.inOrder(root);
		System.out.println("***");
		p.printInOneOrder(root);

	}

}
