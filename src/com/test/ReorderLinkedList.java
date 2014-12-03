package com.test;

public class ReorderLinkedList {

	public void reorderList(ListNode head) {

		if (head==null  || head.next==null){
			return;
		}
		
		//find the middle. Reverse it.
		// Make them into two seperate lists.
		//Reoreder them

		ListNode middle = findMiddle(head);
		ListNode middleNext = middle.next;
		middle.next = null;
		ListNode reverse = reverseLinkedList(middleNext);


		while (reverse!=null){
			ListNode reverseNext;
			ListNode headNext;
			reverseNext = reverse.next;
			headNext = head.next;
			head.next = reverse;
			reverse.next = headNext;
			reverse = reverseNext;
			head = headNext;
		}
	}

	public ListNode reverseLinkedList(ListNode node){

		if (node==null||node.next==null){
			return node;
		}

		ListNode prev = null;
		ListNode current = node;
		

		while (current!=null){
			ListNode next = current.next;
			current.next = prev;
			prev=current;
			current = next;
		}

		return prev;
	}

	public ListNode findMiddle(ListNode node){

		if (node==null || node.next==null){
			return null;
		}
		
		ListNode slowPointer = node;
		ListNode fastPointer = slowPointer.next;

		while (fastPointer!=null && fastPointer.next!=null){
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}

		return slowPointer;
	}
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		
		ReorderLinkedList r = new ReorderLinkedList();
		r.reorderList(l1);

	}
	
	

}

