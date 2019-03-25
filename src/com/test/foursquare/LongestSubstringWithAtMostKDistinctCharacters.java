package com.test.foursquare;

import java.util.HashMap;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        //Store character, repeatCount;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int longestSubstring = 0;
        for(int i = 0; i < s.length(); i++) {
            // character at the right pointer
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            // make sure map size is valid, no need to check left pointer less than s.length()
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            longestSubstring = Math.max(longestSubstring, i - left + 1);
        }
        return longestSubstring;

    }

    public static void main(String [] args){
        LongestSubstringWithAtMostKDistinctCharacters l = new LongestSubstringWithAtMostKDistinctCharacters();
        l.lengthOfLongestSubstringKDistinct("eceba",2);
    }
}
