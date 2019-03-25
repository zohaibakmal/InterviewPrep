package com.test;

public class InsertIntoACyclicSortedList {
    static class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val,Node _next) {
            val = _val;
            next = _next;
        }
    }

    public static Node insert(Node head, int insertVal) {
        if(head==null){
            return  new Node(insertVal, head);
        }

        Node result = head;
        while (true){
            if(head.val<=insertVal && insertVal <=head.next.val){
                Node newNode = new Node(insertVal, head.next);
                head.next = newNode;
                return result;
            }
            head = head.next;
        }
        // return result;
    }

    public static void main(String [] args){
        Node one = new Node(3, null);

        Node three= new Node(3, null);
        Node four = new Node(3, null);

        one.next = three;

        three.next = four;

        four.next=one;
        insert(three, 2);
    }
}
