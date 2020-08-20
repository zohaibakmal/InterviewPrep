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
    public boolean exist2(char[][] board, String word) {
        //We need to maintain a list of previously visited indexes so we don't revisit them in the same search space
        boolean [][] visited = new boolean [board.length][board[0].length];
        boolean rv = false;

        //We start our search from every possible index;
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                rv = rv || exisit2(board, i, j , word, 0, visited);
            }
        }
        return rv;

    }

    private boolean exisit2(char[][] board, int i, int j, String word, int idx, boolean [][] visited){
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
        boolean rv =  exisit2(board, i+1, j, word, idx+1,visited) ||
                exisit2(board, i, j+1, word, idx+1, visited) ||
                exisit2(board, i, j-1, word, idx+1, visited) ||
                exisit2(board, i-1, j, word, idx+1, visited);

        //Restart
        visited [i][j] = false;
        return rv;
    }



    public boolean exist(char[][] board, String word) {
        return exists(board, 0, 0, word, 0);
    }

    private boolean exists(char[][] board, int x, int y, String word, int wordIdx){
        if(x>=board.length || y>=board[x].length || wordIdx>=word.length()){
            return false;
        }
        char curr = board[x][y];
        if(curr==word.charAt(wordIdx)){
            if(wordIdx==word.length()-1){
                return true;
            }
            return exists(board, x, y+1, word, wordIdx+1)
                    || exists(board, x+1, y, word, wordIdx+1);
        }
        return exists(board, x, y+1, word, wordIdx)
                || exists(board, x+1, y, word, wordIdx);

    }

}
