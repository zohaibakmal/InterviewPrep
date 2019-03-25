package com.test;



public class CheckBST {


	public boolean isValidBSTRcr(TreeNode root) {
		return checkBST (root, null,null);
	}

	public boolean checkBST (TreeNode root, Integer minValue, Integer maxValue){
		if(root==null){
			return true;
		}
		if((minValue!=null && root.val<=minValue) || (maxValue!=null && root.val>= maxValue)){
			return false;
		}
		//Check whether left tree is a BST. Left node should be greater than the global min and less than the root
		//Check whether right tree is a BST. Right node should be less than the global max and greater than the root
		return checkBST(root.left, minValue, root.val) && checkBST(root.right, root.val, maxValue);
	}


	/*
	* Space = O(H)
	* Time = O(n)
	* We make use of the fact that inorder traversal gives us sorted list.
	* We don't need to maintain the list. All we need to do is compare the last
	* item visited to see if it is less then the current.
	* */

	Integer lastValue = null;
	public boolean isValidBST(TreeNode root) {
		if(root==null){
			return true;
		}
		boolean rv = true;
		if(!isValidBST(root.left)){
			return false;
		}
		if(lastValue!=null && lastValue>=root.val){
			return false;
		}
		lastValue = root.val;
		if(!isValidBST(root.right)){
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
