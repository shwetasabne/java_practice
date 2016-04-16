package tree;

public class InOrder {

	private class BST
	{
		int data;
		BST left;
		BST right;
		
		public BST(int data)
		{
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	public BST root = new BST(10);
	
	public void createBST()
	{
		this.root.left = new BST(5);
		this.root.left.left = new BST(4);
		this.root.left.right = new BST(6);
		
		this.root.right = new BST(15);
		this.root.right.left = new BST(11);
		this.root.right.right = new BST(22);
		this.root.right.right.left = new BST(20);
		this.root.right.right.right = new BST(27);
	}
	
	public void inOrder(BST root)
	{
		if (root == null)
			return;
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
		
	}
	public static void main(String[] args) {
		
		InOrder i = new InOrder();
		i.createBST();
		i.inOrder(i.root);
	}

}
