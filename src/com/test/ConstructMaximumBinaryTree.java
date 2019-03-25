package com.test;

public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructHelper (nums,0,nums.length-1);
    }

    private TreeNode constructHelper (int [] nums, int left, int right){
        if(right<left || left>right ){
            return null;
        }
        int rootIndex = indexOfMaximum (nums,left,right);
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = constructHelper (nums,left,rootIndex-1);
        root.right = constructHelper (nums,rootIndex+1,right);
        return root;
    }

    private int indexOfMaximum (int [] nums, int left, int right){
        int max = nums[left];
        int maxIndex = left;
        while(left<right){
            if(nums[left]>=max){
                max = nums[left];
                maxIndex = left;
            }
            left++;
        }
        return maxIndex;
    }

    public static void main(String [] args){
        ConstructMaximumBinaryTree binaryTree = new ConstructMaximumBinaryTree();
        binaryTree.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
    }

}
