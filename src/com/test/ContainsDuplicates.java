package com.test;

import java.util.HashSet;

public class ContainsDuplicates {
	public boolean containsDuplicate(int[] nums) {
        if (nums==null || nums.length==0){
            return false;
        }
        HashSet <Integer> set = new HashSet<Integer>();
        for (int i:nums){
        	//return true if the set already has the element. Adds the element to the set 
            if (!set.add(i)){
                return true;
            }
        }
        return false;
    }
}
