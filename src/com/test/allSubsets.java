package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class allSubsets {
	/*
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
		//all subsets
		ArrayList <ArrayList<Integer>> allsubsets;

		//Base case, Add empty set
		if (set.size()==index){
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());
		}
		else{
			// take the first element of the list
			int item = set.get(index);
			// generate all subsets from the remaining list
			allsubsets = getSubsets(set, index+1);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();

			// for every subset found, add subset itself and the subset
			// joined with element chosen in step 1

			for (ArrayList<Integer> subset:allsubsets){
				ArrayList <Integer> newsubset = new ArrayList <Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}

	public static void getSubsets (ArrayList<Integer> set){
		System.out.print(getSubsets(set,0));
	}
	 */


	public static void main(String[] args) {
		allSubsets a = new allSubsets();
		ArrayList <Integer> testArray = new ArrayList<Integer>();
		testArray.add(1);
		testArray.add(2);
		testArray.add(3);
		testArray.add(4);
		int [] testA = {1,2,4};
		System.out.println(a.subsets(testA));

	}

	public List<List<Integer>> subsets(int[] S) {
		return getSubsets(S,0);
	}

	public List<List<Integer>> getSubsets(int[] set, int index){
		List <List<Integer>> allsubsets;

		//Base case, Add empty set
		if (set.length==index){
			allsubsets = new ArrayList<List<Integer>>();
			allsubsets.add(new ArrayList<Integer>());
		}
		else{
			// take the first element of the list
			int item = set[index];
			// generate all subsets from the remaining list
			allsubsets = getSubsets(set, index+1);
			List<List<Integer>> moresubsets = new ArrayList<List<Integer>>();

			// for every subset found, add subset itself and the subset
			// joined with element chosen in step 1

			for (List<Integer> subset:allsubsets){
				List <Integer> newsubset = new ArrayList <Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				Collections.sort(newsubset, new MyComparator());
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets; 
	}
	
	class MyComparator implements Comparator<Integer>{
		public int compare(Integer num1, Integer num2){
			return num1-num2;
		}
	}
}
