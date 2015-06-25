package com.test;

import java.util.ArrayList;
import java.util.List;
/*
 * Modified version of LevelOrderTraversal
 * */

public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		
		List<List<Integer>> finalList= new ArrayList<List<Integer>>();
		if (root==null) return finalList;
		List <TreeNode> lastLevel = new ArrayList<TreeNode>();

		lastLevel.add(root);    

		while (!lastLevel.isEmpty()){
			List <TreeNode> newList = new ArrayList<TreeNode>();
			List <Integer> elements = new ArrayList<Integer>();
			for (TreeNode node:lastLevel){
				elements.add(node.val);
				if (node.left!=null) newList.add(node.left);
				if (node.right!=null) newList.add(node.right);
			}
			finalList.add(0,elements); //adds the list to the front of the linked List
			lastLevel=newList;
		}
		return finalList;
	}
}

