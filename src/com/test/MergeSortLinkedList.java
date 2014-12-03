package com.test;


public class MergeSortLinkedList {

	public ListNode merge_sort(ListNode head) {
		if(head == null || head.next == null) { 
			return head; 
		}
		ListNode middle = getMiddle(head);      //get the middle of the list
		ListNode secondHalf = middle.next;			//split the list into two halfs
		middle.next = null;   
		ListNode headFirstHalf = merge_sort(head);
		ListNode headSecondHalf = merge_sort(secondHalf);
		return merge(headFirstHalf,headSecondHalf);  //recurse on that
	}

	public ListNode merge(ListNode firstHalf, ListNode secondHalf) {
		ListNode dummyHead, curr; 
		dummyHead = new ListNode(100); 
		curr = dummyHead;
		while(firstHalf !=null && secondHalf!= null) {
			if(firstHalf.val <= secondHalf.val) { 
				curr.next = firstHalf; 
				firstHalf = firstHalf.next; 
			}
			else { 
				curr.next = secondHalf; 
				secondHalf = secondHalf.next; 
			}
			curr = curr.next;
		}
		if (firstHalf == null)
			curr.next = secondHalf; 
		else
			curr.next = firstHalf;
		return dummyHead.next;
	}

	// get middle by using the slow and fast pointer approach
	public ListNode getMiddle(ListNode head) {
		if(head == null) { return head; }
		ListNode slow, fast; slow = fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next; 
			fast = fast.next.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);

		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		MergeSortLinkedList m = new MergeSortLinkedList();
		n1 = m.merge_sort(n1);

		m.printList(n1);
	}

	public void printList(ListNode x) {
		if(x != null){
			System.out.print(x.val + " ");
			while (x.next != null) {
				System.out.print(x.next.val + " ");
				x = x.next;
			}
			System.out.println();
		}

	}

	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}