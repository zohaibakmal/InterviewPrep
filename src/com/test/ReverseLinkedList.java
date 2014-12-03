package com.test;

public class ReverseLinkedList {

	public ListNode reverseLinkedList(ListNode node){
		
		if (node==null || node.next ==null){
			return node;
		}
		
		
		ListNode previousNode = null;
		ListNode nextNode;
		
		while (node !=null){
			nextNode = node.next;
			node.next = previousNode;
			previousNode = node;
			node = nextNode;
		}
		
		return previousNode;
	}
	
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		l3.next = null;
		
		ReverseLinkedList r = new ReverseLinkedList();
		r.reverseLinkedList(l1);
	}

}

