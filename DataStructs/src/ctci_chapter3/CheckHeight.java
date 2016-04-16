package ctci_chapter3;

class BinaryTreeNode {
	
	private int data;
	private BinaryTreeNode left; 
	private BinaryTreeNode right;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
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

public class CheckHeight {

	public int checkHeight(BinaryTreeNode root){
		
		if(root == null){
			return 0;
		}
		
		int leftHeight = checkHeight(root.getLeft());
		if(leftHeight == -1){
			return -1;
		}
		int rightHeight = checkHeight(root.getRight());
		if(rightHeight == -1){
			return -1;
		}
		
		/*Now check if the tree is balanced */
		int heightDiff = leftHeight - rightHeight ;
		if(Math.abs(heightDiff) > 1){
			return -1;
		}
		else{
			return Math.max(leftHeight, rightHeight)+1;
		}
	}
	
	public static void main(String[] args) {
		
	}

}
