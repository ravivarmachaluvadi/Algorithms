package com.example.techiedelight.Algorithms.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
 
class LongestIncreasingSubsequenceUsingLCS
{
    // Function to find length of Longest Common Subsequence of
    // array X[0..m-1] and Y[0..n-1]
    public static int LCSLength(int[] X, int[] Y, int m, int n,
                                Map<String, Integer> lookup)
    {
        // return if we have reached the end of either array
        if (m == 0 || n == 0) {
            return 0;
        }
 
        // construct an unique map key from dynamic elements of the input
        String key = m + "|" + n;
 
        // if sub-problem is seen for the first time, solve it and
        // store its result in a map
        if (!lookup.containsKey(key))
        {
            // if last element of X and Y matches
            if (X[m - 1] == Y[n - 1]) {
                lookup.put(key, LCSLength(X, Y, m - 1, n - 1, lookup) + 1);
            }
            // else if last element of X and Y don't match
            else {
                lookup.put(key, Integer.max(LCSLength(X, Y, m, n - 1, lookup),
                                            LCSLength(X, Y, m - 1, n, lookup)));
            }
        }
 
        // return the subproblem solution from the map
        return lookup.get(key);
    }
 
    // Function to remove duplicates from a sorted array
    public static int removeDuplicates(int[] X)
    {
        int k = 0;
        for (int i = 1; i < X.length; i++) {
            if (X[i] != X[k]) {
                X[++k] = X[i];
            }
        }
 
        // return length of sub-array containing all distinct characters
        return k + 1;
    }
 
    // Iterative function to find length of longest increasing subsequence (LIS)
    // of given array using longest common subsequence (LCS)
    public static int findLIS(int[] X, Map<String, Integer> lookup)
    {
        // create a copy of the original array and sort it
        int[] Y = Arrays.copyOf(X, X.length);
        Arrays.sort(Y);
 
        // remove all the duplicates from Y
        int m = removeDuplicates(Y);
 
        // perform LCS of both
        return LCSLength(X, Y, X.length, X.length, lookup);
    }
 
    public static void main(String[] args)
    {
        int[] X = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
 
        // create a map to store solutions of subproblems
        Map<String, Integer> lookup = new HashMap<>();
 
        System.out.println("The length of LIS is "
                + findLIS(X, lookup));
    }
}




class LongestIncreasingSubsequenceUsingLCSA2
{
    // define maximum possible length of X and Y
    private static int N;

    // lookup[i][j] stores the length of LCS of subarray X[0..i-1], Y[0..j-1]
    private static int[][] lookup;

    // Function to find LCS of array X[0..m-1] and Y[0..n-1]
    public static void LCS(int[] X, int[] Y, int m, int n)
    {
        // return if we have reached the end of either array
        if (m == 0 || n == 0) {
            return;
        }

        // if last element of X and Y matches
        if (X[m - 1] == Y[n - 1])
        {
            LCS(X, Y, m - 1, n - 1);
            System.out.print(X[m - 1] + " ");
            return;
        }
        // else when the last element of X and Y are different

        if (lookup[m - 1][n] > lookup[m][n - 1]) {
            LCS(X, Y, m - 1, n);
        } else {
            LCS(X, Y, m, n - 1);
        }
    }

    // Function to find length of Longest Common Subsequence of
    // array X[0..m-1] and Y[0..n-1]
    public static void findLCS(int[] X, int[] Y, int m, int n)
    {
        // first row and first column of the lookup table
        // are already 0 as lookup[][] is globally declared

        // fill the lookup table in bottom-up manner
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                // if current element of X and Y matches
                if (X[i - 1] == Y[j - 1])
                    lookup[i][j] = lookup[i - 1][j - 1] + 1;

                    // else if current element of X and Y don't match
                else
                    lookup[i][j] = Integer.max(lookup[i - 1][j], lookup[i][j - 1]);
            }
        }

        // find longest common sequence
        LCS(X, Y, m, n);
    }

    // Function to remove duplicates from a sorted array
    public static int removeDuplicates(int[] X)
    {
        int k = 0;
        for (int i = 1; i < X.length; i++) {
            if (X[i] != X[k]) {
                X[++k] = X[i];
            }
        }

        // return length of sub-array containing all distinct characters
        return k + 1;
    }

    // Iterative function to find length of longest increasing subsequence (LIS)
    // of given array using longest common subsequence (LCS)
    public static void findLIS(int[] X)
    {
        // create a copy of the original array
        int[] Y = Arrays.copyOf(X, X.length);

        // sort the copy of the original array
        Arrays.sort(Y);

        // remove all the duplicates from Y
        int m = removeDuplicates(Y);

        // perform LCS of both
        findLCS(X, Y, X.length, m);
    }

    // Longest Increasing Subsequence using LCS
    public static void main(String[] args)
    {
        int[] X = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

        // initialize N and lookup[][]
        N = X.length + 1;
        lookup = new int[N][N];

        System.out.print("The LIS is: ");
        findLIS(X);
    }
}