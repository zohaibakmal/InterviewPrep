package com.test;

public class MergeTwoSortedLinkedLists {

	/*
	*
	* The strategy here uses a temporary dummy node as the start of the result list.
	* The pointer Tail always points to the last node in the result list, so appending new nodes is easy.
	* The dummy node gives tail something to point to initially when the result list is empty.
	* This dummy node is efficient, since it is only temporary, and it is allocated in the stack.
	* The loop proceeds, removing one node from either ‘l1’ or ‘l2’, and adding it to tail.
	* When we are done, the result is in dummy.next.
	*
	* Time: O (n+m)
	* Space: O (1)
	* */


	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode fakeHead = new ListNode(-1);
		ListNode sorted = fakeHead;

		while (l1 !=null && l2 !=null){
			if (l1.val <=l2.val){
				sorted.next = l1;
				l1 = l1.next;
			}else{
				sorted.next = l2;
				l2 = l2.next;
			}
			sorted = sorted.next;
		}

		if (l1!=null){
			sorted.next = l1;
		}else{
			sorted.next = l2;
		}
		return fakeHead.next;
	}


	/*
	* You probably wouldn’t want to use the recursive version for production code however,
	* because it will use stack space which is proportional to the length of the lists.
	*
	* Time: O(n+m)
	* Space: O(n+m)
	* */

	public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
		  /* Base cases */

		if(l1 == null){
			return l2;
		}
		if(l2 == null){
			return l1;
		}

		  /* Pick either a or b, and recur */

		ListNode mergeHead;
		if(l1.val < l2.val){
			mergeHead = l1;
			mergeHead.next = mergeTwoListsRecursive(l1.next, l2);
		}
		else{
			mergeHead = l2;
			mergeHead.next = mergeTwoListsRecursive(l1, l2.next);
		}
		return mergeHead;

	}

}
