package com.example.techiedelight.Algorithms.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

class ShortestCommonSupersequenceProblem
{
    // Function to find length of shortest Common supersequence of
    // sequences X[0..m-1] and Y[0..n-1]
    public static int SCSLength(String X, String Y, int m, int n)
    {
        // if we have reached the end of either sequence, return
        // length of other sequence
        if (m == 0 || n == 0) {
            return n + m;
        }
 
        // if last character of X and Y matches
        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            return SCSLength(X, Y, m - 1, n - 1) + 1;
        }
 
        // last character of X and Y don't match
        return Integer.min(SCSLength(X, Y, m, n - 1) + 1,
                        SCSLength(X, Y, m - 1, n) + 1);
    }
 
    public static void main(String[] args)
    {
        String X = "ABCBDAB", Y = "BDCABA";
        int m = X.length(), n = Y.length();
 
        System.out.print("The length of shortest Common supersequence is "
                        + SCSLength(X, Y, m, n));
    }
}




class ShortestCommonSupersequenceProblemA2
{
    // Function to find length of shortest Common supersequence of
    // sequences X[0..m-1] and Y[0..n-1]
    public static int SCSLength(String X, String Y, int m, int n,
                                Map<String, Integer> lookup)
    {
        // if we have reached the end of either sequence, return
        // length of other sequence
        if (m == 0 || n == 0) {
            return n + m;
        }

        // construct an unique map key from dynamic elements of the input
        String key = m + "|" + n;

        // if sub-problem is seen for the first time, solve it and
        // store its result in a map
        if (!lookup.containsKey(key))
        {
            // if last character of X and Y matches
            if (X.charAt(m - 1) == Y.charAt(n - 1)) {
                lookup.put(key, SCSLength(X, Y, m - 1, n - 1, lookup) + 1);
            }
            else {
                // else if last character of X and Y don't match
                int min = Integer.min(SCSLength(X, Y, m, n - 1, lookup) + 1,
                        SCSLength(X, Y, m - 1, n, lookup) + 1);
                lookup.put(key, min);
            }
        }

        // return the sub-problem solution from the map
        return lookup.get(key);
    }

    public static void main(String[] args)
    {
        String X = "ABCBDAB", Y = "BDCABA";

        // create a map to store solutions of subproblems
        // we can also use array instead of map
        Map<String, Integer> lookup = new HashMap<>();

        System.out.print("The length of shortest Common supersequence is "
                + SCSLength(X, Y, X.length(), Y.length(), lookup));
    }
}




class ShortestCommonSupersequenceProblemA3
{
    // Function to find length of shortest Common supersequence of
    // sequences X[0..m-1] and Y[0..n-1]
    public static int SCSLength(String X, String Y)
    {
        int m = X.length(), n = Y.length();

        // lookup table stores solution to already computed sub-problems
        // i.e. T[i][j] stores the length of SCS of substring
        // X[0..i-1] and Y[0..j-1]
        int[][] T = new int[m + 1][n + 1];

        // initialize first column of the lookup table
        for (int i = 0; i <= m; i++) {
            T[i][0] = i;
        }

        // initialize first row of the lookup table
        for (int j = 0; j <= n; j++) {
            T[0][j] = j;
        }

        // fill the lookup table in bottom-up manner
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                // if current character of X and Y matches
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    T[i][j] = T[i - 1][j - 1] + 1;
                }
                // else if current character of X and Y don't match
                else {
                    T[i][j] = Integer.min(T[i - 1][j] + 1, T[i][j - 1] + 1);
                }
            }
        }

        // SCS will be last entry in the lookup table
        return T[m][n];
    }

    public static void main(String[] args)
    {
        String X = "ABCBDAB", Y = "BDCABA";

        System.out.print("The length of shortest Common supersequence is "
                + SCSLength(X, Y));
    }
}