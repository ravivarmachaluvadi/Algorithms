package com.example.techiedelight.Algorithms.DynamicProgramming;

class WaysToReachTheBottomRightCornerOfAMatrixWithExactlyKTurnsAllowed
{
    // M x N matrix
    private static final int M = 3;
    private static final int N = 3;
 
    // Function to check whether (i, j) is valid matrix coordinate or not
    public static boolean isValid(int i, int j) {
        return (i >= 0 && i < M && j >= 0 && j < N);
    }
 
    // Recursive function to count number of different ways to reach the last
    // cell (M-1,N-1) of a matrix from the given cell (i,j) with k turns left.
    // isCol flag is true when current direction is along column; false otherwise
 
    public static int totalWays(int i, int j, int k, boolean isCol)
    {
        // if number of turns are exhausted or if the cell is invalid
        if (k == -1 || !isValid(i, j)) {
            return 0;
        }
 
        // if destination is reached with exactly k turns
        if (k == 0 && i == M - 1 && j == N - 1) {
            return 1;
        }
 
        // if the current direction is along column
        if (isCol)
        {
            // 1. continue moving along column
            // 2. turn right and decrement number of turns by 1
 
            return totalWays(i + 1, j, k, isCol) +
                totalWays(i, j + 1, k - 1, !isCol);
        }
 
        // if the current direction is along row
        // 1. continue moving along row
        // 2. turn down and decrement number of turns by 1
 
        return totalWays(i, j + 1, k, isCol) +
            totalWays(i + 1, j, k - 1, !isCol);
    }
 
    // Function to count number of different ways to reach the bottom-right corner
    // of a matrix from its top-left corner with exactly k turns allowed.
    public static int totalWays(int i, int j, int k)
    {
        return totalWays(i + 1, j, k, true) +   // Recur by moving along column
            totalWays(i, j + 1, k, false);      // Recur by moving along row
    }
 
    public static void main(String[] args)
    {
        int k = 2;
        System.out.print("Total number of ways is " + totalWays(0, 0, k));
    }
}