package com.test;

public class ReverseInteger {

	public static int reverse(int x) {
		int reverse=0;
		int x_copy = x;
		int multiplier = 1;

		while (Math.abs(x)>0){
			reverse = reverse * 10 ;
			reverse = reverse + Math.abs(x)%10;
			x = x/10;
			multiplier = multiplier *10;
		}
		if (x_copy*(-1)>0){
			reverse = -1* reverse;
		}
		return reverse;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverse(321);
	}

}
