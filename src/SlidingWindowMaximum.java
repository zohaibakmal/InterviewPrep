import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int max=nums[0];
        LinkedList<Integer> queue = new LinkedList();
        int [] result = new int [nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            int current = nums[i];
            if(queue.size()==0){
                max = current;
            }else if(queue.size()==k){
                int exitingValue = queue.remove();
                if(exitingValue==max){
                    max = queue.peek();
                }
            }
            max = Math.max(current, max);
            queue.add(max);
            if(queue.size()==k){
                result[i-(k-1)] = max;
            }
        }
        return result;
    }
    public static void main(String [] args){
        SlidingWindowMaximum s = new SlidingWindowMaximum();
        s.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
    }
}
