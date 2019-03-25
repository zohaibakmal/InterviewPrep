package com.test;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLists {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ListNode l1 = new ListNode(-2);
        l1.next = new ListNode(-1);
        l1.next.next = new ListNode(-1);
        l1.next.next.next = new ListNode(-1);

        ListNode l2 = null;

//        ListNode l3 = new ListNode(2);
//        l3.next = new ListNode(6);

        MergeKLists lists = new MergeKLists();
        lists.mergeKLists(new ListNode[] {l1,l2});


	}
	
//	class ListNode {
//		int val;
//		ListNode next;
//		ListNode(int x) {
//			val = x;
//			next = null;
//		}
//	}
	
	class MergeKListComparator implements Comparator<ListNode>{

		@Override
		public int compare(ListNode o1, ListNode o2) {
			if (o1.val<o2.val)
	            return -1;
	        else if (o1.val==o2.val)
	            return 0;
	        else 
	            return 1;
		}
	}

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new MergeListComparator());
        for(ListNode item: lists){
            if(item!=null){
                queue.add(item);
            }
        }
        ListNode fakeHead = new ListNode(-1);
        ListNode result = fakeHead;
        while(!queue.isEmpty()){
            ListNode current = queue.remove();
            result.next = current;
            result = result.next;
            if(current.next!=null){
                queue.add(current.next);
            }
        }
        return fakeHead.next;
    }


    class MergeListComparator implements Comparator<ListNode>{
        @Override
        public int compare (ListNode node1, ListNode node2){
            if(node1.val==node2.val){
                return 0;
            }else if(node1.val>node2.val){
                return 1;
            }else{
                return -1;
            }
        }
    }


//    public ListNode mergeKListsDivideAndConquer(ListNode[] lists) {
//	    List<ListNode>
//
//        return fakeHead.next;
//    }


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
	
}





