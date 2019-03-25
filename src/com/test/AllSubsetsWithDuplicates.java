package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsetsWithDuplicates {

    public List<List<Integer>> subsetsWithDupItr(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());

        int pResultSize = 0;
        for (int i =0; i<nums.length; i++){
            int startIndex = 0;
            if (i!=0 && nums[i]==nums[i-1]){
                startIndex = pResultSize;
            }
            int resultSize = result.size();
            for (int j=startIndex; j<resultSize; j++){
                List<Integer> newList = new ArrayList<>(result.get(j));
                newList.add(nums[i]);
                result.add(newList);
            }
            pResultSize = resultSize;
        }
        return result;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        return getSubsets(nums, 0);
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
                if (index!=0 && set[index-1]==item){
                    continue;
                }
                List <Integer> newSubset = new ArrayList<>(resultSet.get(i));
                newSubset.add(item);
                resultSet.add(newSubset);
            }
        }
        return resultSet;
    }
}
