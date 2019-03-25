package com.test;

import java.util.LinkedList;
import java.util.LinkedList;
import java.util.List;

public class SymmetricBinaryTree {
/*
 * Take the left sub tree and right sub tree. 
 * - Run Breadth first on both
 * - On Left sub tree, Breadth first runs from left to right
 * - On Right sub tree, Breadth first runs from right to left
 * */
	public boolean isSymmetricItr(TreeNode root) {

		LinkedList<TreeNode> leftFirst = new LinkedList<TreeNode>();
		LinkedList<TreeNode> rightFirst = new LinkedList<TreeNode>();

		if (root==null || (root.left==null && root.right==null)){
			return true;
		}
		leftFirst.add(root.left);
		rightFirst.add(root.right);

		while (!leftFirst.isEmpty()||!rightFirst.isEmpty()){
			TreeNode left = leftFirst.remove();
			TreeNode right = rightFirst.remove();

			if (right!=null && left!=null){
				if (right.val==left.val){
					leftFirst.add(left.left);
					leftFirst.add(left.right);
					rightFirst.add(right.right);
					rightFirst.add(right.left);
				}else{
					return false;
				}
			}else if (right!=null || left!=null){
				return false;
			}
		}
		return true;
	}
/*
 * Modified depth first search
 * */
	public boolean isSymmetric(TreeNode root) {
		if (root ==null) 
			return true;
		return isSymmetricSubTree(root.left, root.right);
	}

	public boolean isSymmetricSubTree(TreeNode left,  TreeNode right){
		if(left ==null && right ==null) return true;
		if(left==null || right ==null) return false;
		if(left.val == right.val ) {
			return isSymmetricSubTree(left.left, right.right) && isSymmetricSubTree(left.right, right.left);
		}else 
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
