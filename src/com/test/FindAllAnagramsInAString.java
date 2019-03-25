package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v652420 on 11/2/17.
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

 Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

 The order of output does not matter.

 Example 1:

 Input:
 s: "cbaebabacd" p: "abc"

 Output:
 [0, 6]

 Explanation:
 The substring with start index = 0 is "cba", which is an anagram of "abc".
 The substring with start index = 6 is "bac", which is an anagram of "abc".
 Example 2:

 Input:
 s: "abab" p: "ab"

 Output:
 [0, 1, 2]

 Explanation:
 The substring with start index = 0 is "ab", which is an anagram of "ab".
 The substring with start index = 1 is "ba", which is an anagram of "ab".
 The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagramsInAString {

    /*
    * We use a sliding Window approach.
    *
    * We Maintain two array of hashmaps with character frequencies.
    *
    * pattern hashmap is responsible for finding a target pattern/anagram
    *
    * currentWindow hashmap is responsible for evaluating which characters are present in the current window.
    *
    * 1. We populate our pattern hashmap
    *
    * 2. We populate our first current window.
    *
    * 3. We compare. If the two arrays match, we add to our result.
    *
    * 4. We slide our window. For new entering character, we add to our map. For the leaving character, we subtract.
    *
    * 5. Repeat 3&4 until end is reached.
    *
    * Time: O(n). Comparison is constant because we always traverse through a maximum array of 26 chars
    * Space: O(1). Constant because the space is always number of character long.
    *
    * */
    public List<Integer> findAnagrams(String s, String p) {
        List <Integer> result = new ArrayList<Integer>();

        if (s==null || p==null || s.length()==0 || p.length()==0 || s.length()<p.length()){
            return result;
        }

        // Our currentWindow and Pattern hashmaps.
        int [] currentWindow = new int [26];
        int [] pattern = new int [26];

        // Populate our pattern and the first window
        for (int i = 0; i<p.length();i++){
            pattern[p.charAt(i) - 'a']++;
            currentWindow[s.charAt(i)-'a']++;
        }

        for (int i=p.length(); i<s.length(); i++){
            //Compare the current window with the pattern
            if (compare(currentWindow, pattern)){
                result.add(i-p.length());
            }

            //Update current window by adding the entering character's frequency
            currentWindow[s.charAt(i) - 'a']++;

            //Update the current window by removing the exiting character's frequecy.
            currentWindow[s.charAt(i-p.length()) -'a']--;
        }
        if (compare(currentWindow, pattern)){
            result.add(s.length()-p.length());
        }

        return result;

    }

    public boolean compare (int [] currentWindow, int [] pattern){
        for (int i=0; i<26; i++){
            if (currentWindow[i]!=pattern[i]){
                return false;
            }
        }
        return true;
    }

    /*
    * Instead of compare operation, we maintain count to check when we have a matching pattern.
    * */


    public List<Integer> findAnagramsOptimized(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[26]; //character hash
        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c-'a']++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right++) -'a']-- >= 1) count--;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) list.add(left);

            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() && hash[s.charAt(left++) - 'a']++ >= 0) count++;
        }
        return list;
    }

    public static void main (String [] args){
        FindAllAnagramsInAString fs = new FindAllAnagramsInAString();

        fs.findAnagrams("cbaebabacd", "abc");
    }
}
