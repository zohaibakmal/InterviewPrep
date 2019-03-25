package com.test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by v652420 on 11/1/17.
 *
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.

 */
public class MoveZeros {



    /*
    * Time: O(n)
    * Space: O(1)
    *
    * Move the non-zero digits as far to the left as possible.
    * This can be done by two pointer approach.
    *
    * insertIndex => points to the zeroIndex
    * i => For each non-zero, we copy its value to the zeroIndex.
    * */
    public void moveZeroes(int[] nums) {

        //
        int insertIndex= 0;

        for (int i=0; i<nums.length; i++){
            if (nums[i]!=0){
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }
        for (int i=insertIndex; i<nums.length ; i++){
            nums[i]= 0;
        }
    }


    /*
    * Push all non-zeros in a linkedList.
    *
    * Then traverse the list again.
    * For each index, pop an element from the queue and add it to the current index.
    *
    * When the queue has been completely popped, fill the rest of the array with 0s.
    *
    * Time: O(n).
    * Space: O(n).
    *
    * */
    public void moveZeroes2(int[] nums) {

        Queue <Integer> queue = new LinkedList<>();


        for (int i=0; i< nums.length; i++){
            if (nums[i]!=0){
                queue.add(nums[i]);
            }
        }

        for (int i=0; i<nums.length; i++){
            if (queue.size()>0){
                nums[i]= queue.remove();
            }else{
                nums[i]= 0;
            }
        }
    }

}
