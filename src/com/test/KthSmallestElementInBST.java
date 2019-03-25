package com.test;

import java.util.Stack;

/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
* */
public class KthSmallestElementInBST {
//    int count = 0;

    public int kthSmallest(TreeNode root, int k) {

        Stack <TreeNode> stack = new Stack();

        while(!stack.empty() || root!=null){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }else{

                root=stack.pop();
                k--;
                if(k==0){
                    return root.val;
                }
                root = root.right;
            }
        }

        return 0;
    }

//    public void traverse(TreeNode root, int k, int result){
//
//        if(root==null){
//            return;
//        }
//        traverse(root.left,k, result);
//        count++;
//        if(k==count){
//            result = root.val;
//            return;
//        }
//
//        traverse(root.right,k, result);
//    }
    public static void main(String [] args){
        KthSmallestElementInBST k = new KthSmallestElementInBST();
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2= new TreeNode(4);
        TreeNode node3 = new TreeNode(2);
        node.left=node1;
        node.right = node2;
        node1.right = node3;
        k.kthSmallest(node, 1);
    }
}
