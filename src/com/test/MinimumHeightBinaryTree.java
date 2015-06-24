package com.test;

import java.util.ArrayList;

public class MinimumHeightBinaryTree {

	public int minDepth(TreeNode root) {

		if(root==null) return 0;

		if(root.left==null){
			return 1+minDepth(root.right);
		}else if(root.right==null){
			return 1+minDepth(root.left);
		}else
			return 1+Math.min(minDepth(root.left), minDepth(root.right));        
	}
	
	public int minDepth2(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth2(root.left);
        int right = minDepth2(root.right);
        if (left==0 || right==0){
            return Math.max(left,right)+1;
        }else{
            return 1+ Math.min(left,right);
        }

    }

	public int minDepthIterative(TreeNode root) {
		//Level order traversal
		if(root==null) return 0;

		ArrayList<TreeNode> last =new ArrayList<TreeNode>();
		last.add(root);
		int count=1;
		while(!last.isEmpty()){           
			ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
			for(TreeNode n:last){
				if(n.left==null && n.right==null) return count;
				if(n.left!=null) curr.add(n.left);
				if(n.right!=null) curr.add(n.right);
			}
			count++;
			last=new ArrayList<TreeNode>(curr);
		}
		return count;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
