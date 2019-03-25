package com.test;

public class LowestCommonAncestorBinaryTree {
	/*
	* Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

		According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

		Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

				_______3______
			   /              \
			___5__          ___1__
		   /      \        /      \
		   6      _2       0       8
				 /  \
				 7   4
		Example 1:

		Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
		Output: 3
		Explanation: The LCA of of nodes 5 and 1 is 3.
		Example 2:

		Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
		Output: 5
		Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
					 according to the LCA definition.
		Note:

		All of the nodes' values will be unique.
		p and q are different and both values will exist in the binary tree.
	*
	* */

	/*
	* Time Complexity = O(n)
	* Space Complexity = O(h)
	* */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null || root == p || root == q){
			return root;
		}

		TreeNode right = lowestCommonAncestor(root.right, p, q);
		TreeNode left = lowestCommonAncestor(root.left, p, q);

		if(right!=null && left!=null){
			return root;
		}
		if(left!=null){
			return left;
		}else{
			return right;
		}
	}

    public static Node findLCA(Node root, int n1,int n2){
    	 
        if(root == null){
            return null;
        }
 
        int data = root.data;
        if(data > n1 && data > n2){
            return findLCA(root.left,n1, n2);
        }
 
        if(data < n1 && data < n2){
            return findLCA(root.right, n1, n2);
        }
        return root;
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
	
	boolean covers(TreeNode root, TreeNode p){
		if (root==null){
			return false;
		}
		if (root==p){
			return true;
		}
		return covers(root.left,p) || covers(root.right,p);
	}
	
	TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q){
		if (root==null){
			return null;
		}
		if (root==p || root==q){
			return root;
		}
		
		boolean p_on_left = covers(root.left ,p);
		boolean q_on_left = covers(root.left ,q);
		
		if (p_on_left !=q_on_left){
			return root;
		}
		
		TreeNode child_side = p_on_left?root.left:root.right;
		return commonAncestorHelper(child_side, p, q);
	}
	
	TreeNode commonAncestor (TreeNode root, TreeNode p, TreeNode q){
		if (!covers(root,p) || !covers(root,q)){
			return null;
		}
		return commonAncestorHelper(root,p,q);
	}
	

}
