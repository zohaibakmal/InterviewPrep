package com.test;

/*
* Given inorder and postorder traversal of a tree, construct the binary tree.
*
* Note:
*
* You may assume that duplicates do not exist in the tree.
*
* For example, given
*
* inorder = [9,     3,  15,20,7]
* postorder = [9,   15,7,20,    3]
* */

import java.util.HashMap;

public class BinaryTreeFromInorderPostorder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length-1,
                postorder, 0, postorder.length-1, map);
    }

    public TreeNode buildTree(int [] inorder, int inStart, int inEnd,
                              int [] postorder, int postStart, int postEnd,
                              HashMap<Integer, Integer> map){
        if (inStart>inEnd || postStart > postEnd){
            return null;
        }
        TreeNode node = new TreeNode(postorder[postEnd]);
        int inorderIndex = map.get(node.val);
        int leftLength = inorderIndex - inStart;
        int rightLength = inEnd - inorderIndex;
        node.left = buildTree(inorder, inStart, inorderIndex-1,
                postorder, postStart, postStart+leftLength-1, map);
        node.right = buildTree(inorder, inorderIndex+1, inEnd,
                postorder, postEnd-rightLength,postEnd-1, map);
        return node;
    }
}
