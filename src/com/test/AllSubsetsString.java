package com.test;

public class AllSubsetsString {
    
	// print all subsets of the characters in s
    public static void comb(String input) { 
    	comb("", input); 
    }

    // print all subsets of the remaining elements, with given prefix 
    private static void comb(String prefix, String input) {
        
    	if ((input.length()==0)){
    		return;
    	}
    	
    	else {
            System.out.println(prefix + input.charAt(0));
            
            comb(prefix + input.charAt(0), input.substring(1));
            
            comb(prefix, input.substring(1));
        }
    }  
	public static void main(String[] args) {
		comb("abc");

	}

}
