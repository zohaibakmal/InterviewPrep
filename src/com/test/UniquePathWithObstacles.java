package com.test;

import java.util.Arrays;

public class UniquePathWithObstacles {
    /*
    * Memoization
    * Space = O(n*m)
    * Time = O(n*m)
    *
    * We use cache to store previously computed results.
    * */
    public int uniquePathsWithObstaclesMemo(int[][] obstacleGrid) {
        int [][] memo = new int [obstacleGrid.length][obstacleGrid[0].length];
        for (int i =0; i<obstacleGrid.length; i++){
            Arrays.fill(memo[i], -1);
        }
        return uniquePathsWithObstacles(obstacleGrid, 0, 0, memo) ;
    }

    private int uniquePathsWithObstacles(int[][] obstacleGrid, int row, int col, int [][] memo) {
        if(row >= obstacleGrid.length || col>=obstacleGrid[0].length){
            return 0;
        }
        if(row==obstacleGrid.length-1 && col==obstacleGrid[0].length-1 && obstacleGrid[row][col]!=1){
            memo[row][col] = 1;
        }
        if(obstacleGrid[row][col] == 1 ){
            memo[row][col]=0;
        }
        if(memo[row][col]!=-1){
            return memo[row][col];
        } else {
            memo[row][col] = uniquePathsWithObstacles(obstacleGrid, row + 1, col, memo) +
                    uniquePathsWithObstacles(obstacleGrid, row, col + 1, memo);
            return memo[row][col];
        }
    }



    /*
    * Recursive Algorithm that uses backtracking;
    *
    * Complexity 2^(n+m)
    * */
    public int uniquePathsWithObstaclesRcr(int[][] obstacleGrid) {
        int [][] memo = new int [obstacleGrid.length][obstacleGrid[0].length];
        for (int i =0; i<obstacleGrid.length; i++){
            Arrays.fill(memo[i], -1);
        }
        return uniquePathsWithObstacles(obstacleGrid, 0, 0) ;
    }

    private int uniquePathsWithObstacles(int[][] obstacleGrid, int row, int col) {
        if(row >= obstacleGrid.length || col>=obstacleGrid[0].length){
            return 0;
        }
        if(row==obstacleGrid.length-1 && col==obstacleGrid[0].length-1 && obstacleGrid[row][col]!=1){
            return 1;
        }
        if(obstacleGrid[row][col] == 1 ){
            return 0;
        }
        return uniquePathsWithObstacles(obstacleGrid, row + 1, col) +
                uniquePathsWithObstacles(obstacleGrid, row, col + 1);
    }

    public static void main(String [] args){
        UniquePathWithObstacles u=new UniquePathWithObstacles();

    }
}
