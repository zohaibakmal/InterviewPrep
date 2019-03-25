package com.test;

import java.util.HashSet;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer> row = new HashSet<Integer>();
        HashSet <Integer> column = new HashSet<Integer>();
        HashSet <Integer> cube = new HashSet<Integer>();
        for (int i = 0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(hasDuplicate(row, board[i][j])){
                    return false;
                }

                if(hasDuplicate(column, board[j][i])){
                    return false;
                }
                int rowMulti = 3*(i/3);
                int colMulti = 3*(i%3);

                int rowIndex = rowMulti + j/3;
                int colIndex = colMulti + j%3;
                if(hasDuplicate(cube, board[rowIndex][colIndex])){
                    return false;
                }
            }
            row.clear();
            column.clear();
            cube.clear();

        }
        return true;
    }

    private boolean hasDuplicate (HashSet<Integer> set, char test){
        if(test == '.'){
            return false;
        }
        int item = test - '0';
        if(set.contains(item)){
            return true;
        }
        set.add(item);
        return false;
    }

    public static void main(String [] args){
        char [][]board = new char [][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        ValidSudoku s = new ValidSudoku();
        s.isValidSudoku(board);
    }
}
