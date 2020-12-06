package com.example.techiedelight.Algorithms.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

class FindMinimumNumberOfDeletionsRequiredToConvertAStringIntoPalindrome
{
 
    // Function to find out the minimum number of deletions required to
    // convert a given String X[i..j] into a palindrome
    public static int minDeletions(String X, int i, int j)
    {
        // base condition
        if (i >= j) {
            return 0;
        }
 
        // if last character of the String is same as the first character
        if (X.charAt(i) == X.charAt(j)) {
            return minDeletions(X, i + 1, j - 1);
        }
 
        // else if last character of String is different to the first character
 
        // 1. Remove last character & recur for the remaining substring
        // 2. Remove first character & recur for the remaining substring
 
        // return 1 (for remove operation) + minimum of the two values
 
        return 1 + Math.min(minDeletions(X, i, j - 1), minDeletions(X, i + 1, j));
    }
 
    public static void main(String[] args)
    {
        String X = "ACBCDBAA";
        int n = X.length();
 
        System.out.print("The minimum number of deletions required are " +
                                minDeletions(X, 0, n - 1));
    }
}




class FindMinimumNumberOfDeletionsRequiredToConvertAStringIntoPalindromeA2
{
    // Function to find out the minimum number of deletions required to
    // convert a given String X[i..j] into a palindrome
    public static int minDeletions(String X, int i, int j, Map<String, Integer> lookup)
    {
        // base condition
        if (i >= j) {
            return 0;
        }

        // construct an unique map key from dynamic elements of the input
        String key = i + "|" + j;

        // if sub-problem is seen for the first time, solve it and
        // store its result in a map
        if (!lookup.containsKey(key))
        {
            // if last character of the String is same as the first character
            if (X.charAt(i) == X.charAt(j)) {
                lookup.put(key, minDeletions(X, i + 1, j - 1, lookup));
            }
            else {
                // if last character of String is different to the first character

                // 1. Remove last character & recur for the remaining substring
                // 2. Remove first character & recur for the remaining substring

                // return 1 (for remove operation) + minimum of the two values

                int res = 1 + Math.min(minDeletions(X, i, j - 1, lookup),
                        minDeletions(X, i + 1, j, lookup));
                lookup.put(key, res);
            }
        }

        // return the subproblem solution from the map
        return lookup.get(key);
    }

    public static void main(String[] args)
    {
        String X = "ACBCDBAA";
        int n = X.length();

        // create a map to store solutions of subproblems
        Map<String, Integer> lookup = new HashMap<>();

        System.out.print("The minimum number of deletions required are " +
                minDeletions(X, 0, n - 1, lookup));
    }
}




class FindMinimumNumberOfDeletionsRequiredToConvertAStringIntoPalindromeA3
{
    // Function to find out the minimum number of deletions required to
    // convert a given String X[0..n-1] into a palindrome
    public static int minDeletions(String X, int n)
    {
        // String Y is reverse of X
        String Y = new StringBuilder(X).reverse().toString();

        // lookup[i][j] stores the length of LCS of substring
        // X[0..i-1], Y[0..j-1]
        int[][] lookup = new int[n + 1][n + 1];

        // fill the lookup table in bottom-up manner
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= n; j++) {
                // if current character of X and Y matches
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    lookup[i][j] = lookup[i - 1][j - 1] + 1;
                }
                // else if current character of X and Y don't match
                else {
                    lookup[i][j] = Math.max(lookup[i - 1][j], lookup[i][j - 1]);
                }
            }
        }

        // Now lookup[n][n] contains the size of the Longest Palindromic Subsequence

        // The minimum number of deletions required will be size of the String
        // minus size of the Palindromic Subsequence

        return n - lookup[n][n];
    }

    public static void main(String[] args)
    {
        String X = "ACBCDBAA";
        int n = X.length();

        System.out.print("The minimum number of deletions required are " +
                minDeletions(X, n));
    }
}