package treestricky;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class DiagonalSum {

	private class Node {
		int data;
		Node left ;
		Node right ;
		int vd ;
		public Node(int data)
		{
			this.data = data;
			this.vd = 0;
		}
	}

	public Node createTree(){
		
		Node root = new Node(11);
		
		root.left = new Node(2);
		root.right = new Node(29);
		
		root.left.left = new Node(1);
		root.left.right = new Node(7);
		
		root.right.left = new Node(15);
		root.right.right = new Node(40);
		
		root.right.right.left = new Node(35);
		return root;
	}

	public void inOrder(Node root)
	{
		if(root == null)
			return;
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}
	
	public void diagonalSum(Node root)
	{
		Queue<Node> q = new LinkedList<Node>();
		
		TreeMap<Integer, Integer> sumTree = new TreeMap<Integer, Integer>();
		q.add(root);
		
		while(!q.isEmpty())
		{
			Node temp = q.poll();
			int v = temp.vd;
			System.out.println();
			while(temp != null)
			{
				System.out.print(" " +temp.data);
				if(sumTree.containsKey(v))
				{
					int sum = sumTree.get(v) + temp.data;
					sumTree.put(v, sum);
				}	
				else
				{
					sumTree.put(v, temp.data);
				}
				
				if(temp.left != null)
				{
					temp.left.vd = v + 1;
					q.add(temp.left);
				}
				temp  = temp.right;
			}

		}
		System.out.println();
		Set<Entry<Integer, Integer>> set = sumTree.entrySet();
		 
        // Make an iterator
        Iterator<Entry<Integer, Integer>> iterator = set.iterator();
 
        // Traverse the map elements using the iterator.
        while (iterator.hasNext())
        {
            Map.Entry<Integer, Integer> me = iterator.next();
            System.out.print(me.getValue()+" ");
        }
	}
	
	public static void main(String[] args) {
		
		DiagonalSum  d = new DiagonalSum();
		Node root = d.createTree();
		d.diagonalSum(root);
	}

}
