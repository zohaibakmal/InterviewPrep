package com.test;

import java.util.HashMap;

public class ContainsNearbyDuplicates {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
    	HashMap <Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i=0; i<nums.length; i++){
            if (map.containsKey(nums[i])){
                if ((i-map.get(nums[i]))<=k){
                    return true;
                }
                map.put(nums[i], i); //ensures that we have the most recent mapping in
            }else{
                map.put(nums[i], i);
            }
        }
        return false;
    }
    
}
