package com.test;

/*
* Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
*
* Find all unique triplets in the array which gives the sum of zero.
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /*
    * The idea is to sort an input array and then run through all indices of a possible first element of a triplet.
    * For each possible first element we make a standard bi-directional 2Sum sweep of the remaining part of the array.
    * Also we want to skip equal elements to avoid duplicates in the answer without making a set or smth like that.
    *
    * Time: O(n^2)
    * */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List <List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i=0; i<nums.length-2; i++){
            //Detect and Skip duplicate that are outside the window.
            if (i>0 && nums[i-1]==nums[i]){
                continue;
            }
            int low = i+1;
            int high = nums.length-1;
            while (low<high){
                if (nums[i]+nums[low]+nums[high]==0){
                    List <Integer> triplet = new ArrayList <Integer>();
                    triplet.add(nums[i]);
                    triplet.add(nums[low]);
                    triplet.add(nums[high]);
                    result.add(triplet);
                    //Detect and Skip duplicate that are inside the window.
                    while (low<high && nums[i] + nums[low + 1] + nums[high] == 0) {
                        low++;
                    }
                    //Detect and Skip duplicate that are inside the window.
                    while (low<high && nums[i]+nums[low]+nums[high-1]==0){
                        high--;
                    }
                    low++;
                    high--;
                }
                else if (nums[i]+nums[low]+nums[high]>0){
                    high--;
                }else{
                    low++;
                }
            }
        }
        return result;
    }

    public static void main (String [] args){
        ThreeSum t = new ThreeSum();
        int [] test= new int[]{-1,0,1,2,-1,-4};
        t.threeSum(test);
    }
}
