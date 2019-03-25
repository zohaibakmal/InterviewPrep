package com.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MaximumDepthOfBinaryTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	/*
	* Time complexity = O(n)
	* */

	public int maxDepth(TreeNode root) {
        if (root==null)
        	return 0;
        else
        	return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
	
	public int maxDepthItrative2(TreeNode root){
		int depth=0;
		if(root==null){
			return depth;
		}
		LinkedList <TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode lastLevel = queue.getLast();
		while (!queue.isEmpty()){
			TreeNode current = queue.pop();
			if (current.left!=null) queue.add(current.left);
			if (current.right!=null) queue.add(current.right);
			if (current==lastLevel){
				lastLevel = queue.peekLast();
				depth++;
			}
		}
		return depth;
	}
	
	
	public int maxDepthIterative(TreeNode root){

		int depth = 0;
		if(root==null) 
			return depth;
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		//node added to the start of the queue
		list.offer(root); 
		
		//records the last node in the level
		TreeNode levelLast = root;
		while(list.size()>0){
			//pop nodes from the front. Add children nodes to the queue
			TreeNode curr = list.poll();
			if(curr.left!=null) list.offer(curr.left);
			if(curr.right!=null) list.offer(curr.right);
			//check to if we have popped all nodes from a particular level.
			if(curr==levelLast) {
				levelLast = list.peekLast();
				depth++;
			}
		}
		return depth;
	}

}
