package com.test;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseString2 {

	public String reverseWord(String s) {
		StringBuilder reversed = new StringBuilder();
		int j = s.length();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				j = i;
			} else if (i == 0 || s.charAt(i - 1) == ' ') {
				if (reversed.length() != 0) {
					reversed.append(' ');
				}
				reversed.append(s.substring(i, j));
			}
		}
		return reversed.toString();
	}

	String reverseWords2(String input) {
	    Deque<String> words = new ArrayDeque<String>();
	    for (String word: input.split(" ")) {
	        if (!word.isEmpty()) {
	            words.addFirst(word);
	        }
	    }
	    StringBuilder result = new StringBuilder();
	    while (!words.isEmpty()) {
	        result.append(words.removeFirst());
	        if (!words.isEmpty()) {
	            result.append(" ");
	        }
	    }
	    return result.toString();
	}

	
	public static void main(String[] args){
		ReverseString2 t = new ReverseString2();
		//System.out.println(t.inputString);		
		//t.reverse("123456789");
		//System.out.println(t.inputString);	

		System.out.println(t.reverseWord("123456789"));
		System.out.println(t.reverseWord("the sky is blue"));
	}
}
