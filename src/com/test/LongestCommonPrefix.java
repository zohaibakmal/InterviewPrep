package com.test;

/*
 * Select compare characters at same index across the entire array of strings.  
 * Runtime complexity = O(nm) where n is the length of the array and m is the smallest string.
 * */

public class LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {

		StringBuilder sb = new StringBuilder();

		if (strs==null || strs.length==0){
			return "";
		}

		// Outer loop to select an index and character to compare
		for (int i=0; i<strs[0].length();i++){
			char current=strs[0].charAt(i);
			
			//Inner loop to compare all the current character across all Strings 
			for (String ref:strs){
				//If the current String is smaller than our reference string or the characters don't match.
				if (ref.length()<=i || ref.charAt(i)!=current){
					return sb.toString();
				}
			}
			sb.append(current);
		}

		return sb.toString();
	}


	public static void main(String[] args) {

		String [] array = {"a"};
		longestCommonPrefix(array);
		
	}

}
