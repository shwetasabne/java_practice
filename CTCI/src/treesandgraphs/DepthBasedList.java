package treesandgraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DepthBasedList {
	
	public BinaryTreeNode root;
	
	public void printTree(BinaryTreeNode root){
		if(root == null)
			return;
		System.out.print(" "+root.data+" ");
		printTree(root.left);
		
		printTree(root.right);	
	}
	
	public ArrayList<List> convertTreeToList(BinaryTreeNode root){
		
		ArrayList<List> results = new ArrayList<List>();
		
		List<BinaryTreeNode> current = new LinkedList<BinaryTreeNode>();
		current.add(root);
		
		while(current.size() > 0){
			
			results.add(current);
			List<BinaryTreeNode> parent = new LinkedList();
			parent = current;
			current = new LinkedList<BinaryTreeNode>();
			for(BinaryTreeNode n : parent){
				if(n.left !=null)
					current.add(n.left);
				if(n.right !=null)
					current.add(n.right);
			}
		}
		
		return results;
	}
	public static void main(String[] args) {
		
		DepthBasedList d = new DepthBasedList();
		d.root = new BinaryTreeNode(1);
		d.root.left = new BinaryTreeNode(5);
		d.root.right = new BinaryTreeNode(7);
		d.root.left.left = new BinaryTreeNode(8);
		d.root.left.right = new BinaryTreeNode(9);
		d.root.right.left = new BinaryTreeNode(10);
		d.root.right.right = new BinaryTreeNode(11);
		
		d.printTree(d.root);
		ArrayList output = d.convertTreeToList(d.root);
	}

}
