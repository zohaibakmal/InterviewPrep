package com.test;

public class MajorityElement {
	
	/*
	 * 	As we sweep we maintain a pair consisting of a current candidate and a counter. Initially, the current candidate is unknown and the counter is 0.
	 *
	 *	When we move the pointer forward over an element e:
	 *		If the counter is 0, we set the current candidate to e and we set the counter to 1.
	 *		If the counter is not 0, we increment or decrement the counter according to whether e is the current candidate.
	 *	When we are done, the current candidate is the majority element, if there is a majority.
	 *	algorithm at http://www.cs.utexas.edu/~moore/best-ideas/mjrty/index.html
	 * */
    public int majorityElement(int[] nums) {
        int majorityElement = nums[0];
        int count = 1;
        for (int i=1;i<nums.length;i++){
            if (majorityElement==nums[i]){
                count++;
            }else{
                if (count>0){
                    count--;
                }else{
                    majorityElement=nums[i];
                    count++;
                }
            }
        }
        return majorityElement;
    }
}
