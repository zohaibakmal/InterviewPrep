package com.test;

public class CircularQueue {

    int [] queue;
    int head    = 0;
    int tail    = -1;
    int size    = 0;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public CircularQueue(int k) {
        queue = new int [k];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        tail = (tail+1) % queue.length;
        queue[tail] = value;

        size++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        head = (head+1) % queue.length;
        size--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return queue[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return queue[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size==0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size==queue.length;
    }
}
