package com.test;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {


	public int lengthOfLongestSubstring(String s) {
		if (s == null)
			return 0;

		Map<Character, Integer> dictionary = new HashMap<Character, Integer>();

		int max = 0;
		int length = 0;

		for (int i = 0; i < s.length(); i++) {
			length++;
			//If found repeating character, check if the character is in the current substring.
			if (dictionary.containsKey(s.charAt(i))&&length>(i-dictionary.get(s.charAt(i))))
				length =i - dictionary.get(s.charAt(i));
				//Get the longest substring.            
				max = Math.max(length, max);
				dictionary.put(s.charAt(i), i);
		}

		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
