package com.test;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

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
