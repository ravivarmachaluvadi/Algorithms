package com.example.techiedelight.Algorithms.Matrix;

class PrintASpiralSquareMatrixWithoutUsingAnyExtraSpace
{
    // Function to prints a N x N spiral matrix without using any extra space
    // The matrix contains numbers from 1 to N x N
    public static void printSpiralMatrix(int N)
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                // x stores the layer in which (i, j)'th element lies
                int x;
 
                // find minimum of four inputs
                x = Math.min(Math.min(i, j), Math.min(N - 1 - i, N - 1 - j));
 
                // print upper right half
                if (i <= j) {
                    System.out.print((N - 2*x) * (N - 2*x) - (i - x) - (j - x));
                }
                // print lower left half
                else {
                    System.out.print((N - 2*x - 2) * (N - 2*x - 2) + (i - x) + (j - x));
                }
 
                System.out.print('\t');
            }
 
            System.out.println();
        }
    }
 
    public static void main(String[] args)
    {
        int N = 5;
        printSpiralMatrix(N);
    }
}