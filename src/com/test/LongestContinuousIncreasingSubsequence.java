package com.test;

public class LongestContinuousIncreasingSubsequence {

    /*
    * Time: O(n)
    * Space: O(1)
    * */
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length<1){
            return nums.length;
        }
        int localMax = 1;
        int globalMax = 1;
        for(int i=1; i<nums.length;i++){
            if(nums[i-1]<nums[i]){
                localMax++;
            }else{
                localMax = 1;
            }
            globalMax = Math.max(localMax, globalMax);
        }
        return globalMax;

    }
}
