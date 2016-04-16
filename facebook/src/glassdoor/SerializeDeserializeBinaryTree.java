package glassdoor;

import java.util.LinkedList;

public class SerializeDeserializeBinaryTree {

	private class BinaryTreeNode {
		
		int data;
		BinaryTreeNode left; 
		BinaryTreeNode right; 
		
		public BinaryTreeNode(int data)
		{
			this.data = data; 
			this.left = null;
			this.right = null;
		}
	}
	
	public BinaryTreeNode root;
	public BinaryTreeNode newroot = null;
	
	public void createTree()
	{
		this.root = new BinaryTreeNode(10);
		
		this.root.left = new BinaryTreeNode(5);
		this.root.left.left = new BinaryTreeNode(4);
		this.root.left.right = new BinaryTreeNode(6);
		
		this.root.right = new BinaryTreeNode(15);
		this.root.right.left = new BinaryTreeNode(11);
		this.root.right.right = new BinaryTreeNode(22);
		
		this.root.right.right.left = new BinaryTreeNode(20);
		this.root.right.right.right = new BinaryTreeNode(27);
	}
	
	
	public static LinkedList<Integer> list = new LinkedList<Integer>();
	
	public static int MARKER = -1;
	
	public  void serialize(BinaryTreeNode root)
	{
		if(root == null)
		{
			list.add(MARKER);
			return;
		}
		list.add(root.data);
		serialize(root.left);
		serialize(root.right);
	}
	
	public static int idx = 0;
	public  BinaryTreeNode deSerialize(BinaryTreeNode root)
	{
		int val; 
		if(idx == list.size() || list.get(idx) == -1)
		{
			return null;
		}
		root = new BinaryTreeNode(list.get(idx));
		idx += 1;
		root.left = deSerialize(root.left);
		idx += 1;
		root.right = deSerialize(root.right);
		return root;
	}
	
	public void inOrder(BinaryTreeNode root)
	{
		if(root == null)
			return;
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}
	
    
	public static void main(String[] args) {
		
		SerializeDeserializeBinaryTree sd = new SerializeDeserializeBinaryTree();
		sd.createTree();
		sd.serialize(sd.root);
		System.out.println("After seria : "+list.toString());
		
		BinaryTreeNode temp = sd.deSerialize(sd.newroot);
		sd.inOrder(temp);
		

	}

}
