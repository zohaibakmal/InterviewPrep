package com.test;

/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*
* */
public class WordSearch {

    /*
    * Backtracking approach
    *
    * O(4^(n+m))
    * */
    public boolean exist(char[][] board, String word) {
        //We need to maintain a list of previously visited indexes so we don't revisit them in the same search space
        boolean [][] visited = new boolean [board.length][board[0].length];
        boolean rv = false;

        //We start our search from every possible index;
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                rv = rv || exisit(board, i, j , word, 0, visited);
            }
        }
        return rv;

    }

    private boolean exisit(char[][] board, int i, int j, String word, int idx, boolean [][] visited){
        //Base case: If we are able to reach this, then we have found our match
        if (idx == word.length()){
            return true;
        }
        //Base case: If we have reached this, then we haven't found our match
        if (i== board.length ||
                i<0 ||
                j<0 ||
                j==board[i].length ||
                visited[i][j] == true ||
                board[i][j] != word.charAt(idx)){
            return false;
        }

        //Mark the previous as visited
        visited [i][j] = true;
        boolean rv =  exisit(board, i+1, j, word, idx+1,visited) ||
                exisit(board, i, j+1, word, idx+1, visited) ||
                exisit(board, i, j-1, word, idx+1, visited) ||
                exisit(board, i-1, j, word, idx+1, visited);

        //Restart
        visited [i][j] = false;
        return rv;
    }

}
