package com.test;


/*
* Given a linked list, swap every two adjacent nodes and return its head.
*
* Example:
* Given 1->2->3->4, you should return the list as 2->1->4->3.
*
* Note:
* Your algorithm should use only constant extra space.
* You may not modify the values in the list's nodes, only nodes itself may be changed.
* */
public class SwapPairs {
    /*
    * Time: O(n)
    * Space: O(1)
    * */
    public ListNode swapPairs(ListNode head) {
        ListNode fakeHead = new ListNode (-1);
        ListNode prev = fakeHead;

        while (head!=null && head.next!=null){
            ListNode n2 = head;
            ListNode n1 = head.next;
            head = head.next.next;
            n1.next = n2;
            n2.next = null;

            prev.next = n1;
            prev = prev.next.next;
        }
        if (head!=null){
            prev.next = head;
        }
        return fakeHead.next;
    }

    /*
     * Time: O(n)
     * Space: O(n)
     *
     * 2 Problems we are solving
     * 1. Swap Pair
     * 2. Figure out what the next element will be for each pair.
     * */
    public ListNode swapPairsRcr(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }

        //Reference to next pair. We need to pass this to the next recursion.
        ListNode next = head.next.next;

        //Swap pairs
        ListNode n1 = head.next;
        ListNode n2 = head;
        n1.next= n2;

        //Figure out what the next element
        n2.next = swapPairsRcr(next);

        // return the first element of the swapped pair to the previous recursive call.
        // This will be the next element for the previous call.
        return n1;
    }

    public static void main (String [] args){
        SwapPairs s = new SwapPairs();

        ListNode n1= new ListNode(2);
        ListNode n2= new ListNode(1);
        ListNode n3= new ListNode(4);
        ListNode n4= new ListNode(3);

        n1.next= n2;
        n2.next = n3;
        n3.next = n4;

        s.swapPairs(n1);
    }
}
