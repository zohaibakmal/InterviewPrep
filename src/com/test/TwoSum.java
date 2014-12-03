package com.test;

import java.util.Arrays;
import java.util.Hashtable;

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
	
	public static void main(String[] args){
		TwoSum t = new TwoSum();
		int [] testarray= {3,2,4};
		int [] rv = t.twoSum(testarray, 6);
		System.out.println(rv[0]+" "+rv[1]);
		
	}
}
