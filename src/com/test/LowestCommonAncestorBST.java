package com.test;

public class LowestCommonAncestorBST {

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
