package binarysearchtree;

public class BinarySearchTreeNode {
	
	public int data;
	public BinarySearchTreeNode left;
	public BinarySearchTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinarySearchTreeNode left) {
		this.left = left;
	}

	public BinarySearchTreeNode getRight() {
		return right;
	}

	public void setRight(BinarySearchTreeNode right) {
		this.right = right;
	}

	public BinarySearchTreeNode right;
	
	public BinarySearchTreeNode(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
