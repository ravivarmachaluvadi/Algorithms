package com.example.techiedelight.Algorithms.DynamicProgramming;

class MatrixChainMultiplicationUsingDynamicProgramming
{
    // Function to find the most efficient way to multiply
    // given sequence of matrices
    public static int MatrixChainMultiplication(int[] dims, int i, int j)
    {
        // base case: one matrix
        if (j <= i + 1) {
            return 0;
        }
 
        // stores minimum number of scalar multiplications (i.e., cost)
        // needed to compute the matrix M[i+1]...M[j] = M[i..j]
        int min = Integer.MAX_VALUE;
 
        // take the minimum over each possible position at which the
        // sequence of matrices can be split
 
        /*
            (M[i+1]) x (M[i+2]..................M[j])
            (M[i+1]M[i+2]) x (M[i+3.............M[j])
            ...
            ...
            (M[i+1]M[i+2]............M[j-1]) x (M[j])
        */
 
        for (int k = i + 1; k <= j - 1; k++)
        {
            // recur for M[i+1]..M[k] to get a i x k matrix
            int cost = MatrixChainMultiplication(dims, i, k);
 
            // recur for M[k+1]..M[j] to get a k x j matrix
            cost += MatrixChainMultiplication(dims, k, j);
 
            // cost to multiply two (i x k) and (k x j) matrix
            cost += dims[i] * dims[k] * dims[j];
 
            if (cost < min) {
                min = cost;
            }
        }
 
        // return min cost to multiply M[j+1]..M[j]
        return min;
    }
 
    public static void main(String[] args)
    {
        // Matrix M[i] has dimension dims[i-1] x dims[i] for i = 1..n
        // input is 10 × 30 matrix, 30 × 5 matrix, 5 × 60 matrix
        int[] dims = { 10, 30, 5, 60 };
 
        System.out.print("Minimum cost is " +
                MatrixChainMultiplication(dims, 0, dims.length - 1));
    }
}




class MatrixChainMultiplicationUsingDynamicProgrammingA2
{
    // Function to find the most efficient way to multiply
    // given sequence of matrices
    public static int MatrixChainMultiplication(int[] dims, int i, int j, int[][] T)
    {
        // base case: one matrix
        if (j <= i + 1) {
            return 0;
        }

        // stores minimum number of scalar multiplications (i.e., cost)
        // needed to compute the matrix M[i+1]...M[j] = M[i..j]
        int min = Integer.MAX_VALUE;

        // if sub-problem is seen for the first time, solve it and
        // store its result in a lookup table
        if (T[i][j] == 0)
        {
            // take the minimum over each possible position at which the
            // sequence of matrices can be split

            /*
                (M[i+1]) x (M[i+2]..................M[j])
                (M[i+1]M[i+2]) x (M[i+3.............M[j])
                ...
                ...
                (M[i+1]M[i+2]............M[j-1]) x (M[j])
            */

            for (int k = i + 1; k <= j - 1; k++)
            {
                // recur for M[i+1]..M[k] to get an i x k matrix
                int cost = MatrixChainMultiplication(dims, i, k, T);

                // recur for M[k+1]..M[j] to get a k x j matrix
                cost += MatrixChainMultiplication(dims, k, j, T);

                // cost to multiply two (i x k) and (k x j) matrix
                cost +=    dims[i] * dims[k] * dims[j];

                if (cost < min)
                    min = cost;
            }
            T[i][j] = min;
        }

        // return min cost to multiply M[j+1]..M[j]
        return T[i][j];
    }

    public static void main(String[] args)
    {
        // Matrix M[i] has dimension dims[i-1] x dims[i] for i = 1..n
        // input is 10 x 30 matrix, 30 x 5 matrix, 5 x 60 matrix
        int[] dims = { 10, 30, 5, 60 };

        // lookup table to store the solution to already computed
        // sub-problems
        int[][] T = new int[dims.length][dims.length];

        System.out.print("Minimum cost is " +
                MatrixChainMultiplication(dims, 0, dims.length - 1, T));

    }
}




class MatrixChainMultiplicationUsingDynamicProgrammingA3
{
    // Function to find the most efficient way to multiply
    // given sequence of matrices
    public static int matrixChainMultiplication(int[] dims)
    {
        int n = dims.length;

        // c[i,j] = minimum number of scalar multiplications (i.e., cost)
        // needed to compute the matrix M[i]M[i+1]...M[j] = M[i..j]
        // The cost is zero when multiplying one matrix
        int[][] c = new int[n + 1][n + 1];

        for (int len = 2; len <= n; len++) // Subsequence lengths
        {
            for (int i = 1; i <= n - len + 1; i++)
            {
                int j = i + len - 1;
                c[i][j] = Integer.MAX_VALUE;

                for (int k = i; j < n && k <= j - 1; k++)
                {
                    int cost = c[i][k] + c[k + 1][j]
                            + dims[i - 1] * dims[k] * dims[j];

                    if (cost < c[i][j]) {
                        c[i][j] = cost;
                    }
                }
            }
        }
        return c[1][n - 1];
    }

    public static void main(String[] args)
    {
        // Matrix M[i] has dimension dims[i-1] x dims[i] for i = 1..n
        // input is 10 x 30 matrix, 30 x 5 matrix, 5 x 60 matrix
        int[] dims = { 10, 30, 5, 60 };

        System.out.print("Minimum cost is "
                + matrixChainMultiplication(dims));
    }
}