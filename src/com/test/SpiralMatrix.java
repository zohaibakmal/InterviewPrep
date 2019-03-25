package com.test;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList();
        if (matrix.length==0){
            return result;
        }
        boolean [][] visited = new boolean [matrix.length][matrix[0].length];

        int end =  matrix.length * matrix[0].length;
        int i=0;
        int j =0;
        Direction direction = Direction.RIGHT;
        while(end!=0){
            visited[i][j] = true;
            result.add(matrix[i][j]);
            switch(direction){
                case RIGHT:
                    if(j+1== matrix[0].length || visited[i][j+1]){
                        direction = Direction.DOWN;
                        i++;
                    }else{
                        j++;
                    }
                    break;
                case LEFT:
                    if(j-1 < 0 || visited[i][j-1]){
                        direction = Direction.UP;
                        i--;
                    }else{
                        j--;
                    }
                    break;
                case DOWN:
                    if(i+1 == matrix.length || visited[i+1][j]){
                        direction = Direction.LEFT;
                        j--;
                    }else{
                        i++;
                    }
                    break;
                case UP:
                    if(i-1 < 0 || visited[i-1][j]){
                        direction = Direction.RIGHT;
                        j++;
                    }else{
                        i--;
                    }
                    break;
            }
            end--;
        }
        return result;
    }
    private enum Direction {
        UP,DOWN,LEFT,RIGHT;
    }
}
