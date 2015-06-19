package com.test;

public class RemoveDuplicatesFromSortedArray {
	/*
	 * We maintain a second pointer (correct pointer) which points to the first element initially and compare the element next to it.
	 * If the two pointers are different, we increment the correct pointer and change its value to the one pointed to by the main pointer.
	 * We increment the main pointer.
	 * 
	 * Otherwise, we increment the main pointer while not changing the correct pointer.
	 * 
	 * The final length of the array will be correct pointer + 1;
	 * */
	
	public int removeDuplicates(int[] nums) {
        if (nums.length<1){
            return 0;
        }
        int count = 0;
        for (int i=1;i<nums.length;i++){
            if (nums[i]!=nums[count]){
                ++count;
                nums[count]=nums[i];
            }
                
        }
        return count+1;
    }
}
