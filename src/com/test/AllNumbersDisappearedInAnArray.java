package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v652420 on 11/2/17.
 */
public class AllNumbersDisappearedInAnArray {


    /*
    * The basic idea is that we iterate through the input array and mark elements as negative using
    * nums[nums[i] -1] = -nums[nums[i]-1].
    * In this way all the numbers that we have seen will be marked as negative.
    * In the second iteration, if a value is not marked as negative, it implies we have never seen that index before, so just add it to the return list.
    *
    * Time: O(N)
    * Space: O(1)
    * */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List <Integer> result = new ArrayList<Integer>();

        for (int i=0; i<nums.length; i++){
            int val = Math.abs(nums[i]);
            if (nums[val-1]>0){
                nums[val-1] = -nums[val-1];
            }

        }

        for (int i=0; i < nums.length;i++){
            if (nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    }
}
