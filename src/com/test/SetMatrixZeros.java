package com.test;

/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input:
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output:
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input:
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output:
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
* */

public class SetMatrixZeros {


    public void setZeroesConstantSpace(int[][] matrix) {

        boolean row=false;
        boolean col=false;

        //Determine if first row needs to be zeroed out
        for(int i=0; i<matrix.length;i++){
            if(matrix[i][0]==0){
                row = true;
                break;
            }
        }

        //Determine if first column needs to be zeroed out
        for(int j=0; j<matrix[0].length;j++){
            if(matrix[0][j]==0){
                col = true;
                break;
            }
        }

        //Store info regarding which row/column to zero out in the first row/col
        for (int i=1; i<matrix.length; i++){
            for (int j=1; j<matrix[i].length; j++){
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //Iterate over matrix and determine if the particular position
        //needs to be zeroed by looking at the first row and column
        for (int i=1; i<matrix.length; i++){
            for (int j=1;j<matrix[0].length; j++){
                if(matrix[0][j]==0 || matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }
        }

        //If first row needs to be zeroed, zero it
        if(row){
            for (int i=0; i<matrix.length; i++){
                matrix[i][0] = 0;
            }
        }

        //If second row needs to be zeroed, zero it
        if(col){
            for (int i=0; i<matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }

    }


    public void setZeroesExtraSpace(int[][] matrix) {
        //Store the info of which row needs to be zeroed.
        boolean [] row = new boolean [matrix.length];

        //Store the info of which col needs to be zeroed.
        boolean [] column = new boolean [matrix[0].length];

        //Determine which rows and columns needs to be zeroed out.
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[i].length; j++){
                if(matrix[i][j]==0){
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        //Does the actual work of zeroing by looking at each column and row
        for (int i=0; i<row.length; i++){
            for (int j=0;j<column.length; j++){
                if(column[j]==true||row[i]==true){
                    matrix[i][j]=0;
                }
            }
        }

    }


}
