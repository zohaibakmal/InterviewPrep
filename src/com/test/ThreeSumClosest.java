package com.test;

import java.util.Arrays;

/*
* Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
* Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

*
* */

public class ThreeSumClosest {

    /*
    * Similar to 3 Sum problem, use 3 pointers to point current element, next element and the last element.
    * If the sum is less than target, it means we have to add a larger element so next element move to the next.
    * If the sum is greater, it means we have to add a smaller element so last element move to the second last element.
    * Keep doing this until the end. Each time compare the difference between sum and target, if it is less than minimum difference so far, then replace result with it, otherwise keep iterating.
    *
    * Time: O(n^2)
    * */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0]+nums[1]+nums[nums.length-1];
        for (int i =0; i<nums.length-2; i++){
            int start=i+1;
            int end = nums.length-1;
            while (start<end){
                int sum = nums[i]+nums[start]+nums[end];
                if (sum<=target){
                    start++;
                }else{
                    end--;
                }

                if (Math.abs(target-sum) <= Math.abs(target - result) ){
                    result = sum;
                }

            }
        }
        return result;
    }

}
