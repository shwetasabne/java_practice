package linkedlisttricky;


public class SortedStuffToBST {

	private class BinaryTreeNode {
		
		int data;
		BinaryTreeNode left ;
		BinaryTreeNode right;
		public BinaryTreeNode(int i)
		{
			this.data = i;
			this.left = null;
			this.right = null;
		}
	}
	
	public BinaryTreeNode constructBST(int [] arr, int low, int high)
	{
		if(high < low)
			return null;
		
		int mid = low + (high-low)/2;
		BinaryTreeNode root = new BinaryTreeNode(arr[mid]);
		root.left = constructBST(arr, low, mid-1);
		root.right = constructBST(arr, mid+1, high);
		return root;
	}
	
	public void inOrder(BinaryTreeNode root)
	{
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	public void preOrder(BinaryTreeNode root)
	{
		if(root == null)
			return;
		System.out.print(root.data + " ");
		inOrder(root.left);
		
		inOrder(root.right);
	}
	public static void main(String[] args) {
		
		SortedStuffToBST s = new SortedStuffToBST();
		int [] a = {1, 2, 3, 4, 5, 6};
		BinaryTreeNode out = s.constructBST(a, 0, a.length-1);
		s.preOrder(out);
		
	}

}
