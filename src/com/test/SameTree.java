package com.test;

import java.util.LinkedList;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null) return true;
        if (p==null || q==null) return false; 
        if (p.val==q.val) return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else return false;
    }
    
    public boolean isSameTreeItr (TreeNode p, TreeNode q){
    	if (p==null && q==null) return true;
        if (p==null || q==null) return false;
        
        LinkedList <TreeNode> pQueue = new LinkedList<TreeNode>();
        LinkedList <TreeNode> qQueue = new LinkedList<TreeNode>();
        
        pQueue.add(p);
        qQueue.add(q);
        
        while (!pQueue.isEmpty() || !qQueue.isEmpty()) {
        	p = pQueue.remove();
        	q = qQueue.remove();
        	
        	if (p!=null && q!=null){
        		if (p.val==q.val){
	        		pQueue.add(p.left);
	        		pQueue.add(p.right);
	        		qQueue.add(q.left);
	        		qQueue.add(q.right);
        		}
        		else{
        			return false;
        		}
        	}else if(p!=null || q!=null){
        		return false;
        	}
        }
        
        return true;
    }
}
