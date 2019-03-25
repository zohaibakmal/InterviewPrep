package com.test;

/*
*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
* */

import java.util.HashMap;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<Character, String>();
        String [] parts = str.split(" ");
        int i=0;
        for (i=0; i<pattern.length() && i<parts.length; i++){
            if(map.containsKey(pattern.charAt(i))){



                if(!map.get(pattern.charAt(i)).equals(parts[i])){
                    return false;
                }
            }else{
                map.put(pattern.charAt(i), parts[i]);
            }
        }
        return i == parts.length;
    }
    public static void main (String [] args){
        WordPattern wordPattern = new WordPattern();
        wordPattern.wordPattern("abba", "dog cat cat dog");
    }
}

