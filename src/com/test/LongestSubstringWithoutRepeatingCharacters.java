package com.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {



	/*
	* Brute force algorithm
	* Runtime: O(n^3)
	* Space: O(k) where k is size of charset or string
	* */
	public int lengthOfLongestSubstringBruteForce(String s) {
		int max = 0;
		for (int i=0; i<s.length(); i++){
			for (int j=i; j<s.length(); j++){
				if (allUnique(s, i, j)){
					max = Math.max(max, j-i+1);
				}
			}
		}
		return max;
	}

	private boolean allUnique (String s, int start, int end){
		HashSet <Character> set = new HashSet <Character>();
		while (end>=start){
			if (set.contains(s.charAt(start))){
				return false;
			}else{
				set.add(s.charAt(start));
			}
			start++;
		}
		return true;
	}




	/*
	* We could define a mapping of the characters to its index.
	* Then we can skip the characters immediately when we found a repeated character.
	*
	* The reason is that if s[j] have a duplicate in the range [i, j) with index j',
	* we don't need to increase i little by little.
	*
	* We can skip all the elements in the range [i, j'] and let i to be j' + 1 directly.
	*
	* */


	public int lengthOfLongestSubstring(String s) {
		if (s == null)
			return 0;

		Map<Character, Integer> dictionary = new HashMap<Character, Integer>();

		int max = 0;
		int start= 0;

		for (int i = 0; i < s.length(); i++) {

			//If found repeating character, check if the character is in the current substring.
			if (dictionary.containsKey(s.charAt(i)))
				start = Math.max(dictionary.get(s.charAt(i)), start);
			//Get the longest substring.
			max = Math.max(i-start+1, max);
			dictionary.put(s.charAt(i), i+1);
		}

		return max;
	}


	/*
	* Sliding Window approach
	*
	* By Using a hashset, see if the new incoming character is in the window.
	* If it is, reduce the window from left.
	* Otherwise, increase the window and check for longest substring
	*
	* Time complexity : O(2n) = O(n). In the worst case each character will be visited twice by start and end.
	* Space complexity : O(min(m, n))
	*
	* */
	public int lengthOfLongestSubstring2(String s) {
		int max = 0;
		int start = 0;
		int end = 0;
		HashSet <Character> set = new HashSet <Character>();

		while (start<s.length() && end<s.length()){
			//Increase the window to the right
			if (!set.contains(s.charAt(end))){
				set.add(s.charAt(end));
				end++;
				max = Math.max(max, end-start);
			}else{
				//Decrease the window from the left.
				set.remove(s.charAt(start));
				start++;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
		l.lengthOfLongestSubstring("abcabcbb");


	}

}
