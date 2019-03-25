package com.test;

/**
 *
 * Time: O(N)
 * Space: O(1)
 */

public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
		// 1->2->3->4
		// 4 -> 3 -> 2 -> 1
		ListNode prev = null;
		while(head!=null){
			ListNode temp=head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		return prev;
	}
	
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		l3.next = null;
		
		ReverseLinkedList r = new ReverseLinkedList();
		r.reverseList(l1);
	}

}

