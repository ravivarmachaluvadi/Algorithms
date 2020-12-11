package com.example.techiedelight.Algorithms.Matrix;

import java.util.Arrays;
 
class ReplaceAllOccurrencesOf0ThatAreNotSurroundedBy1InABinaryMatrix
{
    // M x N matrix
    private static final int M = 10;
    private static final int N = 10;
 
    // Below arrays details all 8 possible movements
    private static final int[] row = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] col = {-1, 0, 1, -1, 1, -1, 0, 1};
 
    // check false if (x, y) is not a valid location
    private static boolean isValid(int x, int y) {
        return (x >= 0 && x < M && y >= 0 && y < N);
    }
 
    private static void DFS(int[][] mat, int x, int y) {
        // replace 0 by 1
        mat[x][y] = 1;
 
        // process all 8 adjacent locations of current cell and
        // recur for each valid location
        for (int k = 0; k < 8; k++) {
            int i = x + row[k];
            int j = y + col[k];
 
            // if the adjacent location at position (i, j) is
            // a valid location and has value 0
            if (isValid(i, j) && mat[i][j] == 0) {
                DFS(mat, i, j);
            }
        }
    }
 
    private static void replaceZeroes(int[][] mat) {
        // check every element on first and last column of the matrix
        for (int i = 0; i < M; i++) {
            if (mat[i][0] == 0) {
                DFS(mat, i, 0);
            }
            if (mat[i][N - 1] == 0) {
                DFS(mat, i, N - 1);
            }
        }
 
        // check every element on first and last row of the matrix
        for (int j = 0; j < N - 1; j++) {
            if (mat[0][j] == 0) {
                DFS(mat, 0, j);
            }
 
            if (mat[M - 1][j] == 0) {
                DFS(mat, M - 1, j);
            }
        }
    }
 
    public static void main(String[] args) {
        int[][] mat =
        {
            { 1, 1, 1, 1, 0, 0, 1, 1, 0, 1 },
            { 1, 0, 0, 1, 1, 0, 1, 1, 1, 1 },
            { 1, 0, 0, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 0, 0, 1, 1, 0, 1 },
            { 1, 1, 1, 1, 0, 0, 0, 1, 0, 1 },
            { 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
            { 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 0, 1, 1, 0, 0, 1, 0, 1 },
            { 1, 1, 1, 0, 1, 0, 1, 0, 0, 1 },
            { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }
        };
 
        replaceZeroes(mat);
 
        for (int[] r: mat) {
            System.out.println(Arrays.toString(r));
        }
    }
}