package com.test;

/*

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

* */

import java.util.Arrays;

public class DecodeWays {
    /*
    * Recursive Way.
    * Space: O(2^n)
    * Time: O(n)
    * */
    public int numDecodingsRecursive(String s) {
        return numDecodings(s,0);
    }

    public int numDecodings(String s, int currentIdx) {

        //Base case: If current index exceeds length, backtrack
        if(currentIdx>s.length()){
            return 0;
        }

        //Base case: If current index equals length, we have traversed the complete string.
        if(currentIdx == s.length()){
            return 1;
        }

        int result=0;
        int plus1 = s.charAt(currentIdx) - '0';
        //If the index is valid, we recurse using the rest of the substring.
        if(plus1<10 && plus1>0){
            result = numDecodings(s, currentIdx+1);
        }

        //If the first two indexes are valid, we recurse using the rest of the substring.
        if(currentIdx+1<s.length()){
            if(s.charAt(currentIdx) =='1' ||
                    (s.charAt(currentIdx) =='2') && s.charAt(currentIdx+1) < '7'){
                result +=  numDecodings(s, currentIdx+2);
            }
        }
        return result;
    }

    /*
     * Memoization
     * Space: O(n)
     * Time: O(n)
     * */
    public int numDecodingsDP(String s) {
        int [] memo = new int[s.length()+1];
        Arrays.fill(memo, -1);
        return numDecodings(s,0, memo);
    }

    public int numDecodings(String s, int currentIdx, int [] memo) {

        //If the result is already recorded, return the result.
        if(memo[currentIdx]>-1){
            return memo[currentIdx];
        }

        //Base case: If current index exceeds length, backtrack
        if(currentIdx>s.length()){
            return 0;
        }

        //Base case: If current index equals length, we have traversed the complete string.
        if(currentIdx == s.length()){
            memo[currentIdx]=1;
            return memo[currentIdx];
        }

        int result=0;
        int plus1 = s.charAt(currentIdx) - '0';
        //If the index is valid, we recurse using the rest of the substring.
        if(plus1<10 && plus1>0){

            result = numDecodings(s, currentIdx+1, memo);
        }

        //If the first two indexes are valid, we recurse using the rest of the substring.
        if(currentIdx+1<s.length()){
            if(s.charAt(currentIdx) =='1' ||
                    (s.charAt(currentIdx) =='2') && s.charAt(currentIdx+1) < '7'){
                result +=  numDecodings(s, currentIdx+2, memo);
            }
        }
        //Record the result
        return memo[currentIdx] = result;
    }

    public static void main(String [] args){
        DecodeWays ways = new DecodeWays();
        System.out.println(ways.numDecodingsRecursive("226"));
    }
}

