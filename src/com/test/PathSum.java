package com.test;

public class PathSum {
/*The basic idea is to subtract the value of current node from sum until it reaches a leaf node and the subtraction equals 0, 
 * then we know that we got a hit. Otherwise the subtraction at the end could not be 0.
 * */
	
	public boolean hasPathSum(TreeNode root, int sum) {
	    if(root == null) return false;

	    sum -= root.val;
	    if(root.left == null && root.right==null)  return sum == 0;
	    else return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
