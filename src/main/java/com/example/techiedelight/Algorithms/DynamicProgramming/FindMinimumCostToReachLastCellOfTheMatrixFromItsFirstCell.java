package com.example.techiedelight.Algorithms.DynamicProgramming;

class FindMinimumCostToReachLastCellOfTheMatrixFromItsFirstCell
{
    // Naive recursive function to find the minimum cost to reach
    // cell (m, n) from cell (0, 0)
    public static int findMinCost(int[][] cost, int m, int n)
    {
        // base case
        if (n == 0 || m == 0) {
            return Integer.MAX_VALUE;
        }
 
        // if we're at first cell (0, 0)
        if (m == 1 && n == 1) {
            return cost[0][0];
        }
 
        // include cost of the current cell in path and
        // recur to find minimum of the path from adjacent
        // left cell and adjacent top cell.
        return Integer.min(findMinCost(cost, m - 1, n),
                        findMinCost(cost, m, n - 1))
                + cost[m - 1][n - 1];
    }
 
    public static void main(String[] args)
    {
        int[][] cost =
        {
            { 4, 7, 8, 6, 4 },
            { 6, 7, 3, 9, 2 },
            { 3, 8, 1, 2, 4 },
            { 7, 1, 7, 3, 7 },
            { 2, 9, 8, 9, 3 }
        };
 
        System.out.print("The minimum cost is "
                + findMinCost(cost, cost.length, cost[0].length));
    }
}





class FindMinimumCostToReachLastCellOfTheMatrixFromItsFirstCellA2
{
    // Iterative function to find the minimum cost to traverse
    // from the first cell to last cell of a matrix
    public static int findMinCost(int[][] cost)
    {
        // M x N matrix
        int M = cost.length;
        int N = cost[0].length;

        // T[i][j] maintains minimum cost to reach cell (i, j)
        // from cell (0, 0)
        int[][] T = new int[M][N];

        // fill matrix in bottom-up manner
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                T[i][j] = cost[i][j];

                // fill first row (there is only one way to reach any cell
                // in the first row, that is from its adjacent left cell)
                if (i == 0 && j > 0) {
                    T[0][j] += T[0][j - 1];
                }

                // fill first column (there is only one way to reach any cell
                // in the first column, that is from its adjacent top cell)
                else if (j == 0 && i > 0) {
                    T[i][0] += T[i - 1][0];
                }

                // fill rest of the matrix (there are two way to reach any
                // cell in the rest of the matrix, that is from its adjacent
                // left cell or adjacent top cell)
                else if (i > 0 && j > 0) {
                    T[i][j] += Integer.min(T[i - 1][j], T[i][j - 1]);
                }
            }
        }

        // last cell of T[][] stores min cost to reach destination cell
        // (M-1, N-1) from source cell (0, 0)
        return T[M - 1][N - 1];
    }

    public static void main(String[] args)
    {
        int[][] cost =
                {
                        { 4, 7, 8, 6, 4 },
                        { 6, 7, 3, 9, 2 },
                        { 3, 8, 1, 2, 4 },
                        { 7, 1, 7, 3, 7 },
                        { 2, 9, 8, 9, 3 }
                };

        System.out.print("The minimum cost is " + findMinCost(cost));
    }
}