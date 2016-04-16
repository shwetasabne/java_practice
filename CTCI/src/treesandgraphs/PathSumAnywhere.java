package treesandgraphs;



public class PathSumAnywhere {

	private class Node {
		int data ;
		Node left ; 
		Node right ; 
		
		public Node(int data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
		public String toString ()
		{
			return String.valueOf(this.data);
		}
	}
	
	public int findDepth(Node root)
	{
		if(root == null)
			return 0;
		else
			return 1 + Math.max(findDepth(root.left), findDepth(root.right));
	}
	
	public void printSumPath(int [] path, int sum, int level, Node root)
	{
		if(root == null)
			return;
		
		path[level] = root.data;
		int t = 0;
		for(int i=level; i >= 0; i--)
		{
			t+=path[i];
			if(t == sum)
			{
				printPath(path, i, level);
			}
		}
		printSumPath(path, sum, level+1, root.left);
		printSumPath(path, sum, level+1, root.right);
		path[level] = Integer.MIN_VALUE;
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
		root.right.left.left = new Node(-10);
		root.right.left.left.right = new Node(15);
	
		return root;
	}
	public void printPath(int [] path, int i, int level)
	{
		for(int j=i; j <= level; j++)
		{
			System.out.print(" "+path[j]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		PathSumAnywhere p = new PathSumAnywhere();
		Node m = p.createTree();
		int d = p.findDepth(m);
		int [] path = new int [d];
		p.printSumPath(path, 5, 0, m);
	}

}
