package com.test;



public class CheckBST {

	//maintain a min and max at each node.
	public boolean checkBST(Node n){
		return checkBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public boolean checkBST(Node n, int min, int max){
		//base case
		if (n==null){ 
			return true;
		}
		
		if (n.data<=min || n.data>max){
			return false;
		}
		
		//Check whether left tree is a BST. Left node should be greater than the global min and less than the root
		//Check whether right tree is a BST. Right node should be less than the global max and greater than the root
		if (!checkBST(n.left , min, n.data) || !checkBST(n.right, n.data, max)){
			return false;
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
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
