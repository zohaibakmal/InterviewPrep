package com.test;

public class Pow {

	
	/*
	 * Divide the problem into sub-problems of size n/2.
	 * E.g. x*x*x*x will be evaluated as (x*x) * (x*x)
	 * */
	
	public double pow(double x, int n) {
		if (n < 0) {
			return 1 / power(x, n);
		} else {
			return power(x, n);
		}
	}
	
	public double power(double x, int n) {
		if (n == 0)
			return 1;
	 
		// storing the value here to make the code efficient
		// we would only need to calculate the value for one sub-problem.
		// the other sub-problem (which will be exactly the same) can use this result.
		double val = power(x, n / 2);
	 
		if (n % 2 == 0) {
			return val * val;
		} else {
			return val * val * x;
		}
	}
	 	
	public static void main(String[] args) {
		Pow p = new Pow();
		System.out.println(p.pow(2, -2));

	}

}
