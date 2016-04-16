package treesandgraphs;

class BinarySearchTreeNode {
	
	int data;
	BinarySearchTreeNode left ;
	BinarySearchTreeNode right ;
	public BinarySearchTreeNode(int data){
		this.data = data;
	}
	
	public int getHeight(BinarySearchTreeNode root){
		
		if(root == null)
			return 0;
		
		int leftHeight = this.getHeight(root.left);
		int rightHeight = this.getHeight(root.right);
		return Math.max(leftHeight, rightHeight)+1;
	}
	
}

public class ConvertArrayToBinarySearchTree {

	BinarySearchTreeNode root ;
	
	public void printTree(BinarySearchTreeNode root){
		if(root == null)
			return;
		System.out.print(" "+root.data+" ");
		printTree(root.left);
		
		printTree(root.right);	
	}
	
	
	public BinarySearchTreeNode arrayToTree(int arr[], int start, int end){
		
		if(end < start)
			return null;
		int mid = (start+end)/2;
	//	System.out.println("mid "+mid);
		BinarySearchTreeNode n = new BinarySearchTreeNode(arr[mid]);
		n.left = arrayToTree(arr, start, mid-1);
		//System.out.println("Left "+n.left.data);
		n.right = arrayToTree(arr, mid+1, end);
	//	System.out.println(n.data);
		return n;
	}
	
	public static void main(String[] args) {
		
		ConvertArrayToBinarySearchTree c = new ConvertArrayToBinarySearchTree();
		int arr[] = {1,2,3,5,10};
		c.root = c.arrayToTree(arr, 0, arr.length-1);
		c.printTree(c.root);
	}

}
