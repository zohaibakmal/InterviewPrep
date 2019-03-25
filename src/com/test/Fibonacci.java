package com.test;

import java.util.Arrays;

public class Fibonacci {

	int count;
	public long printFib(int n){

		 long[] results = new long[n+1];
		    results[1] = 1;
		    results[2] = 1;
		    for (int i = 3; i <= n; i++) {
		        results[i] = results[i-1] + results[i-2];
		    }
		    return results[n];
		
	}

	public long fib(int n, long [] memo){
		if(n==0){
			memo[0] = 0;
			return memo[0];
		}
		if(n==1){
			memo[1] = 1;
			return memo[1];
		}
		if(memo[n]==-1){
			memo[n] = fib(n-1) + fib(n-2);
		}
		return memo[n];
	}

	public long fib(int n){
		if(n==1){
			return 1;
		}
		if(n==0){
			return 0;
		}
		return fib(n-1) + fib(n-2);

	}
	
	
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		int n=10;
		long [] memo = new long [n+1];
		Arrays.fill(memo, -1);

		System.out.println(f.fib(n, memo));
		System.out.println(f.printFib(n));

	}

}
