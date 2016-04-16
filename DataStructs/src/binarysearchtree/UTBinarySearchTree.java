package binarysearchtree;

public class UTBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree();
		bst.root = new BinarySearchTreeNode(60);
		bst.insertNode(bst.root, 41);
		bst.insertNode(bst.root, 74);
		bst.insertNode(bst.root, 65);
		bst.insertNode(bst.root, 63);
		bst.insertNode(bst.root, 70);
		bst.insertNode(bst.root, 62);
		bst.insertNode(bst.root, 64);
		bst.preOrderTraversal(bst.root);
		
		BinarySearchTreeNode lca = bst.findLCA(bst.root, new BinarySearchTreeNode(62), new BinarySearchTreeNode(70));
		System.out.println("lca is "+lca.data);
		bst.shortestPath1(bst.root, new BinarySearchTreeNode(62), new BinarySearchTreeNode(70));
		
		BinarySearchTreeNode floor = bst.findFloor(bst.root, 60);
		System.out.println("Floor is "+ floor.data);
	}

}
