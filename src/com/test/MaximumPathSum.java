package com.test;

public class MaximumPathSum {

    int globalMax;
    public int maxPathSum(TreeNode root) {
        globalMax = Integer.MIN_VALUE;
        helper(root);
        return globalMax;
    }

    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftMax = Math.max(helper(root.left) ,0);
        int rightMax = Math.max(helper(root.right),0);
        int localMax = leftMax + rightMax + root.val;
        globalMax = Math.max(globalMax, localMax);
        return Math.max(leftMax,rightMax) + root.val;
    }

}
