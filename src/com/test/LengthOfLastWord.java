package com.test;
/*
* Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
* If the last word does not exist, return 0.
*
* Note: A word is defined as a character sequence consists of non-space characters only.
*
* For example,
* Given s = "Hello World",
* return 5.
*
* Time: O(n)
* */
public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {
        int stringLength = s.length()-1;
        int lastLength = 0;
        
        //eliminates white spaces at the end.   
        while (stringLength >= 0 && s.charAt(stringLength)==' '){
        	stringLength--;
        }
        //count number of characters until we hit a whitespace or we have reached the start of the start
        while (stringLength >= 0 && s.charAt(stringLength)!=' '){
        	lastLength++;
        	stringLength--;
        }
        return lastLength;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
