
package com.test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


/*
Given a N X N matrix (M) filled with 1 , 0 , 2 , 3 .
Find the minimum numbers of moves needed to move from source to destination (sink).
While traversing through blank cells only.
You can traverse up, down, right and left.
A value of cell 1 means Source.
A value of cell 2 means Destination.
A value of cell 3 means Blank cell.
A value of cell 0 means Blank Wall.
Note : there is only single source and single destination.
They may be more than one path from source to destination(sink).each move in matrix we consider as ‘1’
* */

public class SearchMazeBFS {



    // BFS to find the shortest path between
    // a given source cell to a destination cell.

    // These arrays are used to get row and column
    // numbers of 4 neighbors of a given cell
    int [][] positions = new int [][] {{-1,0}, {0,-1}, {1,0}, {0,1}};

    int BFS(int mat[][], Cell src, Cell dest) {

        boolean[][] visited = new boolean[mat.length][mat[0].length];

        HashMap<Cell, Cell> prev = new HashMap<>();


        // Mark the source cell as visited
        visited[src.x][src.y] = true;

        // Create a queue for BFS
        LinkedList<Cell> q = new LinkedList();

        q.add(src); // Enqueue source cell
        prev.put(src, null);

        // Do a BFS starting from source cell
        while (!q.isEmpty()) {
            //dequeue the front cell in the queue and enqueue its adjacent cells
            Cell curr = q.poll();

            // If we have reached the destination cell,
            // we are done
            if (curr.x == dest.x && curr.y == dest.y){
                List <Cell> path = getPath(prev, dest);

                return curr.dist;
            }


            for (int i = 0; i < 4; i++) {

                //Determine new direction
                int row = curr.x + positions[i][0];
                int col = curr.y + positions[i][1];

                // if direction is valid, has path and not visited yet, enqueue it.
                if ((isValid(mat, row, col) && mat[row][col] == 1) && !visited[row][col]) {
                    // mark cell as visited and enqueue it
                    visited[row][col] = true;
                    Cell adjCell = new Cell(row, col);
                    adjCell.dist =curr.dist + 1;
                    prev.put(adjCell,curr);
                    q.add(adjCell);
                }
            }
        }

        // return -1 if destination cannot be reached
        return Integer.MAX_VALUE;
    }

    private List<Cell> getPath(HashMap <Cell, Cell> prev, Cell dest){
        List<Cell> result = new ArrayList<>();
        getPathHelper(prev, dest, result);
        return  result;
    }

    private void getPathHelper(HashMap <Cell, Cell> prev, Cell curr, List<Cell> path){
        if(prev.get(curr)==null){
            return;
        }
        path.add(prev.get(curr));
        getPathHelper(prev, prev.get(curr), path);
    }


    boolean isValid(int [][] maze, int x, int y) {
        // return true if row number and column number
        // is in range
        return (((x>= 0) && (x< maze.length)) && ((y >= 0) && (y< maze[0].length)));
    }

    // class to store matrix cell coordinates and its distances
    static class Cell {
        int x;
        int y;
        int dist;
        public Cell (int x, int y){
            this.x = x;
            this.y = y;
            this.dist = 0;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + this.x;
            result = 31 * result + this.y;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            return this.x == ((Cell) obj).x && this.y == ((Cell) obj).y;
        }
    }

    // Driver program to test above function
    public static void main(String[] args) {
        SearchMazeBFS smbfs = new SearchMazeBFS();
        int[][] mat = new int[][] {
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                { 1, 0, 0, 0, 0, 1, 0, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }
        };

        Cell source = new SearchMazeBFS.Cell(0, 0);
        Cell dest = new SearchMazeBFS.Cell(3, 4);

        int dist = smbfs.BFS(mat, source, dest);

        if (dist != Integer.MAX_VALUE)
            System.out.println("Shortest Path is " + dist);
        else
            System.out.println("Shortest Path doesn't exist");

    }
}