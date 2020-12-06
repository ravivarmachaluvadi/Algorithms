package com.example.techiedelight.Algorithms.DynamicProgramming;

class CollectMaximumValueOfCoinsInAMatrix
{
    private static int M, N;
 
    // Function to check whether (i, x) and (i, y) are valid matrix coordinates
    public static boolean isValid(int i, int x, int y)
    {
        return i < M && x >= 0 && x < N && y >= 0 && y < N;
    }
 
    // Collect maximum coins from cell (i, x) to cell (M-1, 0) and from
    // cell (i, y) to cell (M-1, N-1)
    public static int maxCoins(int[][] mat, int i, int x, int y)
    {
        // return if either (i, x) or (i, y) is invalid
        if (!isValid(i, x, y)) {
            return Integer.MIN_VALUE;
        }
 
        // current row is the last row
        if (i == M - 1) {
            // destination reached
            if (x == 0 && y == N - 1) {
                return (x == y) ? mat[i][x] : mat[i][x] + mat[i][y];
            }
 
            // destination not reached
            return Integer.MIN_VALUE;
        }
 
        // stores the max number of coins
        int coins = Integer.MIN_VALUE;
 
        // recur for all possible ways
        // (i, x) -> (i+1, x-1) or (i+1, x) or (i+1, x+1)
        // (i, y) -> (i+1, y-1) or (i+1, y) or (i+1, y+1)
 
        coins = Math.max(coins, maxCoins(mat, i + 1, x - 1, y - 1));
        coins = Math.max(coins, maxCoins(mat, i + 1, x - 1, y));
        coins = Math.max(coins, maxCoins(mat, i + 1, x - 1, y + 1));
 
        coins = Math.max(coins, maxCoins(mat, i + 1, x, y - 1));
        coins = Math.max(coins, maxCoins(mat, i + 1, x, y));
        coins = Math.max(coins, maxCoins(mat, i + 1, x, y + 1));
 
        coins = Math.max(coins, maxCoins(mat, i + 1, x + 1, y - 1));
        coins = Math.max(coins, maxCoins(mat, i + 1, x + 1, y));
        coins = Math.max(coins, maxCoins(mat, i + 1, x + 1, y + 1));
 
        // update max number of coins with current cell coins before returning
        if (x == y) {
            return mat[i][x] + coins;
        } else {
            return (mat[i][x] + mat[i][y]) + coins;
        }
    }
 
    public static void main(String[] args)
    {
        int[][] mat =
        {
            { 0, 2, 4, 1 },
            { 4, 8, 3, 7 },
            { 2, 3, 6, 2 },
            { 9, 7, 8, 3 },
            { 1, 5, 9, 4 }
        };
 
        M = mat.length;
        N = mat[0].length;
 
        // start with the cells (0, 0) and (0, N-1)
        System.out.println("The maximum coins collected is " +
                            maxCoins(mat, 0, 0, N - 1));
    }
}