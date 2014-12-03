package com.test;

import java.util.ArrayList;

public class MaximumProductSubarray {

	public int maxProduct(int[] A) {
		if (A.length == 0) {
			return 0;
		}

		int maxPrevious = A[0];
		int minPrevious = A[0];
		int max = A[0];
		int maxCurrent, minCurrent;
		//Max product = +ve Max * +ve Max 
		// Or Max Product = -veMin * -ve Min
		for (int i = 1; i < A.length; i++) {
			maxCurrent = Math.max(Math.max(maxPrevious * A[i], minPrevious * A[i]), A[i]);
			minCurrent = Math.min(Math.min(maxPrevious * A[i], minPrevious * A[i]), A[i]);
			max = Math.max(maxCurrent, max);
			maxPrevious = maxCurrent;
			minPrevious = minCurrent;
		}
		
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
