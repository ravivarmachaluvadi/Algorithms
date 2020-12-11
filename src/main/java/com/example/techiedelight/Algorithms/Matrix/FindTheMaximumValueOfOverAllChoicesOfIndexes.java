package com.example.techiedelight.Algorithms.Matrix;

//FindTheMaximumValueOfM[C][D]–M[A][B]OverAllChoicesOfIndexes
class FindTheMaximumValueOfOverAllChoicesOfIndexes
{
    // Size of given matrix is N x N
    private static int N;
 
    // Returns maximum value M[c][d] – M[a][b] over all choices of indexes
    // such that c > a and d > b
    public static int findMax(int[][] M)
    {
        // K[i][j] stores maximum of elements in matrix from
        // (i, j) to (N-1, N-1)
        int[][] K = new int[N][N];
 
        // last element of K[][] will be the same as that of the specified matrix
        K[N - 1][N - 1] = M[N - 1][N - 1];
 
        int max = M[N - 1][N - 1]; // Initialize max
 
        // pre-process last row
        for (int j = N - 2; j >= 0; j--) {
            if (M[N - 1][j] > max) {
                max = M[N - 1][j];
            }
            K[N - 1][j] = max;
        }
 
        max = M[N - 1][N - 1]; // Initialize max
 
        // pre-process last column
        for (int i = N - 2; i >= 0; i--) {
            if (M[i][N - 1] > max) {
                max = M[i][N - 1];
            }
            K[i][N - 1] = max;
        }
 
        max = Integer.MIN_VALUE;    // Initialize max
 
        // pre-process rest of the matrix from bottom
        for (int i = N - 2; i >= 0; i--) {
            for (int j = N - 2; j >= 0; j--) {
                // update the max value
                if (K[i + 1][j + 1] - M[i][j] > max) {
                    max = K[i + 1][j + 1] - M[i][j];
                }
 
                // assign K[i][j]
                K[i][j] = Math.max(M[i][j], Math.max(K[i][j + 1], K[i + 1][j]));
            }
        }
 
        return max;
    }
 
    public static void main(String[] args)
    {
        int[][] M =
        {
            { 1, 2, -1, -4, -20 },
            { -8, -3, 4, 2, 1 },
            { 3, 8, 6, 1, 3 },
            { -4, -1, 1, 7, -6 },
            { 0, -4, 10, -5, 1 }
        };
 
        N = M.length;
 
        System.out.println("The Maximum Value is " + findMax(M));
    }
}