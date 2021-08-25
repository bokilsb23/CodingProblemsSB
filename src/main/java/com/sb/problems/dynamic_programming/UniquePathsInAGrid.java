package com.sb.problems.dynamic_programming;

public class UniquePathsInAGrid {

    public static void main(String[] args) {
        UniquePathsInAGrid obj = new UniquePathsInAGrid();

        System.out.println(obj.uniquePaths(10,10));
    }

    /**
     * Find unique paths in a grid of AxB size, where you can only move right or down.
     * Problem is solved using dynamic programming, we find unique paths to columns starting from 0,0 and
     * use these results to calculate number of paths of further columns.
     * @param A - number of rows in grid
     * @param B - number of columns in grid
     * @return - number of unique paths from 0,0 -> A-1,B-1 (1,1->A,B)
     */
    private int uniquePaths(int A, int B) {
        int pathCount[][] = new int[A][B];


        for(int i = 0; i < A; i++) {
            pathCount[i][0] = 1;
        }

        for(int j = 0; j < B; j++) {
            pathCount[0][j] = 1;
        }

        for(int i = 1; i < A; i++) {
            for(int j = 1; j < B; j++) {
                pathCount[i][j] = pathCount[i-1][j] + pathCount[i][j-1];
            }
        }
        return pathCount[A-1][B-1];
    }
}
