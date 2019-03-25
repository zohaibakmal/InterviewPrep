package com.test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by v652420 on 10/26/17.
 */
public class PalindromicLinkedList {

    public boolean isPalindromeStack(ListNode head) {
        /*
        * Use a Stack
        * Time: O(n)
        * Space: O(n)
        * */
        Deque<Integer> stack = new ArrayDeque<Integer>();
        ListNode headCopy = head;
        while (headCopy!=null){
            stack.push(headCopy.val);
            headCopy = headCopy.next;
        }

        while (!stack.isEmpty()){
            int popped = stack.pop();
            if (popped != head.val){
                return false;
            }
            head = head.next;
        }
        return true;

    }
        /*
        * Find middle
        *
        * Reverse From the middle to the end.
        *
        * Compare from start and reversed.
        * Time: O(n)
        * Space: O(1)
        *
        * */

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


}
