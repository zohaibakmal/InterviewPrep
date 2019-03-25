package com.test;

import java.util.HashMap;

/**
 * Created by v652420 on 10/16/17.

 Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?
 Use a hash table instead of a fixed size counter.
 Imagine allocating a large size array to fit the entire range of unicode characters, which could go up to more than 1 million.
 A hash table is a more generic solution and could adapt to any range of characters.

 *
 *
 *
 */
public class ValidAnagram {


    /*
    * Time complexity : O(n). Time complexity is O(n)) because accessing the counter table is a constant time operation.
    *
    * Space complexity : O(1). Although we do use extra space, the space complexity is O(1) because the table's size stays constant no matter how large n is.
    * */
    public boolean isAnagram(String s, String t) {
        int [] map = new int [26];

        if (t==null || s==null || (t.length()!=s.length())){
            return false;
        }

        for (int i=0; i<t.length();i++){
            map[t.charAt(i) - 'a']++;
            map[s.charAt(i) - 'a']--;
        }

        for (int i=0; i<26;i++){
            if (map[i]!=0){
                return false;
            }
        }

        return true;

    }


    public boolean isAnagramHashMap(String s, String t) {
        HashMap <Character, Integer> map= new HashMap<Character, Integer>();


        if (t==null || s==null || (t.length()!=s.length())){
            return false;
        }

        for (int i=0; i<t.length();i++){
            Integer incrementValue = map.get(t.charAt(i));
            if (incrementValue ==null){
                incrementValue = 0;
            }
            map.put(t.charAt(i), incrementValue + 1);
            Integer decrementValue = map.get(s.charAt(i));
            if (decrementValue==null){
                decrementValue = 0;
            }

            map.put(s.charAt(i), decrementValue - 1);
        }

        for (int value: map.values()){
            if (value!=0){
                return false;
            }
        }

        return true;

    }

    public static void main(String [] args){
        ValidAnagram va = new ValidAnagram();
        System.out.print(va.isAnagramHashMap("abc","cba"));
    }
}
