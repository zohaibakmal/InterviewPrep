package com.test;

/**
 * Created by v652420 on 11/6/17.
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.


 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int start = 0;
        int end=s.length()-1;
        while(end>start){
            while(!Character.isLetterOrDigit(s.charAt(start)) && end>start){
                start++;
            }
            while(!Character.isLetterOrDigit(s.charAt(end)) && end>start){
                end--;
            }
            if(Character.toLowerCase(s.charAt(start))!=Character.toLowerCase(s.charAt(end))){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String [] args){
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("race a car"));
    }
}
