package com.test;

/**
 * Created by v652420 on 10/25/17.
 *
 * Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

 Example 1:
 Input: 5
 Output: True
 Explanation:
 The binary representation of 5 is: 101
 Example 2:
 Input: 7
 Output: False
 Explanation:
 The binary representation of 7 is: 111.
 Example 3:
 Input: 11
 Output: False
 Explanation:
 The binary representation of 11 is: 1011.
 Example 4:
 Input: 10
 Output: True
 Explanation:
 The binary representation of 10 is: 1010.



 */
public class BinaryNumberWithAlternatingBits {


    /*
    * Intuition and Algorithm
    *
    * We can get the last bit and the rest of the bits via n % 2 and n // 2 operations.
    * Let's remember mod, the last bit of n. If the last bit ever equals the last bit of the remaining, then two adjacent bits have the same value, and the answer is False.
    * Otherwise, the answer is True.
    *
    * Also note that instead of n % 2 and n // 2, we could have used operators n & 1 and n >>= 1 instead.
    *
    * Time Complexity: O(1). For arbitrary inputs, we do O(w) work, where w is the number of bits in n. However, w  <= 32
    * Space complexity: O(1).
    * */

    public boolean hasAlternatingBits(int n) {
        int mod = n%2;
        n = n/2;
        while (n>0){
            if (n%2 == mod){
                return false;
            }else{
                mod = n%2;
                n=n/2;
            }
        }
        return true;
    }

    public static void main(String [] args){
        BinaryNumberWithAlternatingBits b = new BinaryNumberWithAlternatingBits();
        System.out.println(b.hasAlternatingBits(5));
    }
}
