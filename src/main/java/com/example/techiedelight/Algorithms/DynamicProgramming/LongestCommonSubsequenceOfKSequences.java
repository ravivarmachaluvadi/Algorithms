package com.example.techiedelight.Algorithms.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

class LongestCommonSubsequenceOfKSequences
{
    // Function to return maximum of three integers
    public static int max(int a, int b, int c) {
        return Integer.max(Integer.max(a, b), c);
    }
 
    // Function to find length of Longest Common Subsequence of
    // sequences X[0..m-1], Y[0..n-1] and Z[0..o-1]
    public static int LCSLength(String X, String Y, String Z,
                                        int m, int n, int o)
    {
        // return if we have reached the end of either sequence
        if (m == 0 || n == 0 || o == 0) {
            return 0;
        }
 
        // if last character of X, Y and Z matches
        if (X.charAt(m - 1) == Y.charAt(n - 1) &&
                Y.charAt(n - 1) == Z.charAt(o - 1)) {
            return LCSLength(X, Y, Z, m - 1, n - 1, o - 1) + 1;
        }
 
        // else if last character of X, Y and Z don't match
        return max( LCSLength(X, Y, Z, m - 1, n, o),
                LCSLength(X, Y, Z, m, n - 1, o),
                LCSLength(X, Y, Z, m, n, o - 1));
    }
 
    public static void main(String[] args)
    {
        String X = "ABCBDAB", Y = "BDCABA", Z = "BADACB";
 
        System.out.print("The length of LCS is " +
                LCSLength(X, Y, Z, X.length(), Y.length(), Z.length()));
    }
}




class LongestCommonSubsequenceOfKSequencesA2
{
    // Function to return maximum of three integers
    public static int max(int a, int b, int c)
    {
        return Integer.max(Integer.max(a, b), c);
    }

    // Function to find length of Longest Common Subsequence of
    // sequences X[0..m-1], Y[0..n-1] and Z[0..o-1]
    public static int LCSLength(String X, String Y, String Z, int m, int n,
                                int o, Map<String, Integer> lookup)
    {
        // return if we have reached the end of either sequence
        if (m == 0 || n == 0 || o == 0)
            return 0;

        // construct an unique map key from dynamic elements of the input
        String key = m + "|" + n + "|" + o;

        // if sub-problem is seen for the first time, solve it and
        // store its result in a map
        if (!lookup.containsKey(key))
        {
            // if last character of X, Y and Z matches
            if (X.charAt(m - 1) == Y.charAt(n - 1) &&
                    Y.charAt(n - 1) == Z.charAt(o - 1)) {
                int lcs = LCSLength(X, Y, Z, m - 1, n - 1, o - 1, lookup);
                lookup.put(key, lcs + 1);
            }
            else {
                // else if last character of X, Y and Z don't match
                lookup.put(key, max(LCSLength(X, Y, Z, m - 1, n, o, lookup),
                        LCSLength(X, Y, Z, m, n - 1, o, lookup),
                        LCSLength(X, Y, Z, m, n, o - 1, lookup)));
            }
        }

        // return the sub-problem solution from the map
        return lookup.get(key);
    }

    public static void main(String[] args)
    {
        String X = "ABCBDAB", Y = "BDCABA", Z = "BADACB";

        // create a map to store solutions of subproblems
        Map<String, Integer> lookup = new HashMap<>();

        System.out.print("The length of LCS is " +
                LCSLength(X, Y, Z, X.length(), Y.length(), Z.length(), lookup));
    }
}





class LongestCommonSubsequenceOfKSequencesA3
{
    // Function to return maximum of three integers
    public static int max(int a, int b, int c)
    {
        return Integer.max(Integer.max(a, b), c);
    }

    // Function to find length of Longest Common Subsequence of
    // sequences X[0..m-1], Y[0..n-1] and Z[0..o-1]
    public static int LCSLength(String X, String Y, String Z)
    {
        int m = X.length(), n = Y.length(), o = Z.length();

        // lookup table stores solution to already computed sub-problems
        // i.e. T[i][j][k] stores the length of LCS of substring
        // X[0..i-1], Y[0..j-1], Z[0..k-1]
        int[][][] T = new int[m + 1][n + 1][o + 1];

        // fill the lookup table in bottom-up manner
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                for (int k = 1; k <= o; k++)
                {
                    // if current character of X, Y and Z matches
                    if (X.charAt(i - 1) == Y.charAt(j - 1)
                            && Y.charAt(j - 1) == Z.charAt(k - 1)) {
                        T[i][j][k] = T[i - 1][j - 1][k - 1] + 1;
                    }
                    // else if current character of X, Y and Z don't match
                    else {
                        T[i][j][k] = max(T[i - 1][j][k],
                                T[i][j - 1][k],
                                T[i][j][k - 1]);
                    }
                }
            }
        }

        // LCS will be last entry in the lookup table
        return T[m][n][o];
    }

    public static void main(String[] args)
    {
        String X = "ABCBDAB", Y = "BDCABA", Z = "BADACB";

        System.out.print("The length of LCS is " + LCSLength(X, Y, Z));
    }
}