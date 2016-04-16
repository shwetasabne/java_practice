package minSum;

class BinaryTreeNode {
	
	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	public BinaryTreeNode(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class MinSumBT {

	public int minSum(BinaryTreeNode root)
	{
		if(root.left == null || root.right == null)
			return root.data;
		int leftV = minSum(root.left);
		int rightV = minSum(root.right);
		
		int lSum = leftV + root.data;
		int rSum = rightV + root.data;
		
		return (lSum < rSum ? lSum : rSum);
	}
	public void preOrder(BinaryTreeNode root)
	{
		if(root == null)
			return;
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void main(String [] args)
	{
		BinaryTreeNode bt1 = new BinaryTreeNode(-1);
		
		BinaryTreeNode bt2 = new BinaryTreeNode(2);
		bt1.left = bt2;
		BinaryTreeNode bt3 = new BinaryTreeNode(3);
		bt1.right = bt3;
		
		BinaryTreeNode bt4 = new BinaryTreeNode(1);
		bt2.left = bt4;
		BinaryTreeNode bt5 = new BinaryTreeNode(-1);
		bt2.right = bt5;
		
		bt3.left = bt5;
		
		BinaryTreeNode bt6 = new BinaryTreeNode(-3);
		bt3.right = bt6;
		
		MinSumBT m = new MinSumBT();
		m.preOrder(bt1);
		
		System.out.println("Min sum");
		int b = m.minSum(bt1);
		System.out.println(b);
	}
}

