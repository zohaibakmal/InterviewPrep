package com.test;

public class DetectCycle {

	public ListNode detectCycle(ListNode head) {
        if (head==null){
            return head;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        boolean hasCycle = false;
        
        while(fastPointer!=null &&fastPointer.next!=null){
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


    public boolean hasCycle(ListNode head) {

        if (head==null){
            return false;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head;


        while (fastPointer !=null && fastPointer.next !=null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer){
                return true;
            }
        }

        return false;
    }
	
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node.next = node2;
        node2.next = node;
        DetectCycle cycle = new DetectCycle();

	}

}
