package tree;

import java.util.*;

public class ReverseAlternateLevels {

	private class BinaryTreeNode {
		char data;
		BinaryTreeNode left;
		BinaryTreeNode right; 
		
		BinaryTreeNode(char data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public BinaryTreeNode root = new BinaryTreeNode('a');
	public static char [] nodes = new char[256];
	public static int index = 0;
	
	public void storeNodes (BinaryTreeNode root, int level)
	{
		if(root == null)
			return;
		storeNodes(root.left, level+1);
		if(level %2 != 0)
		{
			nodes[index] = root.data;
			index++;
		}
		storeNodes(root.right, level+1);
		
	}
	
	public void reverseArray(int index)
	{
		int low = 0;
		int high = index-1;
		System.out.println("High is "+high);
		while(low < high)
		{
			char temp = nodes[low];
			nodes[low] = nodes[high];
			nodes[high] = temp;
			
			low++;
			high--;
		}
	}
	
	public void modifyArray (BinaryTreeNode root, int level)
	{
		if(root == null)
			return;
		modifyArray(root.left, level+1);
		if(level %2 != 0)
		{
			root.data = nodes[index];
			index++;
		}
		modifyArray(root.right, level+1);
	}
	public void reverseAlternate ( BinaryTreeNode root )
	{
		storeNodes(root, 0);
		System.out.println();
		System.out.println(Arrays.toString(nodes));
		//Rev array
		System.out.println();
		reverseArray(index);
		System.out.println(Arrays.toString(nodes));
		index = 0;
		
		modifyArray(root, index);
		
	}
	
	public void preOrder(BinaryTreeNode root)
	{
		if(root == null)
			return ;
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	public static void main(String[] args) {
		
		ReverseAlternateLevels a = new ReverseAlternateLevels();
		
		a.root.left = a.new BinaryTreeNode('b');
		a.root.right = a.new BinaryTreeNode('c');
		
		a.root.left.left = a.new BinaryTreeNode('d');
		a.root.left.right = a.new BinaryTreeNode('e');
		
		a.root.right.left = a.new BinaryTreeNode('f');
		a.root.right.right = a.new BinaryTreeNode('g');
		
		a.root.left.left.left = a.new BinaryTreeNode('h');
		a.root.left.left.right = a.new BinaryTreeNode('i');
		
		a.root.left.right.left = a.new BinaryTreeNode('j');
		a.root.left.right.right = a.new BinaryTreeNode('k');
		
		a.root.right.left.left = a.new BinaryTreeNode('l');
		a.root.right.left.right = a.new BinaryTreeNode('m');
		
		a.root.right.right.left = a.new BinaryTreeNode('n');
		a.root.right.right.right = a.new BinaryTreeNode('o');

		a.preOrder(a.root);
		a.reverseAlternate(a.root);
		System.out.println();
		a.preOrder(a.root);
	}

}
