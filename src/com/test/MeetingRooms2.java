package com.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {

    /*
        1. Sort the given meetings by their start time.
        2. Use a minHeap to keep track of meeting's ending times. The heap is ordered to have lowest element at the top.
        3. For every meeting room check if the minimum element of the heap i.e. the room at the top of the heap is free or not.
        4. If the room is free, then we remove the topmost element and add the current meeting's ending time.
        5. If not, then we allocate a new room and add it to the heap.
        6. After processing all the meetings, the size of the heap will tell us the number of rooms allocated. This will be the minimum number of rooms needed to accommodate all the meetings.
    * */
    public int minMeetingRooms(Interval[] intervals) {
        int result = 0;
        if(intervals.length <2){
            return intervals.length;
        }
        Arrays.sort(intervals, new MyCustomComparator());

        PriorityQueue<Integer> minHeap = new PriorityQueue();

        for(int i=0; i<intervals.length;i++){
            if(!minHeap.isEmpty()){
                if(minHeap.peek() <= intervals[i].start){
                    minHeap.remove();
                }
            }
            minHeap.add(intervals[i].end);
        }

        return minHeap.size();

    }

    class MyCustomComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2){
            return i1.start-i2.start;
        }
    }
}
