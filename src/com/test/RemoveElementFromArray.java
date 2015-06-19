package com.test;

public class RemoveElementFromArray {

	/*
	 * Keep a second (correct pointer)
	 * Initially, both pointers pointer to the same value.
	 * 
	 * If (value is equal to the value being removed)
	 * 	We increment the main pointer by 1;
	 * Otherwise, we swap the value pointed to by the correct pointer with the main pointer and increment both by 1.
	 * */
	
	public int removeElement(int[] nums, int val) {
        int count = 0;
        for(int i=0;i<nums.length;i++){ 
            if(nums[i]!=val){ 
                nums[count++]=nums[i];
            }
        }
        return count;
        
    }
	
}
