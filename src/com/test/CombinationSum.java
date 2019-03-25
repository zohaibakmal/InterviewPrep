package com.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
* Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
* */

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Arrays.sort(candidates);
        combinationSum(result, new LinkedList(),candidates,target,0);
        return result;
    }
    private void combinationSum(List<List<Integer>> result,
                                List<Integer> path,
                                int[] candidates,
                                int remainder,
                                int start){
        if(remainder<0) {
            return;
        }else if(remainder==0){
            result.add(new LinkedList(path));
        }else{
            for(int i=start;i<candidates.length;i++){
                path.add(candidates[i]);
                //important to pass i as new start
                combinationSum(result,
                        path,
                        candidates,
                        remainder-candidates[i],
                        i);
                path.remove(path.size()-1);
            }
        }

    }
}
