package com.example.techiedelight.Algorithms.Matrix;

class CountNegativeElementsPresentInSortedMatrixInLinearTime
{
    public static int count(int[][] mat)
    {
        // M x N matrix
        int M = mat.length;
        int N = mat[0].length;
 
        // variable to store negative number count
        int negative = 0;
 
        // start from (0, N-1) i.e. top-rightmost cell of matrix
        int i = 0, j = N - 1;
 
        // run till matrix boundary is reached
        while (i <= M - 1 && j >= 0)
        {
            // if current element is negative
            if (mat[i][j] < 0)
            {
                negative += j + 1;    // increment the negative count
                i++;    // move to next row
            }
            else j--;    // move to cell to the left
        }
 
        // return negative number count
        return negative;
    }
 
    public static void main(String[] args)
    {
        int[][] mat =
        {
            { -7, -3, -1, 3, 5 },
            { -3, -2,  2, 4, 6 },
            { -1,  1,  3, 5, 8 },
            {  3,  4,  7, 8, 9 }
        };
 
        System.out.print("Total number of negative elements present are "
                    + count(mat));
    }
}