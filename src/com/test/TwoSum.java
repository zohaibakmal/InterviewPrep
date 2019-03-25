package com.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
/*
* Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
* */
public class TwoSum {
	public int[] twoSum (int[] numbers, int target) {
		Hashtable<Integer, Integer> table= new Hashtable<Integer, Integer>();
		
		int [] returnArray = new int[2];
//		Arrays.sort(numbers);
        
		for (int i=0;i<numbers.length;i++){
			table.put(numbers[i],i+1);
		}
		
		for (int i=0; i<numbers.length;i++){
			if (table.containsKey(target - numbers[i])){
				if (table.get(target-numbers[i])!=i+1){
					returnArray[0] = i+1;
					returnArray[1] = table.get(target-numbers[i]);
					return returnArray;
				}
			}
		}
		
		
        return returnArray;
    }

    /*
    * Put previous values in a map and try to lookup current's value's complement by doing target - current value.
    *
    * Time: O(n)
    * Space: O(n)
    * */

	public int[] twoSum2(int[] nums, int target) {
		HashMap <Integer, Integer> map = new HashMap<Integer, Integer>();
		int result []  = new int [2];
		for (int i=0; i<nums.length; i++){
			if (map.containsKey(target-nums[i])){
				result [0] = map.get(target-nums[i]);
				result [1] = i;
				return result;
			}else{
				map.put(nums[i], i);
			}
		}
		return null;
	}


	/*
	* Brute force method.
	* Compare subtract from target all possible pairs of elements.
	*
	* Time: O(n*n)
	* Space: O(1)
	* */
	public int[] twoSumBruteForce(int[] nums, int target) {
		int result []  = new int [2];
		for (int i=0; i<nums.length; i++){
			for (int j=i+1; j<nums.length; j++){
				if (target-nums[i]-nums[j]==0){
					result [0] = i;
					result [1] = j;
					return result;
				}
			}
		}
		return null;
	}



	public static void main(String[] args){
		TwoSum t = new TwoSum();
		int [] testarray= {3,2,4};
		int [] rv = t.twoSum(testarray, 6);
		System.out.println(rv[0]+" "+rv[1]);
		
	}
}
