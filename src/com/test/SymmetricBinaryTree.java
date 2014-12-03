package com.test;

import java.util.Deque;
import java.util.LinkedList;

public class SymmetricBinaryTree {

	public boolean isSymmetric(TreeNode root) {

		Deque<TreeNode> lQueue = new LinkedList<TreeNode>();
		Deque<TreeNode> rQueue = new LinkedList<TreeNode>();

		if (root==null){
			return true;
		}

		if (root.left==null && root.right==null){
			return true;
		}

		lQueue.addFirst(root.left);
		rQueue.addFirst(root.right);

		while (!lQueue.isEmpty() || !rQueue.isEmpty()){

			TreeNode tempLeft = lQueue.removeFirst();
			TreeNode tempRight = rQueue.removeFirst();

			if (tempLeft !=null && tempRight!=null){
				if (tempLeft.val == tempRight.val){
					lQueue.addFirst(tempLeft.left);
					lQueue.addFirst(tempLeft.right);
					rQueue.addFirst(tempRight.right);
					rQueue.addFirst(tempRight.left);
				}
				else{
					return false;
				}
			}
			else if (tempLeft !=null || tempRight!=null) {
				return false;
			}

		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
