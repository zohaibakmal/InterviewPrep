package com.test;

import java.util.HashMap;
import java.util.Hashtable;
/*
 * The idea is mainly based on the help of two pointers (begin and end position of the window) 
 * and two tables (needToFind and hasFound) while traversing S. needToFind stores the total count 
 * of a character in T and hasFound stores the total count of a character met so far. We also use 
 * a count variable to store the total characters in T that�s met so far (not counting characters 
 * where hasFound[x] exceeds needToFind[x]). When count equals T�s length, we know a valid window is found.
 * 
 * Firstly, we will move the �end� pointer right, until we find all characters. 
 * When we move pointer �end�, we will check if the number of this character is smaller than we need to found. 
 * If it is, we will increase one to a total counter and increase one to the number of this character. 
 * Otherwise only the number of this character is increased.
 * 
 * O(N)
 * */
public class MinimumWindowString {


	public String minWindow(String S, String T) {
		//Need to find
		HashMap<Character, Integer> dict = new HashMap<>();
		//Has Found
		HashMap<Character, Integer> found = new HashMap<>();
		// total number of characters met so far
		int foundCounter = 0;
		int start = 0;
		int end = 0;
		
		//for populating our dictionary
		for (int i = 0; i < T.length(); i++) {
			char c = T.charAt(i);
			if (!dict.containsKey(c))
				dict.put(c, 1);
			else
				dict.put(c, dict.get(c) + 1);
		}
		

		int min = Integer.MAX_VALUE;
		String minWindow = "";
		while (end < S.length()) {
			char c = S.charAt(end);
			if (dict.containsKey(c)) {
				if (found.containsKey(c)) {
					if (found.get(c) < dict.get(c))
						foundCounter++;
					found.put(c, found.get(c) + 1);
				} else {
					found.put(c, 1);
					foundCounter++;
				}
			}
			if (foundCounter == T.length()) {
				//When foundCounter equals to T.length(), in other words, found all characters.
				char sc = S.charAt(start);
				while (!found.containsKey(sc) || found.get(sc) > dict.get(sc)) {
					if (found.containsKey(sc) && found.get(sc) > dict.get(sc))
						found.put(sc, found.get(sc) - 1);
					start++;
					sc = S.charAt(start);
				}
				if (end - start + 1 < min) {
					minWindow = S.substring(start, end + 1);
					min = end - start + 1;
				}
			}
			end++;
		}
		return minWindow;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
