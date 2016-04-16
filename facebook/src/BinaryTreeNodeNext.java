import java.util.LinkedList;
import java.util.Queue;


public class BinaryTreeNodeNext {

	private class Node {

		char data;
		Node left;
		Node right;
		Node next;
		
		public Node(char data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
			this.next = null;
		}
		
		public String toString()
		{
			if(this.next == null)
				return this.data + " : "+"NULL";
			else
				return this.data+ " : "+this.next.data;
		}
	}
	
	
	public Node createTree()
	{
		Node root = new Node('A') ;
		
		root.left = new Node('B');
		root.right = new Node('C');
		
		root.left.left = new Node('D');
		root.right.left = new Node('F');
		root.right.right = new Node('G');
		
		root.left.left.left = new Node('H');
		root.left.left.right = new Node('I');
		return root;
	}
	
	public void generateNextNodes(Node root)
	{
		Queue q = new LinkedList<Node>();
		Node marker = new Node('1');
		
		q.add(root);
		q.add(marker);
		
		while(!q.isEmpty())
		{
			
			Node temp = (Node) q.poll();
		//	System.out.println(temp.toString());
			if(temp == marker && q.size() > 0)
			{
				q.add(marker);
			}
			else
			{
				if(q.peek() != marker)
				{
					temp.next = (Node) q.peek();
				}
				if(temp.left != null)
					q.add(temp.left);
				if(temp.right != null)
					q.add(temp.right);
			}
		}
	}
	
	public void preOrder(Node root)
	{
		if(root == null)
			return;
		System.out.println(root.toString());
		preOrder(root.left);
		preOrder(root.right);
	}
	public static void main(String[] args) {
		
		BinaryTreeNodeNext b = new BinaryTreeNodeNext();
		Node root = b.createTree();
	//	System.out.println(root.toString());
		b.generateNextNodes(root);
		b.preOrder(root);

	}

}
