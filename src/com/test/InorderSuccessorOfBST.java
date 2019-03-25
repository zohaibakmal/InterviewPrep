package com.test;

import java.util.Stack;

/*
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.

Example 1:

Input: root = [2,1,3], p = 1

  2
 / \
1   3

Output: 2
Example 2:

Input: root = [5,3,6,2,4,null,null,1], p = 6

      5
     / \
    3   6
   / \
  2   4
 /
1

Output: null

* */
public class InorderSuccessorOfBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack();
        boolean found=false;
        while (!stack.isEmpty() || root!=null){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                if(found){
                    return root;
                }else{
                    if(root == p){
                        found = true;
                    }
                }

                root = root.right;
            }
        }
        return null;
    }


    /*
    * We need to take care of three cases:
    *
    * 1. Node has a right subTree.
    *   In this case, we simply need to find the left most node in the right subtree.
    * 2. Node has no right subTree.
    *   In this case, we are need the parent. But there can be two possibilities here.
     *   a. Node is the left child of the parent. In this case, the immediate parent is the solution
     *   b. Node is the right child of the parent. In this case, we need the nearest parent for which the node is in it's left subtree.
    * */
    public TreeNode inorderSuccessorOptimized(TreeNode root, TreeNode p) {

        while (root!=null){
            if(root==p){
                return root.right;
            }else if(root.val>p.val){
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return null;
    }

}
