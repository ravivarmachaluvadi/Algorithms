package com.example.techiedelight.Algorithms.Matrix;

import java.util.Arrays;
 
class InPlaceRotateTheMatrixBy180Degrees
{
    // In-place rotate it by 180 degrees in anti-clockwise direction
    public static void rotateMatrix(int[][] mat)
    {
        int N = mat.length;
 
        // rotate matrix by 180 degrees
        for (int i = 0; i < N /2; i++) {
            for (int j = 0; j < N; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[N - i - 1][N - j - 1];
                mat[N - i - 1][N - j - 1] = temp;
            }
        }
 
        // handle the case when matrix has odd dimentions
        if (N % 2 == 1) {
            for (int j = 0; j < N/2; j++) {
                int temp = mat[N/2][j];
                mat[N/2][j] = mat[N/2][N - j - 1];
                mat[N/2][N - j - 1] = temp;
            }
        }
 
        // print the matrix
        for (int[] r: mat) {
            System.out.println(Arrays.toString(r));
        }
    }
 
    public static void main(String[] args)
    {
        int[][] mat =
        {
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10, 11, 12 },
            { 13, 14, 15, 16 }
        };
 
        rotateMatrix(mat);
    }
}