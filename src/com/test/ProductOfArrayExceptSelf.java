package com.test;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0, tmp = 1; i < nums.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }
        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }


    /*
     *
     *  Your expected result is (a[0]*....*a[i-1])*(a[i+1]*....*a[n-1]),
     *  namely the product of all items to the left of a[i] multiplied by the product of all items to the right of a[i].
     *
     *  In the left[] array, you store the product of everything to the left of a[i] as follows:
     *  left[i-1] contains the product of everything to the left of a[i-1] = a[0]*....*a[i-2].
     *  So left[i] should be that multiplied by a[i-1].
     *
     *  You repeat the same for everything on the right. Then you multiply left[i]*right[i] to get the result[i], for every i.
    * */
    public int[] productExceptSelf2(int[] nums) {

        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        int result[] = new int[nums.length];


        /* Left most element of left array is always 1 */
        left[0] = 1;

        /* Rightmost most element of right array is always 1 */
        right[nums.length - 1] = 1;

        /* Construct the left array */
        for (int i = 1; i < nums.length; i++)
            left[i] = nums[i - 1] * left[i - 1];

        /* Construct the right array */
        for (int j = nums.length - 2; j >= 0; j--)
            right[j] = nums[j + 1] * right[j + 1];

        /* Construct the product array using
           left[] and right[] */
        for (int i = 0; i < nums.length; i++)
            result[i] = left[i] * right[i];

        return result;
    }

    public static void main(String [] args){
        ProductOfArrayExceptSelf p = new ProductOfArrayExceptSelf();
        p.productExceptSelf(new int[]{1,2,3,4});
    }
}
