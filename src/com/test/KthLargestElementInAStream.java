package com.test;

import java.util.PriorityQueue;

/*
Design a class to find the kth largest element in a stream.

Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method add, return the element representing the kth largest element in the stream.

Example:

int k = 3;
int[] arr = [4,5,8,2];

KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8
Note:
You may assume that nums' length ≥ k-1 and k ≥ 1.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
* */

public class KthLargestElementInAStream {

    private PriorityQueue<Integer> queue;
    int maxSize = 0;
    public KthLargestElementInAStream(int k, int[] nums) {
        maxSize = k;
        queue = new PriorityQueue(k);
        for (int item: nums){
            add(item);
        }
    }

    public int add(int val) {
        if(queue.size() < maxSize){
            queue.add(val);
        }else if(queue.peek()<val){
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }

}

/*
* Time Complexity:
* Initially building the heap: O(n Log k)
* Add operation: O(Log k). Insert/Delete in Priority Queue requires O(Log k),
* Space Complexity: O(1)
* [2,3,4,5,8];
[2,3,4,5,5,8];
[2,3,4,5,5,8,10];

[2,3,4,5,5,8,9,10];
[2,3,4,5,8,10];

[2,3,4,5,8,9,10];

[2,3,4,4,5,8,9,10];
* */

