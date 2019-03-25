package com.test;

import java.util.Arrays;

/**
 * Created by v652420 on 11/7/17.
 *
 *
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

 You need to find the shortest such subarray and output its length.

 Example 1:
 Input: [2, 6, 4, 8, 10, 9, 15]
 Output: 5
 Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 Note:
 Then length of the input array is in range [1, 10,000].
 The input array may contain duplicates, so ascending order here means <=.
 */
public class ShortestUnsortedContinuousArray {

    public int findUnsortedSubarray_sorting(int[] nums) {

        /*
        * Sort the Array.
        *
        * Compare Sorted Array with unsorted array and record indices where values are different.
        *
        * Return new length.
        *
        * Time: O(n(log(n))). Sorting takes n(log(n)) time.
        * Space: O(n). Space taken by new array.
        *
        * */

        int [] sortedArray = nums.clone();
        //Sorting takes n
        Arrays.sort(sortedArray);
        int min=0;
        int max=nums.length-1;
        boolean maxFound = false;
        boolean minFound = false;
        while (min<max && (!maxFound||!minFound)){
            if (sortedArray[min]== nums[min]){
                min++;
            }else {
                minFound=true;
            }
            if (sortedArray[max]== nums[max]){
                max--;
            }else{
                maxFound=true;
            }
        }
        if (minFound||maxFound){
            return max-min+1;
        }else{
            return 0;
        }

    }

    /*
    * We use a two pointer approach, i & j and inspect all elements that are out of place.
    *
    * Let i<j<n
    *
    * For each nums[i], we compare it with nums[j]. If nums[i]>num[j], the value is out of place.
    *
    * To find the minimum index, we make sure we record the minimum index of out of place element.
    * i.e. min = Math.min(min, i)
    *
    * To find the maximum index, we make sure we record the maxmimum index of the out place element.
    * i.e. max = Math.max(max,i)
    *
    * Time: O(n^2)
    * Space: O(1).
    * 
    * */
    public int findUnsortedSubarray2(int[] nums) {
        int min = nums.length-1;
        int max = 0;

        for (int i=0; i<nums.length; i++){
            for (int j=i; j<nums.length; j++){
                if (nums[i]>nums[j]){
                    min = Math.min (min, i);
                    max = Math.max(max, j);
                }
            }
        }
        return (min-max)==(nums.length-1) ? 0:(max-min+1);
    }




}
