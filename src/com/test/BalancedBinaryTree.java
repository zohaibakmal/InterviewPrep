package com.test;

public class BalancedBinaryTree {

	public int checkHeight(Node root){
		if (root==null){
			return 0;
		}

		//Check if left is balanced
		int leftHeight = checkHeight(root.left);
		if (leftHeight==-1){
			return -1; //not balanced
		}

		//Check if right is balanced
		int rightHeight = checkHeight(root.right);
		if (rightHeight==-1){
			return -1; //not balanced
		}

		//check if current node is balanced
		int heightDiff = leftHeight - rightHeight;
		
		if(Math.abs(heightDiff)>1){
			return -1; //not balanced
		}else{
			return Math.max(leftHeight, rightHeight) +1;
		}
	}

	public boolean isBalanced(Node root){
		if (checkHeight(root)==-1){
			return false;
		}else{
			return true;
		}
	}
	
	public static void main(String[] args) {

		Node root = new Node(1);
		Node left = new Node(1);
		Node right = new Node(1);
		Node left1 = new Node(1);
		Node left2 = new Node(1);
		root.left = left;
		root.left.left=left1;
		root.left.right=left2;
		root.right = right;
		BalancedBinaryTree b = new BalancedBinaryTree();
		System.out.println(b.isBalanced(root));
		
	}

	/* 
	   --Node-- 
	   The binary tree is built using this nested node class. 
	   Each node stores one data element, and has left and right 
	   sub-tree pointer which may be null. 
	   The node is a "dumb" nested class -- we just use it for 
	   storage; it does not have any methods. 
	 */ 
	private static class Node { 
		Node left; 
		Node right; 
		int data;

		Node(int newData) { 
			left = null; 
			right = null; 
			data = newData; 
		} 
	}

}
