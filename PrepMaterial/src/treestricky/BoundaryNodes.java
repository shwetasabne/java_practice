package treestricky;

public class BoundaryNodes {

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
		System.out.print(" " + root.data);
		inOrder(root.right);
	}

	public void printLeaves(Node root)
	{
		if(root == null)
			return;
		printLeaves(root.left);
		if(root.left == null && root.right == null)
		{
			System.out.print(" " + root.data);
			
		}
		printLeaves(root.right);
	}
	
	public void printLeftBoundary(Node root)
	{
		if(root == null)
			return;
		if(root.left != null)
		{
			System.out.print(" " + root.data);
			printLeftBoundary(root.left);
		}
		else if(root.right != null)
		{
			System.out.print(" " + root.data);
			printLeftBoundary(root.right);
		}
			
	}
	
	public void printRightBoundary(Node root)
	{
		if(root == null)
			return;
		if(root.right != null)
		{
			System.out.print(" " + root.data);
			printRightBoundary(root.right);
		}
		else if(root.left != null)
		{
			System.out.print(" " + root.data);
			printRightBoundary(root.left);
		}
			
	}
	
	public void printBoundary(Node root)
	{
		if(root == null)
			return;
		System.out.print(" "+root.data);
		printLeftBoundary(root.left);
		printLeaves(root.left);
		printLeaves(root.right);
		printRightBoundary(root.right);
	}

	public static void main(String[] args) {
	
		BoundaryNodes b = new BoundaryNodes();
		Node root = b.createTree();
		b.inOrder(root);
		System.out.println();
		b.printBoundary(root);
	}

}
