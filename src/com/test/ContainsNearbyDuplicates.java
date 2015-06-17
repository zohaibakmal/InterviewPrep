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
                map.put(nums[i], i);
            }else{
                map.put(nums[i], i);
            }
        }
        return false;
    }
    
}
