
public class InOrderSuccessorofNode {

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
	
	public BST getMin (BST node)
	{
		if(node.left == null)
			return node;
		else 
			return getMin(node.left);	
	}


	public BST getSucc(BST node)
	{
		if(node.right != null)
			return getMin(node.right);
		else
		{
			BST curr = this.root;
			BST succ = null;
			while(node.data != curr.data)
			{
				if(node.data < curr.data)
				{
					succ = curr;
					curr = curr.left;
				}
				else
				{
					curr = curr.right;
				}
			}
			return succ;
		}
	}
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
	
	public void preOrder(BST root)
	{
		if(root == null)
			return;
		System.out.print(" "+root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
	public static void main(String[] args) {
		
		InOrderSuccessorofNode i = new InOrderSuccessorofNode();
		i.createBST();
		i.preOrder(i.root);
		//System.out.println(i.getMin(i.root.right).data);
		System.out.println(i.getSucc(i.root.left.right).data);
	}

}
