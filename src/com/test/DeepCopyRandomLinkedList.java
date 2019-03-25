package com.test;

import java.util.HashMap;

public class DeepCopyRandomLinkedList {


	/*
	 * Space: O(N)
	 * Time: O(1)
	 * */
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


	/*
	* Space: O(N)
	* Time: O(N)
	* */

	public RandomListNode copyRandomListWithMap(RandomListNode head) {
		RandomListNode fakeHead = new RandomListNode(-1);
		RandomListNode copy = fakeHead;
		RandomListNode prev = null;
		HashMap<RandomListNode, RandomListNode> map = new HashMap();
		while (head!=null){
			RandomListNode newNode = null;
			RandomListNode randomNode = null;
			if(map.containsKey(head)){
				newNode = map.get(head);
			}else{
				newNode = new RandomListNode(head.label);
				map.put(head,newNode);
			}

			if(head.random!=null){
				if(map.containsKey(head.random)){
					newNode.random = map.get(head.random);
				}else{
					newNode.random = new RandomListNode(head.random.label);
					map.put(head.random, newNode.random);
				}
			}

			if(prev!=null){
				prev.next = newNode;
			}
			prev = newNode;
			copy.next = newNode;
			copy = copy.next;
			head = head.next;
		}
		return fakeHead.next;
	}


	static class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};

}
