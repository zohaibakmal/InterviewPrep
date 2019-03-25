package com.test;

/*
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 * */
public class UniquePaths {


    /*
    * Recursive solution:
    *
    * Time: (m+n-2)! / ( (m-1)! * (n-1)! )
    * */
    public int uniquePaths(int m, int n) {
        if (m==1 || n==1){
            return 1;
        }
        return uniquePaths(m-1, n) + uniquePaths(m, n-1);
    }

    /*
    * DP Solution:
    *
    * We use an m*n grid to compute the number of ways to reach a certain cell.
    *
    * Initialize First column and row with 1. Depicting the number of ways to reach the next position.
    * i.e
    *  1 1 1 1 1
    *  1 0 0 0 0
    *  1 0 0 0 0
    *  1 0 0 0 0
    *
    *  Then we compute the number ways to reach a certain cell will the sum of numbers to its top and left.
    *
    *  Time: O(m*n)
    *  Space: O(m*n)
    * */
    public int uniquePathsDP(int m, int n){
        int dp [][] = new int[m][n];
        for (int i=0; i<m; i++){
            dp[i][0] = 1;
        }

        for (int i=0; i<n; i++){
            dp[0][i] = 1;
        }

        for (int i=1; i<m;i++){
            for (int j =1; j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

}
