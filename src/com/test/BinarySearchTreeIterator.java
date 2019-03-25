package com.test;

import java.util.Stack;

public class BinarySearchTreeIterator {
    Stack<TreeNode> stack=new Stack();
    TreeNode root;

    public BinarySearchTreeIterator(TreeNode root) {
        this.root = root;
        addLeftSubTree();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        this.root = stack.pop();
        int value = this.root.val;
        this.root = this.root.right;
        addLeftSubTree();
        return value;

    }

    private void addLeftSubTree(){
        while(this.root!=null){
            stack.push(this.root);
            this.root=this.root.left;
        }
    }
}
