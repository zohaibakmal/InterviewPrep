package com.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

	/*
	* The naive approach to solve this problem is to use recursion and backtracking.
	* For finding the solution, we check every possible prefix of that string in the dictionary of words.
	* If it is found in the dictionary, then the recursive function is called for the remaining portion of that string.
	* And, if in some function call it is found that the complete string is in dictionary, then it will return true.
	*
	*
	* Time complexity : O(n^n). Consider the worst case where ss = "aaaaaaa" and every prefix of ss is present in the dictionary of words,
	* then the recursion tree can grow upto n^n
	*
	* Space complexity : O(n). The depth of the recursion tree can go upto n.
	* */
	public static boolean wordBreak(String s, Set<String> dict) {
		if (s.length()==0){
			return true;
		}
		
		for (int i=1;i<=s.length();i++){
			if (dict.contains(s.substring(0,i))&&wordBreak(s.substring(i), dict)){
				return true;
			}
		}
		return false;

	}


	/*
	* Memoization solution
	*
	* Time complexity : O(n^2)
	*
	* Space complexity : O(n). The depth of recursion tree can go up to n.
	* */
	public boolean wordBreakMemo(String s, List<String> wordDict) {
		Boolean [] memo = new Boolean [s.length()];
		Arrays.fill(memo, null);
		return wordBreak(s, new HashSet(wordDict), 0, memo);
	}
	public boolean wordBreak(String s, Set<String> wordDict, int start, Boolean [] memo) {
		if(start>=s.length()){
			return true;
		}
		if(memo[start]!=null){
			return memo[start];
		}
		for(int i=start+1; i<=s.length(); i++){
			if(wordDict.contains((s.substring(start, i))) && wordBreak(s, wordDict, i, memo)){
				memo[start] = true;
				return memo[start];
			}
		}
		memo[start] = false;
		return memo[start];
	}




	
	public static boolean wordBreakDP(String s, Set<String> dict) {
		int length = s.length();
	    boolean[] can = new boolean[length+1];
	    can[0] = true;
	    for (int i = 1; i <= length; i++) {
	        for (int j = 0; j < i; j++) {
	            if (can[j] && dict.contains(s.substring(j, i))) {
	                can[i] = true;
	                break;
	            }
	        }
	    }
	    return can[length];

	}


	public static void main(String[] args) {
		Set <String> dict= new HashSet<String>();
		dict.add("leet");
		dict.add("code");

		System.out.println(wordBreakDP("leetcode", dict));
	}

}
