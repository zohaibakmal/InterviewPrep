package com.test;

public class CanJump {
    public boolean canJump(int[] nums) {

        return helper(nums, 0);
    }

    /*
    * Backtracking
    *
    * Try every possible jump from the first position.
    *
    * Time:
    * */
    private boolean helper (int [] nums, int currentIdx){

        //Base case. If last index reached, return true;
        if (currentIdx == nums.length-1){
            return true;
        }

        // figure our how far can we jump from the current index.
        int valueAtCurrent = nums[currentIdx];

        // Since we can't jump to an index that is larger then length of array, we'll limit the jump
        int farthestJump = Math.min(valueAtCurrent + currentIdx, nums.length-1);

        //Figure out the next jump and recurse.
        // If current value is 0, this loop won't execute due to (currentIdx +1)>farthestJump
        for (int nextPosition = currentIdx+1; nextPosition <= farthestJump; nextPosition ++){
            if(helper(nums, nextPosition )){
                return true;
            }
        }
        return false;
    }

    /*
    * Greedy algorithm
    *
    * We can keep track of what is the maximum jump possible from at certain index as we advance through the array..
    *
    * Maximum jump from current = Max(currentValue, maximumAtPrevious-1)
    *
    * Time: O(n)
    * Space: O(1)
    *
    * */
    public boolean canJump2(int[] nums) {
        int maxPossible = 0;
        // We don't go all the way to the end.
        //
        for (int i=0; i<nums.length-1;i++){
            maxPossible = Math.max(nums[i], maxPossible-1);
            if (maxPossible ==0){
                return false;
            }
        }
        return true;
    }


    public static void main(String [] args){
        CanJump canJump = new CanJump();
        canJump.canJump2(new int[]{3,2,1,0,4});
    }
}
