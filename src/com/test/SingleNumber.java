package com.test;

import java.util.HashSet;

/*
* Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?


* */
public class SingleNumber {

	/*
	* Maintain a Set. If the set contains the element, remove it.
	* Otherwise, add one. At the end, only one element will be left which will be the answer.
	*
	* Time complexity : O(n * 1)
	* Space complexity : O(n)
	* */
	public int singleNumber(int[] nums) {
		HashSet<Integer> set = new HashSet <Integer>();

		for (int entry:nums){
			if (set.contains(entry)){
				set.remove(entry);
			}else{
				set.add(entry);
			}
		}
		return set.toArray(new Integer[set.size()])[0];
	}



	/*
	* If we take XOR of zero and some bit, it will return that bit
	* a XOR 0 = a
	*
	* If we take XOR of two same bits, it will return 0
	* a XOR a = 0
	*
	* Therefore
	* a XOR b XOR a = (a XOR a) XOR b = b
	*
	* So we can XOR all bits together to find the unique number.
	* */

	public int singleNumber2(int[] nums) {
		int result = 0;
		for (int i = 0; i<nums.length; i++)
		{
			result ^=nums[i];
		}
		return result;
	}
	public static void main(String[] args) {
		int []A = {1,2,1,3,4,3,4};
//		System.out.println(singleNumber(A, A.length));
	}

}
