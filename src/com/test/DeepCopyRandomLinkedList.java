package com.test;

public class DeepCopyRandomLinkedList {

	public static RandomListNode copyRandomList(RandomListNode head) {

		if (head==null){
			return head;
		}

		RandomListNode headCopy = head;
		// insert a new node in front of the each node
		while(head!=null){
			RandomListNode deepCopy;
			RandomListNode headNext = head.next;
			deepCopy = new RandomListNode(head.label);
			head.next = deepCopy;
			deepCopy.next = headNext;
			head = headNext;
		} 
		head = headCopy;
		RandomListNode deepCopy = head.next;

		//Random node for the new node point to the random node of the previous node's random + 1. 
		//Communicate this to every node in front.
		while (head!=null){
			deepCopy.random = head.random.next;
			if (head.next.next!=null){
				deepCopy = deepCopy.next.next;
			}
			head = head.next.next;
		}

		head = headCopy;
		deepCopy = head.next;
		RandomListNode deepReturn = head.next;

		//seperate the original linked list from the deep copy
		while (head!=null){
			if (head.next.next==null){
				head.next = null;
				deepCopy.next = null;
			}else{
				head.next = head.next.next;	
				deepCopy.next = deepCopy.next.next;
			}
			
			head = head.next;
			deepCopy = deepCopy.next;
		}

		return deepReturn;
	}
	public static void main(String[] args) {
		RandomListNode l1 = new RandomListNode(1);
		RandomListNode l2 = new RandomListNode(2);
		RandomListNode l3 = new RandomListNode(3);
		RandomListNode l4 = new RandomListNode(4);
		
//		l1.next = l2;
//		l2.next = l3;
		l3.next = l4;
		l1.random = l3;
		l2.random = l1;
		l3.random = l4;
		l4.random = l2;
		
		copyRandomList(l1);
	}
	
	static class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};

}
