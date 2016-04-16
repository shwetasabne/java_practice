package tree;

import java.util.*;
import java.util.Map.Entry;

public class VerticalLine {

	private class BinaryTreeNode {
		
		int data;
		BinaryTreeNode left;
		BinaryTreeNode right;
		
		BinaryTreeNode(int data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
		public String toString()
		{
			return String.valueOf(this.data);
		}
	}
	

	public BinaryTreeNode root1 ;
	
	public void inOrder(BinaryTreeNode root)
	{
		if(root == null)
			return;
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}
	static Map<Integer, Integer> hd1 = new HashMap<Integer, Integer>();
	
	public void calculateHD(BinaryTreeNode root, int hd)
	{
		if(root == null)
			return;
		
		calculateHD(root.left, hd-1);
		
		int prevSum = (Integer) (hd1.containsKey(hd) ? hd1.get(hd) : 0) ; 
		hd1.put(hd, prevSum + root.data);
		calculateHD(root.right, hd+1);
		
	}
	public static void main(String[] args) {
	
		VerticalLine a = new VerticalLine();
		
		a.root1 = a.new BinaryTreeNode(1);
		
		a.root1.left = a.new BinaryTreeNode(2);
		a.root1.right = a.new BinaryTreeNode(3);
		
		a.root1.left.left = a.new BinaryTreeNode(4);
		a.root1.left.right = a.new BinaryTreeNode(5);
		a.root1.right.left = a.new BinaryTreeNode(6);
		a.root1.right.right = a.new BinaryTreeNode(7);
		
		/*a.root1.left.left.left = a.new BinaryTreeNode(8);
		a.root1.left.left.right = a.new BinaryTreeNode(9);
		
		a.root1.left.right.left = a.new BinaryTreeNode(10);
		a.root1.left.right.right = a.new BinaryTreeNode(11);
		
		a.root1.right.left.left = a.new BinaryTreeNode(12);
		a.root1.right.left.right = a.new BinaryTreeNode(13);
		
		a.root1.right.right.left = a.new BinaryTreeNode(14);
		a.root1.right.right.right = a.new BinaryTreeNode(15);*/
		
	//	a.inOrder(a.root1);
		a.calculateHD(a.root1, 0);
		System.out.println(hd1.toString());
		
	}

}
