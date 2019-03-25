package com.test;

/**
 * Created by v652420 on 11/6/17.
 *
 * Since each node in the tree is visited only once, the time complexity is O(n), where nn is the number of nodes in the tree.
 * We cannot do better than that, since at the very least we have to visit each node to invert it.

 Because of recursion, O(h) function calls will be placed on the stack in the worst case, where h is the height of the tree.
 Because h ∈ O(n), the space complexity is O(n).
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return root;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.right = left;
        root.left = right;
        return root;
    }


}
