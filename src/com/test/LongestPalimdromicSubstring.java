package com.test;

public class LongestPalimdromicSubstring {
	
	public static String longestPalindrome(String s) {
        if (s==null || s.length()==0){
            return s;
        }
        String substring="";
        for (int i=0; i<s.length();i++){
            String sub = getPalindrome(s, i, i);
            if (sub.length()>substring.length()){
                substring = sub;
            }
            sub = getPalindrome(s, i, i+1);
            if (sub.length()>substring.length()){
                substring = sub;
            }
        }
        return substring;
    }
    
    public static String getPalindrome(String s, int start, int end){
        while (start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            start--; end++;
        }
        return s.substring(start+1, end);
    }
    
	public static void main(String[] args) {
			System.out.println(longestPalindrome("a"));

	}

}
