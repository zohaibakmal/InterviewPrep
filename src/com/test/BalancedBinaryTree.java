package com.test;

public class BalancedBinaryTree {

	/*
	* Time: O(N)
	* Space: O(H)
	*
	* This improved algorithm works by checking the height of each subtree as we recurse down from the root.
	* On each node, we recursively get the heights of the left and right subtrees through the checkHeight
	* method. If the subtree is balanced, then checkHeight will return the actual height of the subtree. If the
	* subtree is not balanced, then checkHeight will return an error code. We will immediately break and
	* return an error code from the current call
	* */
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





	/*
	 * Time: O(n(log n))
	 * Since for each node, we recurse through its entire substree.
	 * Space: O(H)
	 * */
	public boolean isBalanced(TreeNode root) {
		if(root==null){
			return true;
		}
		int right = getHeight(root.right);
		int left = getHeight(root.left);

		if(Math.abs(right-left)>1){
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);

	}

	public int getHeight(TreeNode root){
		if(root==null){
			return -1;
		}

		int rightHeight = getHeight(root.right);
		int leftHeight = getHeight(root.left);

		return Math.max(getHeight(root.left), getHeight(root.right)) +1;
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
