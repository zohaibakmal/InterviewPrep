package com.test;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeFromSortedList {

    public TreeNode sortedListToBST(ListNode head) {
        List<ListNode> list = new ArrayList<ListNode>();
        while (head!=null){
            list.add(head);
            head = head.next;
        }
        return buildTree(list, 0, list.size()-1);
    }
    private TreeNode buildTree(List <ListNode> list,int start, int end){
        if (start>end){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode node = new TreeNode (list.get(mid).val);
        node.left = buildTree(list, start, mid-1);
        node.right = buildTree(list, mid+1, end);
        return node;
    }



    public TreeNode sortedListToBST2(ListNode head) {
        if(head==null) return null;
        return toBST(head,null);
    }
    public TreeNode toBST(ListNode head, ListNode tail){
        ListNode slow = head;
        ListNode fast = head;
        if(head==tail) return null;

        while(fast!=tail&&fast.next!=tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode thead = new TreeNode(slow.val);
        thead.left = toBST(head,slow);
        thead.right = toBST(slow.next,tail);
        return thead;
    }
}
