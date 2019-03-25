package com.test;

/**
 * Created by v652420 on 10/21/17.
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 *
 * Solution: Kadane's Algorithm
 *
 *  Kadane's algorithm is based on splitting up the set of possible solutions into mutually exclusive (disjoint) sets.
 *  It exploits the fact that any solution (i.e., any member of the set of solutions) will always have a last element i (this is what is meant by "sum ending at position i").
 *  Thus, we simply have to examine, one by one, the set of solutions whose last element's index is 1, the set of solutions whose last element's index is 2, then 3, and so forth to n.
 *  It turns out that this process can be carried out in linear time.
 *
 *  Kadane's algorithm begins with a simple inductive question: if we know the maximum subarray sum ending at position i (call this SUM{i}), what is the maximum subarray sum ending at position i+1 (equivalently, what is SUM{i+1})?
 *  The answer turns out to be relatively straightforward: either the maximum subarray sum ending at position i+1 includes the maximum subarray sum ending at position i as a prefix, or it doesn't
 *  (equivalently, SUM{i+1}=max(NUMS{i+1},NUMS{i+1}+SUM{i}), where  NUMS{i+1} is the element at index  i+1).


 *
 * Time: O(n)
 *
 */
public class maximumSubarray {


    /*
    * Solve using Kadane's algorithm
    *
    * Initialize maxGlobal = nums[0]
    * Initialize maxLocal = nums[0]
    *
    * Loop for each element of the array.
    * a.    update maxLocal. maxLocal = maxLocal + nums[i]
    * b.    if maxLocal<0, then maxGlobal = 0;
    * c.    if maxGlobal<maxLocal, then maxGlobal = maxLocal
    * */
    public int maxSubArray(int[] nums) {
        //Global maximum
        int maxSoFar=nums[0];

        //Local maximum
        int maxEndingHere=nums[0];

        for (int i=1;i<nums.length;++i){

            maxEndingHere= Math.max(maxEndingHere+nums[i],nums[i]);

            // update global maximum if new sub array
            maxSoFar=Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    /*
    * Time: O(n*n)
    * Sspace: O(1)
    * */
    public int maxSubArrayBruteForce(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        for (int i=0; i<nums.length;i++){
            int sum = 0;
            for (int j=i; j<nums.length; j++){
                sum += nums[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

}
