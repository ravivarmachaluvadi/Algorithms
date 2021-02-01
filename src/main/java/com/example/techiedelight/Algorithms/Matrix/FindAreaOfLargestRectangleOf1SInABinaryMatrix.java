package com.example.techiedelight.Algorithms.Matrix;

import java.util.Arrays;
 
class FindAreaOfLargestRectangleOf1SInABinaryMatrix
{
    // `M × N` matrix
    private static final int M = 4, N = 5;
 
    // Utility function to replace all non-zero values in a matrix by 1
    public static void resetMatrix(int[][] mat) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] != 0) {
                    mat[i][j] = 1;
                }
            }
        }
    }
 
    // Function to calculate the area of the largest rectangle of 1's where
    // swapping of columns is allowed
    public static int findMaxRectArea(int[][] mat)
    {
        // update the matrix to store the counts of consecutive 1's present
        // in each column
        for (int j = 0; j < N; j++)
        {
            // process each column from bottom to top
            for (int i = M - 2; i >= 0; i--)
            {
                if (mat[i][j] == 1) {
                    mat[i][j] = mat[i+1][j] + 1;
                }
            }
        }
 
        // keep track of the largest rectangle of 1's found so far
        int maxArea = 0;
 
        // traverse each row in the modified matrix to find the maximum area
        for (int i = 0; i < M; i++)
        {
            // create a count array for each row `i`
            int[] count = new int[M + 1];
 
            // process row `i`
            for (int j = 0; j < N; j++)
            {
                if (mat[i][j] > 0)
                {
                    // increment value in the count array using the
                    // current element `mat[i][j]` as an index
 
                    count[mat[i][j]] += 1;
 
                    // the area can be calculated by multiplying the current
                    // element `mat[i][j]` with the corresponding value
                    // in the count array `count[mat[i][j]]`
 
                    maxArea = Integer.max(maxArea, mat[i][j] * count[mat[i][j]]);
                }
            }
        }
 
        // reset matrix before returning
        resetMatrix(mat);
 
        return maxArea;
    }
 
    public static void main(String[] args) {
 
        int[][] mat = {
                { 0, 1, 0, 1, 1 },
                { 1, 1, 0, 0, 1 },
                { 1, 1, 0, 1, 1 },
                { 1, 1, 1, 1, 1 }
        };
 
        System.out.println("The area of the largest rectangle of 1's is "
                        + findMaxRectArea(mat));
    }
}