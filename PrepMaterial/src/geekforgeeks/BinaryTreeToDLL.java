package geekforgeeks;

class BinaryTreeNodeTest {
	
	int data;
	BinaryTreeNodeTest left;
	BinaryTreeNodeTest right;
	
	BinaryTreeNodeTest(int data)
	{
		this.data = data;
		this.left = null;
		this.right =  null;
	}
}

class DoublyLinkedListTest {
	
	int data;
	DoublyLinkedListTest prev; 
	DoublyLinkedListTest next;
	
	DoublyLinkedListTest(int data)
	{
		this.data = data;
		prev = null;
		next = null;
	}
}

public class BinaryTreeToDLL {

	BinaryTreeNodeTest root = new BinaryTreeNodeTest(1);
	static DoublyLinkedListTest dll = new DoublyLinkedListTest(1000000); //fakse head
	DoublyLinkedListTest head = dll;

	public void createBinaryTree()
	{
		this.root.left = new BinaryTreeNodeTest(2);
		this.root.left.left = new BinaryTreeNodeTest(4);
		this.root.left.left.left = new BinaryTreeNodeTest(7);
		this.root.left.left.right = new BinaryTreeNodeTest(8);
		this.root.left.right = new BinaryTreeNodeTest(5);
		
		this.root.right = new BinaryTreeNodeTest(3);
		this.root.right.right = new BinaryTreeNodeTest(6);
		this.root.right.right.left = new BinaryTreeNodeTest(9);
		this.root.right.right.right = new BinaryTreeNodeTest(10);
	}
	
	public void convert(BinaryTreeNodeTest root)
	{
		if(root == null)
			return;
		convert(root.left);
		DoublyLinkedListTest dummy = new DoublyLinkedListTest(root.data);
		dll.next = dummy;
		dummy.prev = dll;
		dll = dll.next;
		convert(root.right);
	}
	
	public void preOrder(BinaryTreeNodeTest root)
	{
		if(root == null)
			return;
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void inOrder(BinaryTreeNodeTest root)
	{
		if(root == null)
			return;
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}
	public void extract(BinaryTreeNodeTest root, BinaryTreeNodeTest parent, boolean isLeftChild)
	{
		if(root == null)
			return ;
		if(root.left == null && root.right == null)
		{
			//System.out.print(root.data + " ");
			DoublyLinkedListTest dummy = new DoublyLinkedListTest(root.data);
			//System.out.println("Dummy data is "+dummy.data+" node is "+dll.data);
			dll.next = dummy;
			dummy.prev = dll;
			dummy.next = null;
			dll = dll.next;
			// Set the parent's left and right to null
			if(isLeftChild)
				parent.left = null;
			else
				parent.right = null;
		}
		else
		{
			extract(root.left, root, true);
			extract(root.right, root, false);
		}
		//return node;
		
	}
	
	
	public static void main(String [] args)
	{
		BinaryTreeToDLL b = new BinaryTreeToDLL();
		b.createBinaryTree();
		b.inOrder(b.root);
	//	System.out.println("leaves");
		
	//	b.extract(b.root, null, false);
		b.convert(b.root);
		DoublyLinkedListTest node = b.head.next;
		System.out.println("list");
		while(node != null)
		{
			if(node.prev != null)
		//		System.out.println("  "+" prev is "+"  "+node.prev.data+"  " );
			System.out.println(node.data+" ");
		//	System.out.println("**");
			node = node.next;
		}
		
	//	System.out.println("Printing tree");
	//	b.preOrder(b.root);
	}
}
