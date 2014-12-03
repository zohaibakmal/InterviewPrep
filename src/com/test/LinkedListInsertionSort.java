package com.test;

public class LinkedListInsertionSort {

	public ListNode insertionSortList(ListNode head) {

		 if (head == null || head.next == null)
				return head;
	 
			ListNode newHead = new ListNode(head.val);
			ListNode pointer = head.next;
	 
			// loop through each element in the list
			while (pointer != null) {
				// insert this element to the new list
	 
				ListNode innerPointer = newHead;
				ListNode next = pointer.next;
	 
				if (pointer.val <= newHead.val) {
					ListNode oldHead = newHead;
					newHead = pointer;
					newHead.next = oldHead;
				} else {
					while (innerPointer.next != null) {
	 
						if (pointer.val > innerPointer.val && pointer.val <= innerPointer.next.val) {
							ListNode oldNext = innerPointer.next;
							innerPointer.next = pointer;
							pointer.next = oldNext;
						}
	 
						innerPointer = innerPointer.next;
					}
	 
					if (innerPointer.next == null && pointer.val > innerPointer.val) {
						innerPointer.next = pointer;
						pointer.next = null;
					}
				}
	 
				// finally
				pointer = next;
			}
	 
			return newHead;
	    }
	public static void main(String[] args) {
		LinkedListInsertionSort t = new LinkedListInsertionSort();
		ListNode l1_1 = new ListNode(2);

		
		ListNode l1_2 = new ListNode(5);
		ListNode l1_3 = new ListNode(3);
		l1_1.next = l1_2;
		l1_2.next = l1_3;
		t.insertionSortList(l1_1);
	}

}
