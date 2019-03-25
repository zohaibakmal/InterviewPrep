package com.test;

/**
 * Created by v652420 on 11/15/17.
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 */
public class SearchInRotatedSortedArray {

    /*
    * We can use a modified binary search to solve this.
    *
    * Time: O(log(n)).
    * Space: O(1).
    * */
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end){
            int mid = (start + end) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[start] <= nums[mid]){
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            if (nums[mid] <= nums[end]){
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }


    /*
    *   1.  Find the pivot point and divide the array into two sorted sub-arrays.
    *       Call binary search on the sorted array depending on target.
    *
    *   2.  Compare the first element nums[0] with the target.
    *       a.  If nums[0]> target, call binary search on elements to the right of pivot.
    *       b.  If nums[0] <= target, call binary search on elements to the left of the pivot.
    * */

    public int searchBinaryPivot(int[] nums, int target) {
        int pivot = getPivot(nums);
        if (pivot==-1){
            return binarySearch(nums, 0, nums.length-1, target);
        }else{
            if (nums[pivot]==target){
                return pivot;
            }
            if (target<nums[0]){
                // call binary search on elements to the right of the pivot.
                return binarySearch(nums, pivot+1, nums.length-1, target);
            }else{
                // call binary search on elements to the left of the pivot.
                return binarySearch(nums, 0, pivot, target);
            }
        }
    }

    private int getPivot (int [] nums){
        int low = 0;
        int high = nums.length-1;

        while(low<high){
            int mid = (high+low)/2;
            if (nums[mid]>nums[mid+1]){
                return mid;
            }else{
                if (nums[mid]>=nums[high]){
                    //look in right half
                    low = mid;
                }else{
                    //look in left half
                    high = mid;
                }
            }
        }
        // Array is already sorted so no pivot
        return -1;
    }

    private int binarySearch (int [] nums, int low, int high, int target){
        while(low<=high){
            int mid = (low+high)/2;
            if (nums[mid]==target){
                return mid;
            }else if (nums[mid]>target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        //Can not find element
        return -1;
    }


    public static void main(String [] args){
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        s.search(new int [] {5,1,3},5);
    }
}
