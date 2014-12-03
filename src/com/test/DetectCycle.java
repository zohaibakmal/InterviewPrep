package com.test;

public class DetectCycle {

	public ListNode detectCycle(ListNode head) {
        if (head==null){
            return head;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        boolean hasCycle = false;
        
        while(slowPointer!=null && fastPointer!=null &&fastPointer.next!=null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer){
                hasCycle = true;
                break;
            }
        }
        
        if (hasCycle){
            slowPointer = head;
            
            while (slowPointer!=fastPointer){
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next;
            }
            return slowPointer;
        }
        return null;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
