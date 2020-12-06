package com.example.techiedelight.Algorithms.DynamicProgramming;

import java.util.concurrent.atomic.AtomicInteger;
 
class FindSizeOfLargestSquareSubMatrixOf1SPresentInGivenBinaryMatrix
{
    // Function to find the size of largest square sub-matrix of 1's
    // present in the given binary matrix
    public static int findLargestSquare(int[][] M, int m, int n, AtomicInteger max_size)
    {
        // base condition
        if (m == 0 || n == 0) {
 
            if (max_size.get() != 0) {
                max_size.set(Integer.max(max_size.get(), M[m][n]));
                return M[m][n];
            }
    
            for (int i = 0; i <= m; i++) {
                if (M[i][n] == 1) {
                    max_size.set(1);
                    break;
                }
            }
    
            for (int j = 0; j <= n; j++) {
                if (M[m][j] == 1) {
                    max_size.set(1);
                    break;
                }
            }
    
            return max_size.get();
        }
 
        // find largest square matrix ending at M[m][n-1]
        int left = findLargestSquare(M, m, n - 1, max_size);
 
        // find largest square matrix ending at M[m-1][n]
        int top = findLargestSquare(M, m - 1, n, max_size);
 
        // find largest square matrix ending at M[m-1][n-1]
        int diagonal = findLargestSquare(M, m - 1, n - 1, max_size);
 
        // largest square matrix ending at M[m][n] will be 1 plus
        // minimum of largest square matrix ending at M[m][n-1],
        // M[m-1][n] and M[m-1][n-1]
 
        int size = 0;
        if (M[m][n] != 0) {
            size = 1 + Integer.min(Integer.min(top, left), diagonal);
        }
 
        // update maximum size found so far
        max_size.set(Integer.max(max_size.get(), size));
 
        // return the size of largest square matrix ending at M[m][n]
        return size;
    }
 
    public static void main(String[] args)
    {
        int[][] M =
        {
            { 0, 0, 1, 0, 1, 1 },
            { 0, 1, 1, 1, 0, 0 },
            { 0, 0, 1, 1, 1, 1 },
            { 1, 1, 0, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1 },
            { 1, 1, 0, 1, 1, 1 },
            { 1, 0, 1, 1, 1, 1 },
            { 1, 1, 1, 0, 1, 1 }
        };
 
        // size stores the size of largest square sub-matrix of 1's
        // and it is passed by reference using AtomicInteger
        AtomicInteger max_size = new AtomicInteger();
 
        findLargestSquare(M, M.length - 1, M[0].length - 1, max_size);
        System.out.print("The size of largest square sub-matrix of 1's is " + max_size.get());
    }
}





class FindSizeOfLargestSquareSubMatrixOf1SPresentInGivenBinaryMatrixA2
{
    public static int minimum (int x, int y, int z) {
        return Integer.min(Integer.min(x, y), z);
    }

    // Function to find the size of largest square sub-matrix of 1's
    // present in the given binary matrix
    public static int findLargestSquare(int[][] M)
    {
        // T[i][j] stores the size of maximum square
        // sub-matrix ending at M[i][j]
        int[][] T = new int[M.length][M[0].length];

        // max stores the size of largest square sub-matrix of 1's
        int max = 0;

        // fill in bottom-up manner
        for (int i = 0; i < M.length; i++)
        {
            for (int j = 0; j < M[0].length; j++)
            {
                T[i][j] = M[i][j];

                // if we are not at the first row or first column and
                // current cell has value 1
                if (i > 0 && j > 0 && M[i][j] == 1)
                {
                    // largest square sub-matrix ending at M[i][j] will be
                    // 1 plus minimum of largest square sub-matrix
                    // ending at M[i][j-1], M[i-1][j] and M[i-1][j-1]

                    T[i][j] = minimum(T[i][j - 1], T[i - 1][j],
                            T[i - 1][j - 1]) + 1;
                }

                // update maximum size found so far
                if (max < T[i][j]) {
                    max = T[i][j];
                }
            }
        }

        // return size of largest square matrix
        return max;
    }

    public static void main(String[] args)
    {
        // input boolean matrix
        int mat[][] =
                {
                        { 0, 0, 1, 0, 1, 1 },
                        { 0, 1, 1, 1, 0, 0 },
                        { 0, 0, 1, 1, 1, 1 },
                        { 1, 1, 0, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 0, 1, 1, 1 },
                        { 1, 0, 1, 1, 1, 1 },
                        { 1, 1, 1, 0, 1, 1 }
                };

        System.out.print("The size of largest square sub-matrix of 1's is " +
                findLargestSquare(mat));
    }
}