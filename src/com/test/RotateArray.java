package com.test;

public class RotateArray {
	
    public void rotate(int[] nums, int k) {
        
    	//account for cases where k>length of array
        k = k % nums.length;
        
        if (nums.length<2 || k==0){
        	return;
        }
        //divide the array into 2 parts. 
        //rotate the first part
        //rotate the second part
        //rotate the whole array
        reverse(nums, 0, nums.length-1 - k);
        reverse(nums, nums.length - k, nums.length-1);
        reverse(nums, 0, nums.length-1);
    }
	
	public void reverse(int [] array, int start, int end){
		
		while (start<end){
			int temp = array[end];
			array[end]=array[start];
			array[start] = temp;
			start++;
			end--;
		}
    }
}
