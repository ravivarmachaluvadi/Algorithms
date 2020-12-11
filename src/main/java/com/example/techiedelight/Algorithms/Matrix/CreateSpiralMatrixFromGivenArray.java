package com.example.techiedelight.Algorithms.Matrix;

import java.util.Arrays;
 
class CreateSpiralMatrixFromGivenArray
{
    private static final int M = 5;
    private static final int N = 5;
 
    private static void printSpiralOrder(int[] arr, int[][] mat)
    {
        int top = 0, bottom = M - 1;
        int left = 0, right = N - 1;
 
        int index = 0;
 
        while (true)
        {
            if (left > right) {
                break;
            }
 
            // print top row
            for (int i = left; i <= right; i++) {
                mat[top][i] = arr[index++];
            }
            top++;
 
            if (top > bottom) {
                break;
            }
 
            // print right column
            for (int i = top; i <= bottom; i++) {
                mat[i][right] = arr[index++];
            }
            right--;
 
            if (left > right) {
                break;
            }
 
            // print bottom row
            for (int i = right; i >= left; i--) {
                mat[bottom][i] = arr[index++];
            }
            bottom--;
 
            if (top > bottom) {
                break;
            }
 
            // print left column
            for (int i = bottom; i >= top; i--) {
                mat[i][left] = arr[index++];
            }
            left++;
        }
    }
 
    // Create Spiral Matrix from given array
    public static void main(String[] args)
    {
        // array of length M*N
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
                16, 17, 18, 19, 20, 21, 22, 23, 24, 25 };
 
        int[][] mat = new int[M][N];
        printSpiralOrder(arr, mat);
 
        for (int[] r: mat) {
            System.out.println(Arrays.toString(r));
        }
    }
}