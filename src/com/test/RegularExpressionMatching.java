package com.test;
/*
 * If the next character of p is NOT ‘*’, then it must match the current character of s. 
 * Continue pattern matching with the next character of both s and p.
 * 
 * If the next character of p is ‘*’, then we do a brute force exhaustive 
 * matching of 0, 1, or more repeats of current character of p… Until we could not match any more characters.
 * */

public class RegularExpressionMatching {

	public static boolean isMatch(String s, String p) {

		if(p.length() == 0)
			return s.length() == 0;

		//p's length 1 is special case    
		if(p.length() == 1 || p.charAt(1) != '*'){
			if(s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
				return false;
			return isMatch(s.substring(1), p.substring(1));    

		}else{ //second character of p is '*'
			int len = s.length();

			int i = -1; 
            // first character of p equals first character of s keep matching
			while(i<len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))){
				if(isMatch(s.substring(i+1), p.substring(2)))
					return true;
				i++;
			}
			return false;
		} 
	}
	public static void main(String[] args) {
		System.out.println(isMatch("abcdcd", "a.*"));

	}

}
