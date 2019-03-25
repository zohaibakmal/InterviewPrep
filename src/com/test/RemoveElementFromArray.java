package com.test;

public class RemoveElementFromArray {

	/*
	 * Keep a second (correct pointer)
	 * Initially, both pointers pointer to the same value.
	 * 
	 * If (value is equal to the value being removed)
	 * 	We increment the main pointer by 1;
	 * Otherwise, we swap the value pointed to by the correct pointer with the main pointer and increment both by 1.
	 *
	 * Time Complexity O(n)
	 * Space Complexity O(1)
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


	public int removeElement2(int[] nums, int val) {
		int i = 0;
		int n = nums.length;
		while (i < n) {
			if (nums[i] == val) {
				nums[i] = nums[n - 1];
				// reduce array size by one
				n--;
			} else {
				i++;
			}
		}
		return n;
	}


	public static void main (String [] args){
		RemoveElementFromArray r = new RemoveElementFromArray();
		r.removeElement2(new int[]{3,2,2,3}, 3);
	}
}
