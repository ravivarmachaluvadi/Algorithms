package com.example.techiedelight.Algorithms.DynamicProgramming;

class CountAllPathsInAMatrixFromFirstCellToLastCell
{
    // M x N matrix
    private static final int M = 3;
    private static final int N = 3;
 
    // Top-down recursive function to count all paths from the cell (m,n)
    // to the last cell (N-1,M-1) in a given M x N rectangular grid
    public static int countPaths(int m, int n)
    {
        // there is only one way to reach the last cell
        // when we're at the last row or the last column
        if (m == M - 1 || n == N - 1)
            return 1;
 
        return countPaths(m + 1, n)    // move down
            + countPaths(m, n + 1);    // move right
    }
 
    public static void main(String[] args)
    {
        int k = countPaths(0, 0);
        System.out.println("Total number of paths are: " + k);
    }
}




class CountAllPathsInAMatrixFromFirstCellToLastCellA2
{
    // M x N matrix
    private static final int M = 3;
    private static final int N = 3;

    // Bottom-up function to count all paths from the first cell (0,0)
    // to the last cell (M-1,N-1) in a given M x N rectangular grid
    public static int countPaths(int m, int n)
    {
        // T[i][j] stores the number of paths from cell (0,0) to cell (i,j)
        int[][] T = new int[m][n];

        // There is only one way to reach any cell in the first column i.e. to move down
        for (int i = 0; i < m; i++) {
            T[i][0] = 1;
        }

        // There is only one way to reach any cell in the first row i.e. to move right
        for (int j = 0; j < n; j++) {
            T[0][j] = 1;
        }

        // fill T[][] in bottom-up manner
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                T[i][j] = T[i-1][j] + T[i][j-1];
            }
        }

        // last cell of T[][] stores the count of paths from cell(0,0) to cell(i,j)
        return T[m-1][n-1];
    }

    public static void main(String[] args)
    {
        int k = countPaths(M, N);
        System.out.println("Total number of paths are: " + k);
    }
}




class CountAllPathsInAMatrixFromFirstCellToLastCellA3
{
    // M x N matrix
    private static final int M = 3;
    private static final int N = 3;

    // Bottom-up space efficient function to count all paths from the first
    // cell (0,0) to the last cell (M-1,N-1) in a given M x N rectangular grid
    public static int countPaths(int m, int n)
    {
        int[] T = new int[N];
        T[0] = 1;

        // fill T[][] in bottom-up manner
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                T[j] += T[j - 1];
            }
        }

        // return last cell
        return T[n-1];
    }

    public static void main(String[] args)
    {
        int k = countPaths(M, N);
        System.out.print("Total number of paths are: " + k);
    }
}