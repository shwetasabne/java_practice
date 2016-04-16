package binarytree;

public class UTBinaryTree {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		
		bt.createBinaryTree();
		bt.preOrderTraversal(bt.root);

		System.out.println("Max value is " + bt.findmax(bt.root));
		
		if(bt.searchElement(bt.root, 5)){
			System.out.println("Found element 5");
		}
		if(bt.searchElement(bt.root, 3)){
			System.out.println("Found element 3");
		}
		if(bt.searchElement(bt.root, 7)){
			System.out.println("Found element 7");
		}
		if(!bt.searchElement(bt.root, 15)){
			System.out.println("Not Found element 15");
		}
		
		
		// Inserting node
		System.out.println();
		BinaryTree bint = new BinaryTree();
		bint.insertNode(1);
		bint.insertNode(2);
		bint.insertNode(3);
		bint.insertNode(4);
		bint.insertNode(5);
		bint.preOrderTraversal(bint.root);
		
		System.out.println("Size of tree " + bint.sizeOfTree(bint.root));
		
		System.out.println("Height of tree " + bint.heightOfTree(bint.root));
		
		System.out.println("Deepest node of tree " + bint.findDeepestNode(bint.root));
		
		bint.printFullNodes(bint.root);
		
		bint.printHalfNodes(bint.root);
		
		bint.printAllAncestors(bint.root, 5);
	}

}
