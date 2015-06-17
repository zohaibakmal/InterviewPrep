package com.test;

public class RemoveNthFromEndLinkedList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode current = head;
        ListNode prev = fakeHead;
        
        //align move the pointer n steps ahead.
        
        for (int i=0; i<n;i++){
            head = head.next;
        }
        
        while (head!=null){
            head=head.next;
            current = current.next;
            prev=prev.next;
        }
        
        prev.next = current.next;
        return fakeHead.next;
        
    }
}
