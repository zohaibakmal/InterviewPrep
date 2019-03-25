package com.test;


import java.util.Arrays;

/*
* Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
* */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        return minPathSum(grid, 0, 0);
    }

    public int minPathSum(int[][] grid, int row, int col) {
        if(row >=grid.length || col>=grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(row==grid.length-1 && col==grid[0].length-1){
            return grid[row][col];
        }
        int downMin = minPathSum( grid, row+1, col);
        int rightMin =  minPathSum(grid, row, col+1);
        if(downMin==Integer.MAX_VALUE){
            return rightMin + grid[row][col];
        }
        if(rightMin==Integer.MAX_VALUE){
            return downMin + grid[row][col];
        }
        return Math.min(downMin + grid[row][col], rightMin  + grid[row][col]);
    }



    public int minPathSumMemo(int[][] grid) {
        int [][] memo = new int [grid.length][grid[0].length];
        for (int i =0; i<grid.length; i++){
            Arrays.fill(memo[i], -1);
        }
        return minPathSum(grid, 0, 0, memo);
    }

    public int minPathSum(int[][] grid, int row, int col, int [][] memo) {
        if(row >=grid.length || col>=grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(row==grid.length-1 && col==grid[0].length-1){
            memo[row][col] = grid[row][col];
            return memo[row][col];

        }
        if(memo[row][col]!=-1 || memo[row][col]==Integer.MAX_VALUE){
            return memo[row][col];
        }
        int downMin = minPathSum( grid, row+1, col, memo);
        int rightMin =  minPathSum(grid, row, col+1, memo);
        if(downMin==Integer.MAX_VALUE){
            memo[row][col] = rightMin + grid[row][col];
            return memo[row][col];
        }
        if(rightMin==Integer.MAX_VALUE){
            memo[row][col] = downMin + grid[row][col];
            return memo[row][col];
        }

        memo [row][col] = Math.min(downMin + grid[row][col], rightMin  + grid[row][col]);

        return memo[row][col];

    }

}
