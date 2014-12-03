package com.test;

public class FlattenBinaryTreeAsLinkedList {

	public void flatten(TreeNode root) {

		if (root==null){
			return;
		}
		//Find the right most tree of left subtree.
		//Attach the right tree there.
		//Make the left tree as the right child
		while (root!=null){
			if  (root.left !=  null ) {  
				TreeNode p = root.left;  
				while  (p.right!=  null ) {  
					p = p.right;  
				}  
				p.right = root.right;  
				root.right = root.left;  
				root.left =  null ;  
			}  
			root = root.right;  
			
		}  

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}