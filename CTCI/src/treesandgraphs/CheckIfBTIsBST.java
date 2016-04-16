package treesandgraphs;

public class CheckIfBTIsBST {

	BinaryTreeNode root;
	
	public boolean isTreeBST(BinaryTreeNode root){
		return isTreeBSTUtil(root, null, null);
	}
	
	public boolean isTreeBSTUtil(BinaryTreeNode root, Integer min, Integer max){
		
		if(root == null)
			return true;
		
		if( (min !=null && root.data < min) || (max !=null && root.data > max))
			return false;
		
		return (isTreeBSTUtil(root.left, min, root.data) && isTreeBSTUtil(root.right, root.data, max));
	}
	public void printTree(BinaryTreeNode root){
		if(root == null)
			return;
		printTree(root.left);
		System.out.print(" "+root.data+" ");
		printTree(root.right);	
	}
	public static void main(String[] args) {
		
		CheckIfBTIsBST c = new CheckIfBTIsBST();
		c.root = new BinaryTreeNode(10);
		c.root.left = new BinaryTreeNode(5);
		c.root.right = new BinaryTreeNode(15);
		c.root.left.left = new BinaryTreeNode(4);
		c.root.left.right = new BinaryTreeNode(7);
		
		c.printTree(c.root);
		
		System.out.println(" Is BST "+ c.isTreeBST(c.root));
		
	}

}
