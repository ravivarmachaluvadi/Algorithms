package com.example.techiedelight.Algorithms.Matrix;

class PrintDiagonalElementsOfTheMatrixHavingPositiveSlope
{
    public static void printMatrixDiagonally(int[][] mat)
    {
        int M = mat.length;
        int N = mat[0].length;
 
        // print "/" diagonal for upper-left half of the matrix
        for (int r = 0; r < M; r++)
        {
            // start from each cell of first column of the matrix
            for (int i = r, j = 0; j < N && i >= 0; i--, j++) {
                System.out.print(mat[i][j] + " ");
            }
 
            System.out.print(System.lineSeparator());
        }
 
        // print "/" diagonal for lower-right half of the matrix
        for (int c = 1; c < N; c++)
        {
            // start from each cell of the last row
            for (int i = M - 1, j = c; j < N && i >= 0; i--, j++) {
                System.out.print(mat[i][j] + " ");
            }
 
            System.out.print(System.lineSeparator());
        }
    }
 
    public static void main(String[] args)
    {
        int[][] mat =
        {
            { 1, 2, 3, 4, 5 },
            { 2, 3, 4, 5, 6 },
            { 3, 4, 5, 6, 7 },
            { 4, 5, 6, 7, 8 },
            { 5, 6, 7, 8, 9 }
        };
 
        printMatrixDiagonally(mat);
    }
}