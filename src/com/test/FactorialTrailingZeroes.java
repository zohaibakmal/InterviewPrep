package com.test;

public class FactorialTrailingZeroes {

	/*
	 * We need to count the number of factors of 5, 25, 125 ...
	 * */
	
	public int trailingZeroes(int n) {
        int zeros = 0;
        while (n>0){
            n=n/5;
            zeros+=n;
        }
        return zeros;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
