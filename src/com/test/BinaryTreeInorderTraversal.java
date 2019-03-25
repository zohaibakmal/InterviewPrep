package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {


    /*
    * Recursive Approach
    *
    * Time: O(n).
    * Space: The worst case space required is O(n), and in the average case it's O(log(n)) where nn is number of nodes.
    * */
    public List<Integer> inorderTraversal(TreeNode root) {
        List <Integer> finalList = new ArrayList<Integer>();
        helper (finalList, root);
        return finalList;
    }

    private void helper(List<Integer> finalList, TreeNode node){
        if (node==null){
            return;
        }
        helper(finalList, node.left);
        finalList.add(node.val);
        helper(finalList, node.right);
    }



    /*
    * Iterative Approach
    * Time: O(n).
    * Space: The worst case space required is O(n), and in the average case it's O(log(n)) where n is number of nodes.
    * */
    public List<Integer> inorderTraversalItr(TreeNode root) {
        List <Integer> finalList = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || root!=null){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                finalList.add(root.val);
                root = root.right;
            }
        }
        return finalList;
    }

}
