package com.test;

public class RemoveDuplicatesFromSortedArray {
	/*
	 * We maintain a second pointer (correct pointer) which points to the first element initially and compare the element next to it.
	 *
	 * The idea is to identify duplicates and skip them. Once we identify that the two numbers in comparison are not duplicates,
	 * we increment the slowPointer and copy the value of fast pointer to the new value pointed to by the slow pointer.
	 * 
	 * Otherwise, we increment the main pointer while not changing the correct pointer.
	 * 
	 * The final length of the array will be correct pointer + 1;
	 *
	 * Time: O(n)
	 * Space: O(1)
	 * */
	
	public int removeDuplicates(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int slowP=0;
        for (int fastP=1; fastP<nums.length; fastP++){
            if (nums[slowP]!=nums[fastP]){
                slowP++;
                nums[slowP] = nums[fastP];
            }
        }
        return slowP+1;
    }
}
