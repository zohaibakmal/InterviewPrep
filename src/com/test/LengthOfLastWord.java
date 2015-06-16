package com.test;

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
