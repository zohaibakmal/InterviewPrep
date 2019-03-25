package com.test;

public class LowestCommonAncestorBST {

    /*
    * Find the node where the path diverges.
    * Return the node.
    * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val>p.val && root.val>q.val){
            return lowestCommonAncestor(root.left, p, q) ;
        }else if(root.val<p.val && root.val<q.val){
            return lowestCommonAncestor(root.right, p, q) ;
        }
        return root;
    }
}
