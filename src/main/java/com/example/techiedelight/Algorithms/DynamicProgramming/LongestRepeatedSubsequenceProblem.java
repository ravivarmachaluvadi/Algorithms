package com.example.techiedelight.Algorithms.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

class LongestRepeatedSubsequenceProblem
{
    // Function to find the length of Longest repeated Subsequence
    // of substring X[0..m-1] and X[0..n-1]
    public static int LRSLength(String X, int m, int n)
    {
        // return if we have reached the end of either string
        if (m == 0 || n == 0) {
            return 0;
        }
 
        // if characters at index m and n matches and index is different
        if (X.charAt(m - 1) == X.charAt(n - 1) && m != n) {
            return LRSLength(X, m - 1, n - 1) + 1;
        }
 
        // else if characters at index m and n don't match
        return Integer.max(LRSLength(X, m, n - 1),
                LRSLength(X, m - 1, n));
    }
 
    public static void main(String[] args)
    {
        String X = "ATACTCGGA";
        int m = X.length();
 
        System.out.print("Length of Longest Repeating Subsequence is " +
                LRSLength(X, m, m));
    }
}




class LongestRepeatedSubsequenceProblemA2
{
    // Function to find the length of Longest repeated Subsequence
    // of substring X[0..m-1] and X[0..n-1]
    public static int LRSLength(String X, int m, int n,
                                Map<String, Integer> lookup)
    {
        // return if we have reached the end of either string
        if (m == 0 || n == 0) {
            return 0;
        }

        // construct an unique map key from dynamic elements of the input
        String key = m + "|" + n;

        // if sub-problem is seen for the first time, solve it and
        // store its result in a map
        if (!lookup.containsKey(key))
        {
            // if characters at index m and n matches and index is different
            if (X.charAt(m - 1) == X.charAt(n - 1) && m != n) {
                lookup.put(key, LRSLength(X, m - 1, n - 1, lookup) + 1);
            }
            else {
                // else if characters at index m and n don't match
                lookup.put(key, Integer.max(LRSLength(X, m, n - 1, lookup),
                        LRSLength(X, m - 1, n, lookup)));
            }
        }

        // return the sub-problem solution from the map
        return lookup.get(key);
    }

    public static void main(String[] args)
    {
        String X = "ATACTCGGA";
        int m = X.length();

        // create a map to store solutions of subproblems
        Map<String, Integer> lookup = new HashMap<>();

        System.out.print("Length of Longest Repeating Subsequence is " +
                LRSLength(X, m, m, lookup));
    }
}




class LongestRepeatedSubsequenceProblemA3
{
    // Function to find the length of Longest repeated Subsequence
    // of substring X[0..n-1]
    public static int LRSLength(String X)
    {
        int n = X.length();

        // lookup table stores solution to already computed sub-problems

        // i.e. T[i][j] stores the length of LRS of substring
        // X[0..i-1] and X[0..j-1]
        int[][] T = new int[n + 1][n + 1];

        // fill the lookup table in bottom-up manner
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                // if characters at index i and j matches
                // and the index is different
                if (X.charAt(i - 1) == X.charAt(j - 1) && i != j) {
                    T[i][j] = T[i - 1][j - 1] + 1;
                }
                // else if characters at index i and j are different
                else {
                    T[i][j] = Integer.max(T[i - 1][j], T[i][j - 1]);
                }
            }
        }

        // LRS will be last entry in the lookup table
        return T[n][n];
    }

    public static void main(String[] args)
    {
        String X = "ATACTCGGA";

        System.out.print("Length of Longest Repeating Subsequence is " +
                LRSLength(X));
    }
}





class LongestRepeatedSubsequenceProblemA4
{
    // Function to find LRS of substrings X[0..m-1], X[0..n-1]
    public static String LRS(String X, int m, int n, int[][] T)
    {
        // if we have reached the end of either sequence
        // return empty string
        if (m == 0 || n == 0) {
            return new String("");
        }

        // if characters at index m and n matches and index is different
        if (X.charAt(m - 1) == X.charAt(n - 1) && m != n) {
            return LRS(X, m - 1, n - 1, T) + X.charAt(m - 1);
        }
        else
        // else if characters at index m and n don't match
        {
            if (T[m - 1][n] > T[m][n - 1]) {
                return LRS(X, m - 1, n, T);
            } else {
                return LRS(X, m, n - 1, T);
            }
        }
    }

    // Function to fill lookup table by finding the length of LRS
    // of substring X[0..n-1]
    public static void LRSLength(String X, int[][] T)
    {
        // first row and first column of the lookup table
        // are already 0 as T[][] is globally declared

        // fill the lookup table in bottom-up manner
        for (int i = 1; i <= X.length(); i++)
        {
            for (int j = 1; j <= X.length(); j++)
            {
                // if characters at index i and j matches
                // and the index is different
                if (X.charAt(i - 1) == X.charAt(j - 1) && i != j) {
                    T[i][j] = T[i - 1][j - 1] + 1;
                }
                // else if characters at index i and j are different
                else {
                    T[i][j] = Integer.max(T[i - 1][j], T[i][j - 1]);
                }
            }
        }

        // Uncomment below code to print the lookup table
        /*for (var r: T) {
            System.out.println(Arrays.toString(r));
        }*/
    }

    public static void main(String[] args)
    {
        String X = "ATACTCGGA";

        // T[i][j] stores the length of LRS of substring X[0..i-1], X[0..j-1]
        int[][] T = new int[X.length() + 1][X.length() + 1];

        // fill lookup table
        LRSLength(X, T);

        // find Longest Repeating Subsequence
        System.out.print("The Longest Repeating Subsequence is " +
                LRS(X, X.length(), X.length(), T));
    }
}


