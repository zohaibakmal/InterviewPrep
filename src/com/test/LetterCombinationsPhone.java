package com.test;

import java.util.ArrayList;
import java.util.List;
//complexity = O(m^n) m=number of mappings, n=digits
public class LetterCombinationsPhone {

	private String[] LETTERS = {
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

	public List<String> letterCombinations(String digits) {

		List<String> res = new ArrayList<>();
		if (digits.length()==0){
			return res;
		}
		StringBuilder temp = new StringBuilder();
		combination(temp, digits, 0, res);
		return res;
	}

	private void combination(StringBuilder prefix, String digits, int idx, List<String> res) {
		if (idx < digits.length()) {
			for (int i=0; i<LETTERS[digits.charAt(idx)-'0'].length(); i++) {
				prefix.append(LETTERS[digits.charAt(idx) - '0'].charAt(i));
				combination(prefix, digits, idx+1, res);
				prefix.deleteCharAt(prefix.length()-1);
			}
		} else {
			res.add(prefix.toString());
		}
	}








	public List<String> letterCombinations1(String digits) {
		List<String> res = new ArrayList<>();
		combine("", digits, 0, res);
		return res;
	}

	private void combine (String prefix, String digits, int digitIdx, List <String> result){
		if (digitIdx==digits.length()){
			result.add(prefix);
			return;
		}
		for (int i=0; i<LETTERS[digits.charAt(digitIdx)-'0'].length();i++){
			combine(prefix+LETTERS[digits.charAt(digitIdx)-'0'].charAt(i), digits, digitIdx+1, result);
		}
	}


	/*
	* We maintain a temporary result set.
	*
	* For each result, we append to it the characters of the digit map.
	*
	* E.g. at the beginning, the result set is "". This is because, we need a starting string to append to.
	*
	* As we traverse the string, we take whatever was stored in the previous result set and append possible character map.
	* E.g. if our digit was 24, we would start out with "".
	*
	* For each value mapped to 2, we append the value to "" and add it the result set.
	* "" + a = a
	* "" + b = b
	* "" + c = c
	*
	* When we move to 4, our result set is [a,b,c].
	*
	* For each entry in the result set, we now append 4's mapping characters.
	* a+ "d" = ad
	* a+ "e" = ae
	* a+ "f" = af
	*
	* Similarly for b and c.
	*
	* Let m = max possible digits mapped to a letter. n = number of digits
	* Time : O(m^n) or O(4^n).
	* Space: m^n. 4^n
	*
	* */

	public List<String> letterCombinationsItr(String digits) {

		List <String> result = new ArrayList<String>();

		if (digits.length()==0){
			return result;
		}else{
			//To give a starting point to our result set so we have a previous set to work on.
			result.add("");
		}

		for (int i=0; i<digits.length(); i++){
			String charMap = LETTERS[ digits.charAt(i)-'0' ];

			// This will store the new results as we do work on the previous result set.
			List <String> newResult = new ArrayList<String>();


			for (int j=0; j<charMap.length();j++){

				// For each value in the previous result set, we add the char map and add the new value to the new set.
				for (String s:result){
					s += charMap.charAt(j);
					newResult.add(s);
				}
			}
			// update the previous resultset with new.
			result = newResult;
		}
		return result;
	}
	
	public static void main(String[] args) {
		LetterCombinationsPhone l = new LetterCombinationsPhone();
		l.letterCombinations("234");
	}

}
