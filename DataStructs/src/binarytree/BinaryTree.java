package binarytree;

import java.util.Stack;

import binarysearchtree.BinarySearchTreeNode;

import queue.ListQueue;

import stack.ListStack;



public class BinaryTree {
	
	public BinaryTreeNode root;
	
	public void createBinaryTree(){

		BinaryTreeNode root = new BinaryTreeNode(1);
		BinaryTreeNode n1 = new BinaryTreeNode(2);
		BinaryTreeNode n2 = new BinaryTreeNode(3);
		BinaryTreeNode n3 = new BinaryTreeNode(4);
		BinaryTreeNode n4 = new BinaryTreeNode(5);
		BinaryTreeNode n5 = new BinaryTreeNode(6);
		BinaryTreeNode n6 = new BinaryTreeNode(7);

        root.left = n1;
        root.right = n2;
        root.left.left = n3;
        root.left.right = n4;
        root.right.left = n5;
        root.right.right = n6;
        this.root = root;
	}

	public void preOrderTraversal(BinaryTreeNode root){
		
			if(root == null) return;
			System.out.println(root.data);
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);

	}
	
	public int findmax (BinaryTreeNode n1){
		
		int max = 0 ;
		int root_val = 0;
		int left_val = 0;
		int right_val = 0;

		BinaryTreeNode root = n1;
		if(root == null){
			return 0;
		}
		root_val = root.data;
		left_val = findmax(root.left);
		right_val = findmax(root.right);
		if(left_val > right_val){
			max = left_val;
		}
		else{
			max = right_val;
		}
		if(max < root_val){
			max = root_val;
		}
		return max;
	}
	
	public boolean searchElement(BinaryTreeNode bn, int search){
		
		BinaryTreeNode root = bn;
		if(root == null){
			return false;
		}
		if(root.data == search){
			return true;
		}
		else{
			boolean temp = searchElement(root.left, search);
			if(temp == false){
				return searchElement(root.right, search);
			}
			else return temp;
		}
	}
	
	public boolean isTreeBalanced (BinaryTreeNode bn){
		BinaryTreeNode root = bn;
		if(root.left != null && root.right != null ){
			return true;
		}
		if(root.left == null && root.right == null){
			return true;
		}
		else
			return false;
	}
	
	public void insertNode(int data){
		
		BinaryTreeNode newNode = new BinaryTreeNode(data);
		BinaryTreeNode temp ;
		newNode.left = null;
		newNode.right = null;
		
		if(this.root == null){
			this.root = newNode;
			return;
		}

			ListQueue q = new ListQueue();
			q.enQueue(root);
			while(!q.isQueueEmpty()){
				temp = (BinaryTreeNode) q.deQueue();
				if(temp.left != null){
					q.enQueue(temp.left);
				}
				else{
					temp.left = newNode;
					return;
				}
				if(temp.right != null){
					q.enQueue(temp.right);
				}
				else{
					temp.right = newNode;
					return;
				}
			}
		
	}
	
	public int sizeOfTree(BinaryTreeNode bn){
		
		BinaryTreeNode root = bn;
		if(bn == null){
			return 0;
		}
		return (sizeOfTree(bn.left) + 1 + sizeOfTree(bn.right));
	}
	
	public int heightOfTree(BinaryTreeNode bn){
	
		int left = 0;
		int right = 0;
		
		BinaryTreeNode root = bn;
		if(bn == null){
			return 0;
		}
		else {
			left = heightOfTree(bn.left);
			right = heightOfTree(bn.right);
			if(left > right){
				return left + 1;
			}
			else{
				return right + 1;
			}
		}
	}
	
	public void deleteTree(BinaryTreeNode bn){
		
		BinaryTreeNode root = bn;
		if(root == null) {
			return;
		}
		deleteTree(bn.left);
		deleteTree(bn.right);
		root = null;
		
	}
	
	public void printLeafFirst(BinaryTreeNode bn){

		
		BinaryTreeNode root = bn;
		BinaryTreeNode temp;
		ListQueue q = new ListQueue();
		Stack s = new Stack();
		if(root == null) return ;
		q.enQueue(bn);
		
		while(!q.isQueueEmpty()){
			temp = (BinaryTreeNode) q.deQueue();
			if(temp.left != null){
				q.enQueue(temp.left);
			}
			if(temp.right != null){
				q.enQueue(temp.right);
			}
			s.push(temp);
		}
		while(!s.isEmpty()){
			BinaryTreeNode t = (BinaryTreeNode) s.pop();
			System.out.println(t.data);
		}
	}

	public int findDeepestNode(BinaryTreeNode bn){
		
		BinaryTreeNode root = bn;
		BinaryTreeNode temp = null ;
		if(root == null) return 0;
		ListQueue q = new ListQueue();
		q.enQueue(root);
		while(!q.isQueueEmpty()){
			temp = (BinaryTreeNode) q.deQueue();
			if(temp.left != null){
				q.enQueue(temp.left);
			}
			if(temp.right != null){
				q.enQueue(temp.right);
			}
		}
		return temp.data;
		
	}
	
	public int numLeaves(BinaryTreeNode bn){
		
		BinaryTreeNode root = bn;
		int numLeaves = 0;
		if(root == null) return 0;
		else{
			ListQueue q = new ListQueue();
			Stack s = new Stack();
			q.enQueue(root);
			while(!q.isQueueEmpty()){
				BinaryTreeNode temp = (BinaryTreeNode) q.deQueue();
				if(temp.left != null){
					q.enQueue(temp.left);
				}
				if(temp.right != null){
					q.enQueue(temp.right);
				}
				if(temp.left == null && temp.right == null ){
					s.push(temp);
				}
			}
			
			while(!s.isEmpty()){
				s.pop();
				numLeaves++;
			}
		}
		return numLeaves;
	}
	
	public void printFullNodes(BinaryTreeNode bn){
		
		BinaryTreeNode root = bn;
		if(root == null){
			return;
		}
		if(root.left !=null && root.right !=null){
			System.out.println("Full Node is " + root.data);
		}
		printFullNodes(root.left);
		printFullNodes(root.right);
	}
	
	public void printHalfNodes(BinaryTreeNode bn){
		
		BinaryTreeNode root = bn;
		if(root == null){
			return;
		}
		if( (root.left ==null && root.right !=null) || (root.left !=null && root.right == null)){
			System.out.println("Half Node is " + root.data);
		}
		printHalfNodes(root.left);
		printHalfNodes(root.right);
	}
	
	public boolean areStructurullySimilar(BinaryTreeNode root1, BinaryTreeNode root2){

		
		if(root1 == null && root2 == null){
			return true;
		}
		if(root1 == null || root2 == null){
			return false;
		}
		return (root1.data == root2.data &&
				areStructurullySimilar(root1.left, root2.left) && 
				areStructurullySimilar(root2.right, root2.right));
	}
	
	public int findLevelWithMaxSum(BinaryTreeNode bn){
		
		BinaryTreeNode temp ;
		int currSum = 0, maxSum = 0;
		int level = 0;
		int maxLevel = 0;
		ListQueue q = new ListQueue();
		if(bn == null){
			return 0;
		}
		q.enQueue(bn);
		q.enQueue(null);
		while(!q.isQueueEmpty()){
			temp = (BinaryTreeNode) q.deQueue();
			if(temp == null){
				if(currSum > maxSum){
					maxSum = currSum;
					maxLevel = level;
				}
				if(!q.isQueueEmpty()){
					q.enQueue(null);
				}
				level++;
			}
			else{
				currSum += temp.data;
				if(temp.left != null)
					q.enQueue(temp.left);
				if(temp.right != null)
					q.enQueue(temp.right);
				
			}
		}
		return maxLevel;
	}
	
	public boolean hasSum(int sum){
		return hasSum(root, sum);
	}
	
	private boolean hasSum(BinaryTreeNode root, int sum){
		
		if(root == null){
			return (sum == 0);
		}
		else{
			int subSum = sum - root.data ;
			return (hasSum(root.left, subSum) || hasSum(root.right, subSum));
		}
	}
	
	public int sumAllNodes(BinaryTreeNode root){
		if(root == null){
			return 0;
		}
		else{
			return (root.data + sumAllNodes(root.left) + sumAllNodes(root.right));
		}
	}
	
	public int printAllAncestors(BinaryTreeNode root, int node){
		
		if(root == null){
			return 0;
		}
		if( (root.left.data == node)
				|| 
			(root.right.data == node) || 
			(printAllAncestors(root.left, node) == 1) || 
			(printAllAncestors(root.right,node) ==1) ){
			System.out.println("Ancestors are " + root.data);
			return 1;
		}
		return 0;
	}
	
	public BinarySearchTreeNode findFloor(BinarySearchTreeNode root, int node){
		
		BinarySearchTreeNode prev = null;
		if(root == null){
			return null;
		}
		if(root.data == node){
			return root;
		}
		else if(root.data < node){
			findFloor(root.left, node);
			prev=root;
			
		}
		return prev;
	}
}

	