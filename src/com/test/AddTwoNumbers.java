package com.test;

/**
 * Created by v652420 on 11/2/17.
 *
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    /*
    * Time: O(Max(m,n))
    * Space: O(Max(m,n))
    * */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode fakeHead = new ListNode (-1);
        ListNode result = fakeHead;

        while (l1!=null || l2!=null){
            int num1=0;
            int num2=0;
            if (l1!=null){
                num1 = l1.val;
                l1 = l1.next;
            }
            if (l2!=null){
                num2=l2.val;
                l2 = l2.next;
            }
            int total = num1+num2+carry;
            fakeHead.next = new ListNode (total % 10);
            fakeHead = fakeHead.next;
            if (total >=10){
                carry = 1;
            }else{
                carry = 0;
            }
        }
        if (carry==1){
            fakeHead.next = new ListNode (carry);
        }
        return result.next;
    }
}
