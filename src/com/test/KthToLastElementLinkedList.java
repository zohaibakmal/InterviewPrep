package com.test;

public class KthToLastElementLinkedList {

	// to remember values across recursive invocations
	static class IntWrapper {
	    public int value = 0;
	}
	static ListNode getKthToLast(ListNode head, int k, IntWrapper count){
		if (head==null){
			return null;
		}
		
		ListNode node = getKthToLast(head.next, k, count);
		count.value = count.value+1;
		//backtrack to find the kth to last node
		if (count.value == k){
			return head;
		}
		return node;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		
		System.out.println(getKthToLast(l1, 2, new IntWrapper()).val);
		
	}

}
