package com.example.techiedelight.Algorithms.Matrix;

class ReportAllOccurrencesOfAnElementInRowWiseAndColumnWiseSortedMatrixInLinearTime
{
    public static void findElement(int[][] mat, int key)
    {
        // M x N matrix
        int M = mat.length;
        int N = mat[0].length;
 
        // start from (0, N-1) i.e. top-rightmost cell of matrix
        int i = 0, j = N - 1;
 
        // run till matrix boundary is reached
        while (i <= M - 1 && j >= 0)
        {
            // if curr element is less than the key, increment row index
            if (mat[i][j] < key)
                i++;
 
                // if curr element is more than the key, decrement col index
            else if (mat[i][j] > key)
                j--;
 
            else    // curr element is equal to the key
            {
                System.out.println("Element " + key + " found at position ("
                        + i + ", " + j + ")");
 
                i++; j--;
            }
        }
    }
 
    public static void main(String[] args)
    {
        int[][] mat =
        {
            { -4, -3, -1,  3,  5 },
            { -3, -2,  2,  4,  6 },
            { -1,  1,  3,  5,  8 },
            {  3,  4,  7,  8,  9 }
        };
 
        findElement(mat, 3);
    }
}