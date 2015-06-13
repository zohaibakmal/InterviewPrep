package com.test;

public class CountOnes {

	public int countOnes(int input){
		int count = 0;
		while (input != 0){
			if((input & 1)==1){
				count++;
			}
			input =input>>>1;
		}
		return count;
	}
	
	public static void main(String[] args) {
		CountOnes CO = new CountOnes();
		System.out.println(CO.countOnes(3));

	}

}
