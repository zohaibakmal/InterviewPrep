package com.test;

public class MergeTwoSortedLinkedLists {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if(l1 == null){
			return l2;
		}
		if(l2 == null){
			return l1;
		}

		ListNode newList = new ListNode(-1);
		ListNode newListCopy = newList;
		while (l1!=null||l2!=null){
			ListNode temp;
			if (l1!=null&&l2!=null){
				if (l1.val<l2.val){
					temp = l1;
					l1=l1.next;

				}else{
					temp = l2;
					l2 = l2.next;
				}
				newListCopy.next = temp;
				newListCopy = newListCopy.next;
			}else if(l1==null){
				newListCopy.next = l2;
				return newList.next;
			}else{
				newListCopy.next = l1;
				return newList.next;
			}
		}
		return newList.next;
	}

}
