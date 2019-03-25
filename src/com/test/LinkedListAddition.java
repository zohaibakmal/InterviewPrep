package com.test;

public class LinkedListAddition {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return addLists(0, l1, l2);
	}

	private static ListNode addLists(int carryOver, ListNode l1, ListNode l2) {

		// stop conditions
		if (l1 == null && l2 == null && carryOver == 0) {
			return null;
		}
		if (l1 == null) {
			l1 = new ListNode(0);
		}
		if (l2 == null) {
			l2 = new ListNode(0);
		}

		// iteration
		int addedValue = l1.val + l2.val + carryOver;
		carryOver = 0;

		if (addedValue >= 10) {
			addedValue -= 10;
			carryOver = 1;
		}

		ListNode l3 = new ListNode(addedValue);

		// recursion
		l3.next = addLists(carryOver, l1.next, l2.next);

		return l3;
	}


	


	public static void main(String[] args){
		LinkedListAddition t = new LinkedListAddition();
		//System.out.println(t.inputString);		
		//t.reverse("123456789");
		//System.out.println(t.inputString);	



		ListNode l1_1 = new ListNode(2);

	
		ListNode l1_2 = new ListNode(5);
		ListNode l1_3 = new ListNode(3);
		l1_1.next = l1_2;
		l1_2.next = l1_3;
		ListNode l2_1 = new ListNode(5);
		ListNode l2_2 = new ListNode(6);
		ListNode l2_3 = new ListNode(4);
		l2_1.next = l2_2;
		l2_2.next = l2_3;
		//ListNode rv =	t.addTwoNumbers(l1_1, l2_1);
		System.out.println("Done");
	}
}
//class ListNode {
//	int val;
//	ListNode next;
//	ListNode(int x) {
//		val = x;
//		next = null;
//	}
//}
