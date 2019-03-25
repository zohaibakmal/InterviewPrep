package com.test;

import java.util.LinkedList;

public class MovingAverage {

    LinkedList<Integer> queue = new LinkedList();
    int size = 0;
    int runningSum = 0;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        if(queue.size()==size) {
            runningSum = runningSum - queue.remove();

        }
        runningSum =runningSum+ val;
        queue.add(val);
        return runningSum/queue.size();
    }

    public static void main(String [] args){
        MovingAverage average = new MovingAverage(3);
        average.next(1);
        average.next(10);
        average.next(3);
        average.next(5);
    }
}