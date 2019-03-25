package com.test;

public class RemoveNthFromEndLinkedList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;

        /*
        * We need three pointers.
        *
        * Fast: To move a pointer n steps ahead;
        * Remove: The element to remove;
        * prev: Reference to the pointer before the removed element
        *
        * We move fast pointer n steps ahead.
        *
        * Then we move fast, remove and prev at the same speed.
        * When we reach the end for fast, we remove the "remove"
        *
        * */
        ListNode fast = head;
        ListNode remove = head;
        ListNode prev = fakeHead;

        for (int i=0;i<n;i++){
            fast = fast.next;
        }

        while(fast!=null){
            fast=fast.next;
            prev = prev.next;
            remove = remove.next;
        }

        prev.next = remove.next;
        return fakeHead.next;
        
    }
}
