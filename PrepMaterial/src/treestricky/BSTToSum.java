package treestricky;

public class BSTToSum {

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
	
	public static int sum = 0;
	public void createSumTree(Node root)
	{
		if(root == null)
			return ; 
		
		createSumTree(root.right);
		sum = sum + root.data;
		root.data = sum - root.data;
		createSumTree(root.left);
	}
	
	public void inOrder(Node root)
	{
		if(root == null)
			return;
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTToSum b = new BSTToSum();
		Node n = b.createTree();
		//b.inOrder(n);
		b.createSumTree(n);
		b.inOrder(n);
	}

}
