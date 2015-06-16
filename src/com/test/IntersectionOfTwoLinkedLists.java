package com.test;

/*
 * Find lengths of both linked lists
 * Align the two linked lists
 * Compare them for intersection
 * 
 * */

public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getListLength(headA);
        int lenB = getListLength(headB);
        ListNode intersection = null;
        while (lenA!=lenB){
            if (lenA>lenB){
                headA = headA.next;
                lenA--;
            }else{
                headB = headB.next;
                lenB--;
            }
        }
        
        while (headA!=null){
            if (headA==headB){
                return headA;
            }else{
                headA=headA.next;
                headB=headB.next;
            }
        }
        
        return intersection;
    }
    
    public int getListLength(ListNode list){
        int count=0;
        while (list!=null){
            count++;
            list = list.next;
        }
        return count;
    }
}
