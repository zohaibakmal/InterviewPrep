package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
*
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*
* */
public class IntersectionOfTwoArrays2 {


    public int[] intersectWithSort(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<Integer>();
        int i=0;
        int j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                result.add(nums1[i]);
                i++;
                j++;
            }
        }

        int [] finalResult = new int[result.size()];
        for(int z=0;z<result.size();z++){
            finalResult[z] = result.get(z);
        }
        return finalResult;

    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap <Integer, Integer>map = new HashMap();
        int [] temp=null;
        if(nums1.length>nums2.length){
            temp=nums1;
            nums1=nums2;
            nums2 = temp;
        }
        for(int i=0; i<nums1.length; i++){
            if(map.containsKey(nums1[i])){
                map.put(nums1[i],map.get(nums1[i])+1);
            }else{
                map.put(nums1[i],1);
            }
        }

        List <Integer> result = new ArrayList<Integer>();
        for(int i=0;i<nums2.length; i++){
            if(map.containsKey(nums2[i])){
                if(map.get(nums2[i])>0){
                    result.add(nums2[i]);
                    map.put(nums2[i], map.get(nums2[i]) -1);
                }
            }
        }
        int [] finalResult = new int[result.size()];
        for(int z=0;z<result.size();z++){
            finalResult[z] = result.get(z);
        }
        return finalResult;
    }
}
