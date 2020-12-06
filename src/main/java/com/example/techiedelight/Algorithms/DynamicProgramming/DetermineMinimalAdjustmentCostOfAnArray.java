package com.example.techiedelight.Algorithms.DynamicProgramming;

class DetermineMinimalAdjustmentCostOfAnArray
{
    private static final int M = 100;
 
    // Find minimum adjustment cost of an array
    public static int minimalAdjustmentCost(int[] A, int target)
    {
        // T[i][j] stores minimal adjustment cost on changing A[i] to j
        int[][] T = new int[A.length][M + 1];
 
        // do for each element of the array
        for (int i = 0; i < A.length; i++)
        {
            // replace A[i] to j & calculate minimal adjustment cost T[i][j]
            for (int j = 0; j <= M; j++)
            {
                // separately handle first element of array
                if (i == 0) {
                    T[i][j] = Math.abs(j - A[i]);
                }
                else
                {
                    // initialize minimal adjustment cost to infinity
                    T[i][j] = Integer.MAX_VALUE;
 
                    // consider all k such that k >= max(j - target, 0) and
                    // k <= min(M, j + target) and take minimum
 
                    int k = Integer.max(j - target, 0);
                    while (k <= Integer.min(M, j + target)) {
                        T[i][j] = Integer.min(T[i][j],
                                        T[i - 1][k] + Math.abs(A[i] - j));
                        k++;
                    }
                }
            }
        }
 
        // return minimum value from last row of T[][] table
        int result = Integer.MAX_VALUE;
        for (int j = 0; j <= M; j++) {
            result = Integer.min(result, T[A.length - 1][j]);
        }
 
        return result;
    }
 
    public static void main(String[] args)
    {
        int[] A = { 55, 77, 52, 61, 39, 6, 25, 60, 49, 47 };
        int target = 10;
 
        System.out.println("The minimal adjustment cost is " +
                    minimalAdjustmentCost(A, target));
    }
}