package com.test;

import java.util.Arrays;
/*
* Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Note:

Your algorithm should run in O(n) time and uses constant extra space.
* */
public class FirstMissingPositive {
    /*
    * Sort the array.
    * Find the smallest positive number not seen.
    *
    * Time: O(n Log n)
    * Space: O(n)
    * */
    public int firstMissingPositiveNaive(int[] nums) {
        Arrays.sort(nums);
        int result = 1;
        for (int i:nums){
            if(i==result){
                result++;
            }
        }
        return result;
    }


    /*
     * We know that for a given array, the result must be in the range 1 to array.length+1
     * Given this knowledge, we try to put our array items into the position which is exactly their value.
     * E.g. if value is 1, we move it to the first index. If it is second, we move it to 2nd index....
     *
     * Once we have this, we can easily determine our result.
     *
     *
     *
     * Time: O(n)
     * Space: O(1)
     * */
    public int firstMissingPositive(int[] nums) {
        int i=0;

        while (i<nums.length){
            /*
            * We swap if:
            *   - Value is in the range 1 - length
            *   - Value at its corresponding index not the same (Handles duplicates).
            * */

            if(nums[i]>0 && nums[i]<=nums.length && nums[i]!=nums[nums[i]-1]){
                swap(nums, i, nums[i]-1);
            }else{
                i++;
            }
        }
        int result =1;
        for(i=0; i<nums.length; i++){
            if(result==nums[i]){
                result++;
            }
        }
        return result;
    }

    private void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
