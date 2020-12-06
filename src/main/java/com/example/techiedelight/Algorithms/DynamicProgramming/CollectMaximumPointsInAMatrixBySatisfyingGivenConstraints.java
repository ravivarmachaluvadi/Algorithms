package com.example.techiedelight.Algorithms.DynamicProgramming;

class CollectMaximumPointsInAMatrixBySatisfyingGivenConstraints
{
    // Function to check if cell (i, j) is valid and safe to visit
    public static boolean isSafe(int[][] mat, int i, int j)
    {
        if (i < 0 || i >= mat.length || j < 0 ||
                j >= mat[0].length || mat[i][j] == -1) {
            return false;
        }
 
        return true;
    }
 
    // Function to collect maximum number of ones starting from
    // cell mat[i][j]
    public static int findMaximum(int[][] mat, int i, int j)
    {
        // return if cell (i, j) is invalid or unsafe to visit
        if (!isSafe(mat, i, j)) {
            return 0;
        }
 
        // if row is odd, we can go left or down
        if ((i & 1) == 1) {
            return mat[i][j] + Integer.max(findMaximum(mat, i, j - 1),
                                        findMaximum(mat, i + 1, j));
        }
 
        // if row is even, we can go right or down
        else {
            return mat[i][j] + Integer.max(findMaximum(mat, i, j + 1),
                                        findMaximum(mat, i + 1, j));
        }
    }
 
    public static void main(String[] args)
    {
        int[][] mat =
        {
            {  1,  1, -1,  1,  1 },
            {  1,  0,  0, -1,  1 },
            {  1,  1,  1,  1, -1 },
            { -1, -1,  1,  1,  1 },
            {  1,  1, -1, -1,  1 }
        };
 
        System.out.println("Maximum value collected is "
                + findMaximum(mat, 0, 0));
    }
}




class CollectMaximumPointsInAMatrixBySatisfyingGivenConstraintsA2
{
    // Function to collect maximum value from the first cell (0, 0)
    public static int findMaximum(int[][] mat)
    {
        // M x N matrix
        int M = mat.length;
        int N = mat[0].length;

        // T[i][j] stores maximum value that can be collected
        // from any cell to cell (i-1, j-1)
        int[][] T = new int[M+1][N+1];

        // process each row one by one and fill lookup table T[][]
        for (int i = 1; i<= M; i++)
        {
            // handle odd and even row separately
            if ((i & 1) == 1)
            {
                // process current row from left to right
                for (int j = 1; j <= N; j++)
                {
                    if (mat[i-1][j-1] != -1) {
                        T[i][j] = mat[i-1][j-1]
                                + Integer.max(T[i][j-1], T[i-1][j]);
                    }
                }
            }
            else
            {
                // process current row from right to left
                for (int j = N - 1; j >= 1; j--)
                {
                    if (mat[i-1][j-1] != -1) {
                        T[i][j] = mat[i-1][j-1]
                                + Integer.max(T[i][j+1], T[i-1][j]);
                    }
                }
            }
        }

        // trace maximum ones starting from first cell
        int i = 1, j =1;
        int res = T[i][j];

        while (i <= M && j >= 0 && j <= N)
        {
            if (T[i][j] == T[i+1][j] || T[i][j] + 1 == T[i+1][j]) {
                i++;
            }
            else if (T[i][j] == T[i][j+1] || T[i][j] + 1 == T[i][j+1]) {
                j++;
            }
            else if (T[i][j] == T[i][j-1] || T[i][j] + 1 == T[i][j-1]) {
                j--;
            }
            else {
                break;
            }

            res = T[i][j];
        }

        return res;
    }

    public static void main(String[] args)
    {
        int[][] mat =
                {
                        {  1,  1, -1,  1,  1 },
                        {  1,  0,  0, -1,  1 },
                        {  1,  1,  1,  1, -1 },
                        { -1, -1,  1,  1,  1 },
                        {  1,  1, -1, -1,  1 }
                };

        System.out.println("Maximum value collected is "
                + findMaximum(mat));
    }
}