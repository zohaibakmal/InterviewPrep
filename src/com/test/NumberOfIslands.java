package com.test;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int result = 0;
        for(int row=0; row<grid.length; row++){
            for(int col=0; col<grid[0].length; col++){
                if(grid[row][col]=='1'){
                    result++;
                    visit(grid, row, col);
                }
            }
        }
        return result;
    }

    private void visit(char[][] grid, int row, int col){
        if(row<0 || col<0 ||
                row>=grid.length || col>=grid[0].length ||
                grid[row][col]=='0'){
            return;
        }
        grid[row][col] = '0';
        visit(grid, row+1,col);
        visit(grid, row-1,col);
        visit(grid, row,col+1);
        visit(grid, row,col-1);
    }
}
