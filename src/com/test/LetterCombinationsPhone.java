package com.test;

import java.util.ArrayList;
import java.util.List;
//complexity = O(m^n) m=number of mappings, n=digits
public class LetterCombinationsPhone {

	private static final String[] LETTERS = {
		"",       // 0
		"",       // 1
		"abc",    // 2
		"def",    // 3
		"ghi",    // 4
		"jkl",    // 5
		"mno",    // 6
		"pqrs",   // 7
		"tuv",    // 8
		"wxyz"   // 9
	};
	public static List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		result.add("");
		//convert digits to charArray
		for(char c : digits.toCharArray()) {
			String letter = LETTERS[c - '0'];
			if(letter.length() == 0)
				continue;
			List<String> newResult = new ArrayList<String>();
			//get mapping of one digit from the map. Returns us a string
			for(char l : letter.toCharArray()){
				//append each character to results stored previously
				for(String s : result){
					newResult.add(s + l);
				}
			}
			result = newResult;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
	}

}
