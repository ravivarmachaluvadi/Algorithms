package com.example.techiedelight.Algorithms.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

class LongestPalindromicSubsequenceUsingDynamicProgramming
{
    // Function to find the length of Longest Palindromic Subsequence
    // of substring X[i..j]
    public static int longestPalindrome(String X, int i, int j)
    {
        // base condition
        if (i > j) {
            return 0;
        }
 
        // if String X has only one character, it is palindrome
        if (i == j) {
            return 1;
        }
 
        // if last character of the string is same as the first character
        if (X.charAt(i) == X.charAt(j))
        {
            // include first and last characters in palindrome
            // and recur for the remaining substring X[i+1, j-1]
            return longestPalindrome(X, i + 1, j - 1) + 2;
        }
 
        // if last character of string is different to the first character
 
        // return maximum of -
        // 1. Remove last character & recur for the remaining
        // substring X[i, j-1]
        // 2. Remove first character & recur for the remaining
        // substring X[i+1, j]
        return Integer.max(longestPalindrome(X, i, j - 1),
                            longestPalindrome(X, i + 1, j));
    }
 
    // main method
    public static void main(String[] args)
    {
        String X = "ABBDCACB";
        int n = X.length();
 
        System.out.print("The length of Longest Palindromic Subsequence is "
                + longestPalindrome(X, 0, n - 1));
    }
}





class LongestPalindromicSubsequenceUsingDynamicProgrammingA2
{
    // Function to find the length of Longest Palindromic Subsequence
    // of substring X[i..j]
    public static int longestPalindrome(String X, int i, int j,
                                        Map<String, Integer> lookup)
    {
        // base condition
        if (i > j) {
            return 0;
        }

        // if String X has only one character, it is palindrome
        if (i == j) {
            return 1;
        }

        // construct an unique map key from dynamic elements of the input
        String key = i + "|" + j;

        // if sub-problem is seen for the first time, solve it and
        // store its result in a map
        if (!lookup.containsKey(key))
        {
            /* if last character of the string is same as the first character
            include first and last characters in palindrome and recur
            for the remaining substring X[i+1, j-1] */

            if (X.charAt(i) == X.charAt(j)) {
                lookup.put(key, longestPalindrome(X, i + 1, j - 1, lookup) + 2);
            }
            else {

            /* if last character of string is different to the first character

            1. Remove last char & recur for the remaining substring X[i, j-1]
            2. Remove first char & recur for the remaining substring X[i+1, j]
            3. Return maximum of the two values */

                lookup.put(key, Integer.max(longestPalindrome(X, i, j - 1, lookup),
                        longestPalindrome(X, i + 1, j, lookup)));
            }
        }

        // return the sub-problem solution from the map
        return lookup.get(key);
    }

    // Longest Palindromic Subsequence using Dynamic Programming
    public static void main(String[] args)
    {
        String X = "ABBDCACB";
        int n = X.length();

        // create a map to store solutions of subproblems
        Map<String, Integer> lookup = new HashMap<>();

        System.out.print("The length of Longest Palindromic Subsequence is " +
                longestPalindrome(X, 0, n - 1, lookup));
    }
}





class LongestPalindromicSubsequenceUsingDynamicProgrammingA3
{
    // Function to find LCS of String X[0..m-1] and Y[0..n-1]
    public static String longestPalindrome(String X, String Y, int m, int n,
                                           int[][] T)
    {
        // return empty string if we have reached the end of
        // either sequence
        if (m == 0 || n == 0) {
            return "";
        }

        // if last character of X and Y matches
        if (X.charAt(m - 1) == Y.charAt(n - 1))
        {
            // append current character (X[m-1] or Y[n-1]) to LCS of
            // substring X[0..m-2] and Y[0..n-2]
            return longestPalindrome(X, Y, m - 1, n - 1, T) + X.charAt(m - 1);
        }

        // else when the last character of X and Y are different

        // if top cell of current cell has more value than the left
        // cell, then drop current character of String X and find LCS
        // of substring X[0..m-2], Y[0..n-1]

        if (T[m - 1][n] > T[m][n - 1]) {
            return longestPalindrome(X, Y, m - 1, n, T);
        }

        // if left cell of current cell has more value than the top
        // cell, then drop current character of String Y and find LCS
        // of substring X[0..m-1], Y[0..n-2]

        return longestPalindrome(X, Y, m, n - 1, T);
    }

    // Function to find length of LCS of substring X[0..n-1] and Y[0..n-1]
    public static int LCSLength(String X, String Y, int n, int[][] T)
    {
        // first row and first column of the lookup table
        // are already 0 as T[][] is globally declared

        // fill the lookup table in bottom-up manner
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                // if current character of X and Y matches
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    T[i][j] = T[i - 1][j - 1] + 1;
                }

                // else if current character of X and Y don't match
                else {
                    T[i][j] = Integer.max(T[i - 1][j], T[i][j - 1]);
                }
            }
        }
        return T[n][n];
    }

    public static void main(String[] args)
    {
        String X = "ABBDCACB";

        // String Y is reverse of X
        String Y = new StringBuilder(X).reverse().toString();

        // T[i][j] stores the length of LCS of substring X[0..i-1], Y[0..j-1]
        int[][] T = new int[X.length() + 1][X.length() + 1];

        // Find length of Longest Palindromic Subsequence using LCS
        System.out.println("The length of Longest Palindromic Subsequence is "
                + LCSLength(X, Y, X.length(), T));

        // Print Longest Palindromic Subsequence using lookup table
        System.out.println("The Longest Palindromic Subsequence is "
                + longestPalindrome(X, Y, X.length(), X.length(), T));
    }
}