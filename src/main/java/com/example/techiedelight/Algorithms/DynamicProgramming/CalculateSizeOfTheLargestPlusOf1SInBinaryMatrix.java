package com.example.techiedelight.Algorithms.DynamicProgramming;

class CalculateSizeOfTheLargestPlusOf1SInBinaryMatrix
{
    public static int minimum(int a, int b, int c, int d)
    {
        return Integer.min(Integer.min(a, b), Integer.min(c, d));
    }
 
    // Calculate the size of the largest '+' formed by 1's
    public static int calculateSize(int grid[][])
    {
        int N = grid.length;
 
        // left[j][j] stores maximum number of consecutive 1's
        // present to the left of grid[i][j] (including grid[i][j])
        int[][] left = new int[N][N];
 
        // right[j][j] stores maximum number of consecutive 1's
        // present to the right of grid[i][j] (including grid[i][j])
        int[][] right = new int[N][N];
 
        // top[j][j] stores maximum number of consecutive 1's
        // present to the top of grid[i][j] (including grid[i][j])
        int[][] top = new int[N][N];
 
        // bottom[j][j] stores maximum number of consecutive 1's
        // present to the bottom of grid[i][j] (including grid[i][j])
        int[][] bottom = new int[N][N];
 
        // initialize above matrices
        for (int i = 0; i < N; i++)
        {
            // initialize first row of top matrix
            top[0][i] = grid[0][i];
 
            // initialize last row of bottom matrix
            bottom[N - 1][i] = grid[N - 1][i];
 
            // initialize first column of left matrix
            left[i][0] = grid[i][0];
 
            // initialize last column of right matrix
            right[i][N - 1] = grid[i][N - 1];
        }
 
        // fill all cells of above four matrix
        for (int i = 0; i < N; i++)
        {
            for (int j = 1; j < N; j++)
            {
                // fill left matrix
                if (grid[i][j] == 1)
                    left[i][j] = left[i][j - 1] + 1;
 
                // fill top matrix
                if (grid[j][i] == 1)
                    top[j][i] = top[j - 1][i] + 1;
 
                // fill bottom matrix
                if (grid[N - 1 - j][i] == 1)
                    bottom[N - 1 - j][i] = bottom[N - j][i] + 1;
 
                // fill right matrix
                if (grid[i][N - 1 - j] == 1)
                    right[i][N - 1 - j] = right[i][N - j] + 1;
            }
        }
 
        // bar stores length of longest + found so far
        int bar = 0;
 
        // compute longest plus
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                // find minimum
                int len = minimum(top[i][j], bottom[i][j],
                                left[i][j], right[i][j]);
 
                // largest + is formed by a cell having maximum value
                if (len - 1 > bar)
                    bar = len - 1;
            }
        }
 
        return bar;
    }
 
        public static void main(String[] args)
    {
        int[][] grid =
        {
            { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
            { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
            { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
            { 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 },
            { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
            { 1, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
            { 1, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
            { 1, 1, 0, 0, 1, 0, 1, 0, 0, 1 },
            { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }
        };
 
        int bar = calculateSize(grid);
 
        // 4 directions of length 4*bar + 1 for middle cell
        if (bar != 0) {
            System.out.println("Largest Plus of 1's has size of "
                    + (4*bar + 1));
        }
    }
}