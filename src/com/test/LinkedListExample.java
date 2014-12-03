package com.test;

public class LinkedListExample {

	private static class Node{

		int data;
		Node next = null;

		public Node (int d){
			data = d;
		}

		public Node() {
		}

		public void addElement(int input){

			Node newNode = new Node(input);

			Node current = this;

			while (current.next != null){
				current = current.next;
			}

			current.next = newNode;

		}

		public void printLinkedList (){
			Node current = this;
			while(current.next!=null){
				System.out.print(" "+current.data );
				current = current.next;
			}
			System.out.print(" "+ current.data+ "\n");
		}

		public void deleteLastElement(){
			Node current = this;
			Node previous = this;
			while (current.next != null){
				previous = current;
				current = current.next;
			}
			previous.next = null; 

		}

		public Node reverseLinkedList(Node input){
			Node prev = null;
			Node curr = input; 
			while (curr.next!=null){
				Node next = curr.next;	
				curr.next = prev;
				prev = curr;
				curr  = next;
			}
			curr.next = prev;
			return curr;
		}

	}



	static Node linkedList = new Node(1);

	public static void main(String [] args){
		linkedList.addElement(2);
		linkedList.addElement(3);
		linkedList = linkedList.reverseLinkedList(linkedList);
		linkedList.printLinkedList();
	}
}
