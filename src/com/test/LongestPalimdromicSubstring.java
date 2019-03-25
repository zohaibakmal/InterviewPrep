package com.test;

public class LongestPalimdromicSubstring {

    /*
    * In fact, we could solve it in O(n^2) time using only constant space.
    * We observe that a palindrome mirrors around its center.
    * Therefore, a palindrome can be expanded from its center, and there are only 2n - 1 such centers.
    * You might be asking why there are 2n−1 but not n centers? The reason is the center of a palindrome can be in between two letters.
    * Such palindromes have even number of letters (such as "abba") and its center are between the two 'b's.
    *
    * Time: O(n^2)
    * Space: O(1)
    * */


    public String longestPalindrome(String s) {
        String finalString = "";
        for (int i = 0; i< s.length(); i++){
            String substring1 = getPalindrome(s, i, i);
            String substring2 = getPalindrome(s, i, i+1);
            if (substring1.length() > finalString.length()){
                finalString=substring1;
            }
            if (substring2.length() > finalString.length()){
                finalString=substring2;
            }
        }
        return finalString;
    }

    private String getPalindrome (String s, int left, int right){
        while (left>=0 && right < s.length() && (s.charAt(left)== s.charAt(right))){
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }




    /*
    * Check All possible Substrings;
    *
    * Runtime = O(n^3)
    * Space = O (n^2)
    * */

    public String longestPalindromeBruteForce(String s) {
        String finalString = "";
        for (int i = 0; i<s.length(); i++){
            for(int j = i; j<s.length();j++){
                if (isPalindrome(s, i,j)){
                    if (finalString.length()<(j-i+1)){
                        finalString=s.substring(i,j+1);
                    }
                }
            }
        }
        return finalString;
    }

    private boolean isPalindrome (String s, int start, int end){
        while (start<=end){
            if (s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
	public static void main(String[] args) {
        LongestPalimdromicSubstring l = new LongestPalimdromicSubstring();
        System.out.println(l.longestPalindromeBruteForce("babad"));

	}

}
