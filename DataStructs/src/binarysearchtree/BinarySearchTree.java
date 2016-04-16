package binarysearchtree;

import java.util.Stack;

import binarytree.BinaryTreeNode;

public class BinarySearchTree {
	
	public BinarySearchTreeNode root;
	
	public BinarySearchTreeNode insertNode(BinarySearchTreeNode root, int data){
		
		if(root == null){
			 root = new BinarySearchTreeNode(data);
		}
		else{
			if(data < root.data){
				root.setLeft(insertNode(root.left, data));
			}
			else if (data > root.data){
				root.setRight(insertNode(root.right,data));
			}
		}
		return root;
	}
	
	public void preOrderTraversal(BinarySearchTreeNode root){
		
		if(root == null) 
			{

			return;
			}
		preOrderTraversal(root.left);
		System.out.println(root.data);
		
		preOrderTraversal(root.right);

	}

	public  BinarySearchTreeNode findElement(BinarySearchTreeNode root, int data){
		
		if(root == null) return null;
		if( data < root.data){
			return findElement(root.getLeft(), data);
		}
		else if(data > root.data){
			return findElement(root.getRight(), data);
		}
		return root;
	}
	
	public BinarySearchTreeNode findMin(BinarySearchTreeNode root){
		
		if(root == null) return null;
		else{
			if(root.getLeft() == null){
				return root;
			}
			else{
				return (root.left);
			}
		}
	}
	
	public BinarySearchTreeNode findMax(BinarySearchTreeNode root){
		
		if(root == null) return null;
		else{
			if(root.getRight() == null){
				return root;
			}
			else{
				return (root.right);
			}
		}
	}
	
	public BinarySearchTreeNode findLCA(BinarySearchTreeNode root, BinarySearchTreeNode a, BinarySearchTreeNode b){
		
		if(root == null || a== null || b== null){
			return null;
		}
		if (Math.max(a.data, b.data) < root.data){
			return findLCA(root.left, a, b);
		}
		if(Math.min(a.data, b.data) > root.data){
			return findLCA(root.right, a, b);
		}
		else
			return root;
	}
	
	public void shortestPath1(BinarySearchTreeNode root, BinarySearchTreeNode a, Stack output){

		if(root == null){
			return;
		}
		if(root.data == a.data){
			output.push(root);
			return;
		}
		if(root.data < a.data){
			shortestPath1(root.left, a, output);
		}
		else{
			shortestPath1(root.right, a, output);
		}
		output.push(root);
		
	}
	
	public void shortestPath1(BinarySearchTreeNode root, BinarySearchTreeNode a, BinarySearchTreeNode b){

		Stack path1 = new Stack();
		Stack path2 = new Stack();
		if(root == null || a == null || b == null){
			return;
		}
		
		BinarySearchTreeNode lca = findLCA(root, a, b);
		
		if(min(a,b).data < lca.data){
			shortestPath1(lca.left, min(a,b),path1);
		}
		if(max(a,b).data > lca.data){
			shortestPath1(lca.right, max(a,b), path2);
		}
		while(!path1.isEmpty()){
			System.out.print(((BinarySearchTreeNode)path1.pop()).data + " -> ");
		}
		System.out.println("\n");
		path1.push(lca);
		while (!path2.isEmpty()) {
		        path1.push(path2.pop());
		}
		while(!path1.isEmpty()){
			System.out.print(((BinarySearchTreeNode)path1.pop()).data + " -> ");
		}

	}
	
	public static BinarySearchTreeNode min(BinarySearchTreeNode a, BinarySearchTreeNode b) {
	    return a.data < b.data ? a : b;
	}
	 
	public static BinarySearchTreeNode max(BinarySearchTreeNode a, BinarySearchTreeNode b) {
	    return a.data > b.data ? a : b;
	}
	
	
	public BinarySearchTreeNode findFloor(BinarySearchTreeNode root, int node){
		
		BinarySearchTreeNode prev = null;
		if(root == null){
			return null;
		}
		if(root.data == node){
			return root;
		}
		if(root.data < node){
			findFloor(root.left, node);
		}
		else if(root.data > node){
			findFloor(root.right, node);
		}
		prev=root;
		return prev;
	}

}
