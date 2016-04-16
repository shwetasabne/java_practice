package treesandgraphs;

class BinaryTreeNode {
	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	public BinaryTreeNode(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	

}

public class CheckTreeBalanced {

	public void printTree(BinaryTreeNode root){
		if(root == null)
			return;
		printTree(root.left);
		System.out.print(" "+root.data+" ");
		printTree(root.right);	
	}
	
	public int checkHeight(BinaryTreeNode root){
		
		if(root == null)
			return 0;
		
		int leftHeight = checkHeight(root.left);
		if(leftHeight == -1)
			return -1;
		
		int rightHeight = checkHeight(root.right);
		if (rightHeight == -1)
			return -1;
		
		int heightDiff = leftHeight - rightHeight;
		if(Math.abs(heightDiff) > 1){
			return -1;
		}
		else{
			return Math.max(leftHeight, rightHeight)+1;
		}
	}

	public boolean isTreeBalanced(BinaryTreeNode root){
		
		if(checkHeight(root) == -1)
			return false;
		else
			return true;
		
	}
	public static void main(String[] args) {
		
		BinaryTreeNode root = new BinaryTreeNode(5);
		root.left = new BinaryTreeNode(1);
		root.right = new BinaryTreeNode(7);
		root.left.left = new BinaryTreeNode(10);
		root.left.left.left = new BinaryTreeNode(20);
		CheckTreeBalanced c = new CheckTreeBalanced();
		c.printTree(root);
		
		System.out.println(c.isTreeBalanced(root));
		
	}

}
