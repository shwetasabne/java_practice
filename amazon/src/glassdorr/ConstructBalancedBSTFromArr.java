package glassdorr;

public class ConstructBalancedBSTFromArr {

	private class BinaryTreeNode
	{
		int data;
		BinaryTreeNode left; 
		BinaryTreeNode right;
		
		public  BinaryTreeNode(int data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public BinaryTreeNode convertArrToBST(int [] a, int low, int high)
	{
		if(low > high)
			return null;
		
		int mid = low + (high-low)/2;
		BinaryTreeNode root = new BinaryTreeNode(a[mid]);
		root.left = convertArrToBST(a, low, mid-1);
		root.right = convertArrToBST(a, mid+1, high);
		return root;
	}
	
	public void inOrder(BinaryTreeNode root)
	{
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(" " + root.data);
		inOrder(root.right);
	}

	public static void main(String[] args) {
		
		ConstructBalancedBSTFromArr c = new ConstructBalancedBSTFromArr();
		int [] a = {1,2,3,4,5,6};
		BinaryTreeNode root = c.convertArrToBST(a, 0, a.length-1);
		System.out.println(root.data);
		System.out.println();
		c.inOrder(root);
		

	}

}
