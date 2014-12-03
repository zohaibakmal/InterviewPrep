package com.test;

public class SingleNumber {

	public static int singleNumber(int A[], int n) {
	    int result = 0;
	    for (int i = 0; i<n; i++)
	    {
	        result ^=A[i];
	    }
	    return result;
	}
	public static void main(String[] args) {
		int []A = {1,2,1,3,4,3,4};
		System.out.println(singleNumber(A, A.length));
	}

}
