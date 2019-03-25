package com.test;

import java.util.HashMap;

public class BinaryTreeFromPreorderInorder {

	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {

		HashMap <Integer, Integer> map = new HashMap<Integer, Integer>(); //Create a HashMap for Inorder lookup
		//Allows us to quickly find the index of an element from the list.
		for(int i=0;i<inorder.length;i++){
			map.put(inorder[i],i);
		}
//	        return buildTree(0, 0, inorder.length-1, preorder, inorder, map);
		return buildTree(preorder, 0, preorder.length-1,
				inorder, 0, inorder.length-1,
				map);
	}

	//create the tree bottom up
//	    public TreeNode buildTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder, HashMap<Integer,Integer> map){
//	        if (preStart>preorder.length-1 || inStart>inEnd){
//	            return null;
//	        }
//	        //create a node from the first element in the pre-order list.
//	        TreeNode root = new TreeNode(preorder[preStart]);
//	        //lookup the index of the root in the inorder list.
//	        int inIdx = map.get(root.val);
//	        //divide the inorder list into left and right children.
//	        root.left = buildTree(preStart+1, inStart, inIdx-1, preorder, inorder, map);
//	        root.right = buildTree(preStart+inIdx+1-inStart, inIdx+1, inEnd, preorder, inorder, map);
//	        return root;
//	    }


	/*
	 * inorder = left root right
	 * preorder = root left right
	 *
	 * inorder = [9,		3,		15,20,7]
	 * preorder = [3,	9,		20,15,7]
	 * */

	public TreeNode buildTree(int [] preorder, int preStart, int preEnd,
								  int[] inorder, int inStart, int inEnd,
							  HashMap <Integer, Integer> map){

		if (preStart > preEnd || inStart>inEnd){
			return null;
		}
		Integer inorderIndex = map.get(preorder[preStart]);
		int leftLength = inorderIndex - inStart;
		int rightLength = inEnd - inorderIndex;
		TreeNode node = new TreeNode (preorder[preStart]);
		node.left = buildTree (preorder, preStart+1, preStart+leftLength, inorder, inStart, inorderIndex-1,map);
		node.right = buildTree (preorder, preStart + leftLength + 1, preEnd, inorder, inorderIndex+1, inEnd,map);
		return node;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
