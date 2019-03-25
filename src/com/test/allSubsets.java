package com.test;

import java.util.*;

public class allSubsets {

	public static void main(String[] args) {
		allSubsets a = new allSubsets();
		ArrayList <Integer> testArray = new ArrayList<Integer>();
		testArray.add(1);
		testArray.add(2);
		testArray.add(3);
		testArray.add(4);
		int [] testA = {1,2,4};
		System.out.println(a.subsets2(testA));

	}

	/*
	* Time: 2^n. We are doubling the number of operations on every loop
	* */
	public List<List<Integer>> subsets(int[] S) {
		return getSubsets(S,0);
	}

	public List<List<Integer>> getSubsets(int[] set, int index){
		List <List<Integer>> resultSet;

		//Base case, Add empty set
		if (set.length==index){
			resultSet = new ArrayList<List<Integer>>();
			resultSet.add(new ArrayList<Integer>());
		}
		else{
			// Step1: take the first element of the list
			int item = set[index];

			// Step2: generate all subsets from the remaining list
			resultSet = getSubsets(set, index+1);

			// for every subset in the resultSet, add subset itself and the subset joined with element chosen in step 1
			// i.e. for every subset in the resultSet, duplicate it, add the current element chosen at Step1 to the duplicate and add the new set back to the resultSet.
			int size = resultSet.size();

			for (int i=0; i<size; i++){
				List <Integer> newSubset = new ArrayList<>(resultSet.get(i));
				newSubset.add(item);
				resultSet.add(newSubset);
			}
		}
		return resultSet;
	}
	
	class MyComparator implements Comparator<Integer>{
		public int compare(Integer num1, Integer num2){
			return num1-num2;
		}
	}







	/*
	* Time: 2^n. We are doubling the number of operations on every loop
	*
	* The Algorithm works as below:
	* 1. We Initialize a resultSet and add an empty set to it.
	* 2. Then we iterate the input array and for each element,
	* 	a. We take the current resultSet and duplicate it.
	*  	b. For each set in the duplicate, we add the current element
	* 3. We add the duplicateSet to the original set. Essentially doubling its size at each iteration.
	* */

	public List<List<Integer>> subsetsItr(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<Integer>());

		for (int i:nums){
			int resultSize = result.size();
			for (int j=0; j<resultSize; j++){
				List<Integer> newList = new ArrayList<>(result.get(j));
				newList.add(i);
				result.add(newList);
			}
		}
		return result;
	}



	/*
	 * Time: 2^n. We are doubling the number of operations on every loop
	 *
	 * Another slightly obscure version of backtracking
	 * */

	public List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> result, List<Integer> list, int [] nums, int currIdx){
		result.add(new ArrayList<>(list));
		for(int i=currIdx; i<nums.length; i++){
			list.add(nums[i]);
			backtrack(result, list, nums, i+1);
			list.remove(list.size()-1); //backtrack
		}
	}
}
