package binarytree;

public class BinaryTreeNode {

	public int data;
	public  BinaryTreeNode left;
	public BinaryTreeNode right;
	
	public BinaryTreeNode(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}
	
}
