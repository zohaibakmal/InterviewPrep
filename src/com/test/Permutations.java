package com.test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
* Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*
* */

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>> ();
        permute (result, new LinkedList<Integer>(),new HashSet<Integer>(), nums);
        return result;
    }

    public void permute(List<List<Integer>> result,
                        LinkedList<Integer> path,
                        HashSet<Integer> set,
                        int[] nums){
        if(set.size()==nums.length){
            result.add(new LinkedList(path));
            return;
        }
        for(int i = 0; i<nums.length;i++){
            if(set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);
            path.add(nums[i]);
            permute(result, path,set, nums);
            set.remove(nums[i]);
            path.remove(path.size()-1);
        }
    }

}
