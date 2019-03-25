package com.test;

import java.util.Collections;
import java.util.HashMap;

/**
 * Created by v652420 on 10/24/17.
 *
 *
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

 Example 1:
 Input: [1, 2, 2, 3, 1]
 Output: 2
 Explanation:
 The input array has a degree of 2 because both elements 1 and 2 appear twice.
 Of the subarrays that have the same degree:
 [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 The shortest length is 2. So return 2.

 Example 2:
 Input: [1,2,2,3,1,4,2]
 Output: 6
 Note:

 nums.length will be between 1 and 50,000.
 nums[i] will be an integer between 0 and 49,999.

 Time: O(n)
 Space: O(n)


 */
public class DegreeOfAnArray {

    public int findShortestSubArray(int[] nums) {
        //<Number, firstOccuranceIndex>
        HashMap <Integer, Integer> firstOccurance = new HashMap<Integer, Integer>();

        //<Number, lastOccuranceIndex>
        HashMap <Integer, Integer> lastOccurance = new HashMap<Integer, Integer>();

        //<Number, degree>
        HashMap <Integer, Integer> degreeCount = new HashMap<Integer, Integer>();

        for (int i=0; i<nums.length;i++){
            if (firstOccurance.get(nums[i])==null){
                firstOccurance.put(nums[i], i);
            }

            lastOccurance.put(nums[i], i);

            degreeCount.put(nums[i], degreeCount.getOrDefault(nums[i], 0)+1);
        }

        int ans = Integer.MAX_VALUE;
        int degreeMax = Collections.max(degreeCount.values());

        for (int key : degreeCount.keySet()){
            if (degreeCount.get(key)==degreeMax){
                ans = Math.min(ans, (lastOccurance.get(key) - firstOccurance.get(key)+1)) ;
            }
        }
        return ans;
    }

    public static void main (String [] args){
        DegreeOfAnArray d = new DegreeOfAnArray();
        int [] nums = new int []{1,2,2,3,1,4,2};
        System.out.println(d.findShortestSubArray(nums));
    }
}
