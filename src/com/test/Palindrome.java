package com.test;

public class Palindrome {

	public boolean isPalindrome(String input){
		
		int start = 0;
		int end = input.length()-1;
		
		while (start<end){
			if(!(input.charAt(start)==input.charAt(end))){
				return false;
			}
			start++;
			end--;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Palindrome pal = new Palindrome();
		System.out.println(pal.isPalindrome("daad"));

	}

}
