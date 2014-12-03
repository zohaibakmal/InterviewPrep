package com.test;

import java.util.ArrayList;

public class AllPermutationsStrings {
	public static ArrayList<String> getPermutations(String str){
		if (str == null){
			return null;
		}
		ArrayList<String> permutations = new ArrayList <String>();
		if (str.length()==0){
			permutations.add("");
			return permutations;
		}
		//get the first letter of the string
		char first = str.charAt(0);
		String remainder = str.substring(1);
		
		//backtrack here. Get results of all previous recursions. 
		//insert the char to all possible locations in the word. Add those to the master list
		ArrayList <String> words = getPermutations(remainder);
		for (String word : words){
			for (int j = 0; j<=word.length(); j++){
				String s = insertCharAt(word, first, j);
				permutations.add(s);
			}
		}
		return permutations;
	}
	
	public static String insertCharAt(String word, char c, int i){
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}
/*
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0){ 
	    	System.out.println(prefix);
	    }
	    else {
	        for (int i = 0; i < n; i++){
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	        }
	    }
	}
	*/
	public static void main(String[] args) {
		AllPermutationsStrings ap = new AllPermutationsStrings();
		System.out.println(1/2);
		System.out.println(ap.getPermutations("abc"));
//		permutation("abc");
		
	}

}
