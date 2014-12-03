package com.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/*
 * Maintain a hashmap of all the values
 * Look up consecutive numbers in the hashmap.
 * Maintain Length throughout
 * */
public class LongestConsecutiveSequence {

	HashMap <Integer, Boolean> map = new HashMap<Integer, Boolean>();

	public int longestConsecutive(int[] num) {

		for (int n:num){
			map.put(n,true);
		}

		int maxLength = 0;
		int len=0;

		for (int n:num){
			if (map.containsKey(n)){
				map.remove(n);
				len = 1;
				len += findConsecutive(n-1,-1);
				len += findConsecutive(n+1,1);
			}
			if (len>maxLength){
				maxLength = len;    
			}

			len = 0;
		}
		return Math.max(maxLength, len);
	}

	public int findConsecutive(int num, int direction){

		int length = 0;
		while (map.containsKey(num)){
			length++;
			map.remove(num);
			num = num + direction;
		}
		return length;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
