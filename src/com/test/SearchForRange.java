package com.test;

public class SearchForRange {

	public int[] searchRange(int[] A, int target) {
	    int index = binarySearch(A, 0, A.length-1, target);
	    int[] result = {-1, -1};
	    if (index != -1) {
	        int left  = index;
	        int right = index;
	        result[0] = left;
	        result[1] = right;
	        while ((left  = binarySearch(A, 0, left-1, target)) != -1)
				result[0] = left;
	        while ((right = binarySearch(A, right+1, A.length-1, target)) != -1) result[1] = right;
	    }
	    return result;
	}

	private int binarySearch(int[] A, int lo, int hi, int target) {
	    while (lo <= hi) {
	        int mid = lo + (hi - lo) / 2;
	        if (A[mid] < target)
	        	lo = mid + 1;
	        else if (A[mid] > target)
	        	hi = mid - 1;
	        else
	        	return mid;
	    }
	    return -1;
	}



	/*
	* 	We do two types of modified binary search.
	* 	1.	Find start of range on the left side.
	* 	2. 	Find end of range to the right side.
	*
	*  	Our modified binary search for left side works as below:
	*  	a.	nums[mid] == target. Our left index lies either at mid or further at left.
	*  	b. 	nums[mid] > target. Look on the left of mid.
	*  	c. 	nums[mid] < target. Look to the right.
	*
	*  	We can combine a and b since they both favor left
	*
	* 	The Search will terminate when low==high and will converge on the left most element.
	*
	*  	Our modified binary search for right side works as below:
	*  	a.	nums[mid] == target. Our right index lies either at mid or further to the right.
	*  	b. 	nums[mid] > target. Look on the left of mid.
	*  	c. 	nums[mid] < target. Look to the right.
	*
	*  	We can combine a and c since they both favor right.
	*
	*  	Plus we add 1 to mid = (low+high)/2 so our mid also favors left.
	*
	* */
	public int[] searchRange2(int[] nums, int target) {
		//search for left
		int low = 0;
		int high = nums.length-1;
		int [] result = {-1,-1};

		if (nums.length==0){
			return result;
		}

		while (low<high){
			int mid = (low+high)/2;
			//look to the right
			if (nums[mid]<target){
				low = mid+1;
			}
			//look to the left. combined the case of 1.a and 1.b
			else{
				high = mid;
			}
		}
		if (nums[low]!=target){
			return result;
		}else{
			result[0]=low;
		}
		high = nums.length-1;
		while (low<high){
			int mid = (low+high)/2 +1;
			if (nums[mid]>target){
				high = mid-1;
			}else{
				low = mid;
			}
		}
		result[1]=high;
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
