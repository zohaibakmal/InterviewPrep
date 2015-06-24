package com.test;
/*
 * Given a non-negative int n, compute recursively (no loops) the count of the occurrences of 8 as a digit, 
 * except that an 8 with another 8 immediately to its left counts double, so 8818 yields 4. Note that mod (%) 
 * by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit 
 * (126 / 10 is 12). 
 * */
public class Count8 {

	public int count8(int n) {
		//base case
		if (n==0) return 0;
		//condition to check if two eights are adjacent
		else if (n%10==8 && (n/10)%10==8) return 2+ count8(n/10);
		//two eights are not adjacent. See if we have an eight
		else if (n%10==8) return 1+ count8(n/10);
		//add nothing to the count
		else return count8(n/10);
	}
}
