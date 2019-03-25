package com.test;


public class SquareRoot {

	public int sqrt(int x) {

		// Do Binary Search for floor(sqrt(x))
		int low = 1, high = x, res=0;
		while(low <= high){
			int middle = (low + high)/2;

			// If x is a perfect square
			if(middle == x/middle ){
				return middle;

			}else if(x/middle< middle){
				high = middle - 1;
			}
			// Since we need floor, we update answer when mid*mid is
			// smaller than x, and move closer to sqrt(x)
			else{
				low = middle + 1;
				res = middle;
			}
		}
		return res;
	}


	int sqrtBruteForce(int x)
	{
		// Base cases
		if (x == 0 || x == 1)
			return x;

		// Staring from 1, try all numbers until
		// i*i is greater than or equal to x.
		int i = 1, result = 1;
		while (result < x)
		{
			if (result == x)
				return result;
			i++;
			result = i*i;
		}
		return i-1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
