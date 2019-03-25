package com.test;

import java.util.LinkedList;

/*

Given a binary tree

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
Recursive approach is fine, implicit stack space does not count as extra space for this problem.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
Example:

Given the following perfect binary tree,

     1
   /  \
  2    3
 / \  / \
4  5  6  7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL

* */

public class PopulateNextRightPointer {

    /*
    * If we observe, we are creating a linked list at each level.
    *
    * The idea is, at parent level, we create a linked list at child level.
    * And then we traverse each level as we would traverse a linked list, creating a linked list at the child level.
    * */

    public void connectItr(TreeLinkNode root) {
        TreeLinkNode level_start=root;
        while(level_start!=null){
            TreeLinkNode cur=level_start;
            while(cur!=null){
                if(cur.left!=null) cur.left.next=cur.right;
                if(cur.right!=null && cur.next!=null) cur.right.next=cur.next.left;

                cur=cur.next;
            }
            level_start=level_start.left;
        }
    }




    /*
    * Recursive Solution
    * */
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;

        if(root.left != null){
            root.left.next = root.right;
            if(root.next != null)
                root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);
    }

}

class TreeLinkNode {
    TreeLinkNode right;
    TreeLinkNode left;
    TreeLinkNode next;
    int val;
    public TreeLinkNode(int val){
        this.val = val;
    }
}
