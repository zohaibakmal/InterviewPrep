package com.test;

/**
 * Created by v652420 on 10/23/17.
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.

 Time: O(n)
 Space: O(1)
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode refHead=head;
        ListNode prev = null;

        while (head!=null){

            if (prev!=null && head.val==prev.val){
                prev.next = head.next;
            }else{
                prev = head;
            }
            head = head.next;

        }
        return refHead;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
