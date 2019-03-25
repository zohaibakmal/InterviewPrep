package com.test;

import java.util.*;

public class AmazonInterviewQuestion {

    public List<Integer> cellCompete(int[] states, int days){
        // WRITE YOUR CODE HERE
        List <Integer> result = new ArrayList<>();
//        for(int i=0; i<states.length; i++){
//            result.add(states[i]);
//        }
        for (int x=0; x<days; x++){
            result.clear();

            for(int i=0; i<states.length; i++){
                result.add(states[i]);
            }

            for(int j=0; j<result.size(); j++){
                //first end
                int before = 0;
                int after = 0;
                if(j>0){
                    before = result.get(j-1);
                }
                if(j<result.size()-1){
                    after = result.get(j+1);
                }
                int current = before ^ after;
                states[j] = current;
//                result.set(j,current);
            }
        }
        result.clear();

        for(int i=0; i<states.length; i++){
            result.add(states[i]);
        }
        return result;
    }

    private int calculateGcd(int a, int b){
        if(a==0)
            return b;
        return calculateGcd(b%a, a);

    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int generalizedGCD(int num, int[] arr)
    {
        if(arr.length==0 || num==0){
            return 1;
        }
        // WRITE YOUR CODE HERE
        int result = arr[0];
        for( int i=1; i<arr.length; i++){
            result = calculateGcd(arr[i], result);
        }
        return result;
    }










    /*
    Time Complexity: O ( n Log(n) ) where n is the number of locations.
    Space Complexity: O (n) where n is the number of locations. This space complexity is due to the heap that we maintain.
    */
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<List<Integer>> ClosestXdestinations(int numDestinations,
                                             List<List<Integer>> allLocations,
                                             int numDeliveries)
    {
        // We can maintain a minHeap and order the items by the distance from truck's position.
        // This way we can have a structure where closest destinations are stored at the very top of the heap.
        // Insertions and deletions in this heap are very efficient. It would require O(log n) per insertion/deletion.

        PriorityQueue <SortedQueueItem> queue = new PriorityQueue(new HeapComparator());

        // We Iterate over our locations and add each location to the heap.
        for (List <Integer> location: allLocations){
            SortedQueueItem item = new SortedQueueItem(location.get(0), location.get(1));
            queue.add(item);
        }

        List<List<Integer>> result = new LinkedList<List<Integer>>();

        // Depending on the number of deliveries, we need to remove items from our heap based on the closest distance.
        for(int i=0; i<numDeliveries; i++){
            SortedQueueItem smallestItem = queue.remove();
            List<Integer> resultItem = new LinkedList();
            resultItem.add(smallestItem.x);
            resultItem.add(smallestItem.y);
            result.add(resultItem);
        }
        return result;
        // WRITE YOUR CODE HERE
    }
    // METHOD SIGNATURE ENDS


    // A convenience structure to represent each node in the Heap.
    class SortedQueueItem{
        public int x;
        public int y;
        public int distance;
        public SortedQueueItem(int x, int y){
            this.x = x;
            this.y = y;
            this.distance = x*x + y*y;
        }
    }

    // A comparator to help us in building the heap.
    class HeapComparator implements Comparator <SortedQueueItem>{
        public int compare(SortedQueueItem item1, SortedQueueItem item2){
            return item1.distance - item2.distance;
        }
    }








    List<List<Integer>> optimalUtilization(
            int deviceCapacity,
            List<List<Integer>> foregroundAppList,
            List<List<Integer>> backgroundAppList)
    {
        // Maintain a variable to track the maximum Memory utilization;
        int max = 0;

        List<List<Integer>> result = new LinkedList<List<Integer>>();

        // Add memory
        for(List<Integer> foregroundItem: foregroundAppList){
            for(List<Integer> backgroundItem: backgroundAppList){
                int memoryUtilization = foregroundItem.get(1) + backgroundItem.get(1);

                if(memoryUtilization<=deviceCapacity){
                    if(memoryUtilization>max){
                        result.clear();
                        List<Integer> resultItem = new LinkedList();
                        resultItem.add(foregroundItem.get(0));
                        resultItem.add(backgroundItem.get(0));
                        result.add(resultItem);
                        max = foregroundItem.get(1) + backgroundItem.get(1);
                    }else if(memoryUtilization==max){
                        List<Integer> resultItem = new LinkedList();
                        resultItem.add(foregroundItem.get(0));
                        resultItem.add(backgroundItem.get(0));
                        result.add(resultItem);
                    }
                }
            }
        }

        return result;
    }



    // METHOD SIGNATURE ENDS



    public static void main(String [] args){


//        System.out.println(AmazonInterviewQuestion.getDistanceFrom(7,9));
        AmazonInterviewQuestion question = new AmazonInterviewQuestion();

        List<List<Integer>> input = new LinkedList<List<Integer>>();
        List<Integer> l1 = new LinkedList<Integer>();
        l1.add(1);
        l1.add(-3);
        input.add(l1);
        List<Integer> l2= new LinkedList<Integer>();
        l2.add(1);
        l2.add(2);
        input.add(l2);




        question.ClosestXdestinations(2,input, 1);
    }

}
