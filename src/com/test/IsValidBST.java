package com.test;

import java.util.Stack;

public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer max, Integer min){
        if(root==null){
            return true;
        }
        if( (max!=null && root.val>=max) || (min!=null && root.val<=min) ){
            return false;
        }
        return helper(root.left, root.val, min) && helper(root.right, max, root.val);
    }

    // Do an inorder traversal and it should yeild sorted list

    public boolean isValidBSTItr(TreeNode root) {
         TreeNode prev=null;
         Stack<TreeNode> stack = new Stack();

         while(root!=null || !stack.isEmpty()){
             while(root!=null){
                 stack.push(root);
                 root = root.left;
             }
             root = stack.pop();
             if(prev!=null && prev.val>=root.val){
                 return false;
             }
             prev = root;
             root = root.right;

         }
         return true;
    }
}
