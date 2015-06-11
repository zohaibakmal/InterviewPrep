package com.test;

public class HouseRobberMaximumSumNonAdjacent {
	public int rob(int[] nums) {
		if (nums==null || nums.length==0){
			return 0;
		}
		//first step
        int exclusive = 0;
        int inclusive = nums[0];
        
        for (int i=1; i<nums.length;i++){
        	int temp = inclusive;
        	inclusive = Math.max(exclusive+nums[i], temp); //old inclusive
        	exclusive = temp;
        }
        return inclusive;
    }
	
	public static void main (String [] args){
		HouseRobberMaximumSumNonAdjacent inst = new HouseRobberMaximumSumNonAdjacent();
		
	}
}
