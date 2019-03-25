package com.test;

import java.util.LinkedList;

/*
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
* */

public class MovingAverageFromDataStream {

    LinkedList<Integer> queue = new LinkedList();
    int size = 0;
    int runningSum = 0;

    /** Initialize your data structure here. */
    public MovingAverageFromDataStream(int size) {
        this.size = size;
    }

    public double next(int val) {
        if(queue.size()==size){
            runningSum =runningSum - queue.remove();
        }
        runningSum =runningSum+ val;
        queue.add(val);
        return ((double)runningSum)/queue.size();
    }
}
