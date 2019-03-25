package com.test;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int[][] copy = new int [board.length][board[0].length];
        for(int i=0; i<copy.length; i++)
            for(int j=0; j<copy[i].length; j++)
                copy[i][j]=board[i][j];

        for(int x=0; x<board.length; x++){
            for(int y=0; y<board[x].length; y++){
                int liveNeighbors = getLiveNeighbours (copy, x, y);
                if(copy[x][y]==1){
                    if(liveNeighbors<2){
                        board[x][y] = 0;
                    }else if(liveNeighbors>3){
                        board[x][y] = 0;
                    }
                }
                if(copy[x][y]==0){
                    if(liveNeighbors==3){
                        board[x][y] = 1;
                    }
                }
            }
        }
    }

    private int getLiveNeighbours (int[][] board, int x, int y){
        //top
        int top=0,bottom=0,left=0,right=0,topLeft=0,topRight=0,bottomLeft=0,bottomRight=0;
        if(y-1>0){
            top = board[x][y-1];
            if(x-1>0){
                topLeft = board[x-1][y-1];
            }
            if(x+1<board.length){
                topRight = board[x+1][y-1];
            }
        }
        if(y+1<board[x].length){
            bottom = board[x][y+1];
            if(x-1>0){
                bottomLeft = board[x-1][y+1];
            }
            if(x+1<board.length){
                bottomRight = board[x+1][y+1];
            }
        }
        if(x-1>0){
            left = board[x-1][y];
        }
        if(x+1<board.length){
            right = board[x+1][y];
        }
        return top+bottom+left+right+topLeft+topRight+bottomLeft+bottomRight;
    }

    public static void main(String [] args){
        GameOfLife game = new GameOfLife();
        game.gameOfLife(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
    }
}
