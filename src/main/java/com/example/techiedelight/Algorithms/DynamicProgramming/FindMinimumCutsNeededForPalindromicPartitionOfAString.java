package com.example.techiedelight.Algorithms.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

class FindMinimumCutsNeededForPalindromicPartitionOfAString
{
    // Function to check if String X[i..j] is a palindrome or not
    public static boolean isPalindrome(String X, int i, int j)
    {
        while (i <= j) {
            if (X.charAt(i++) != X.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
 
    // Recursive function to find the minimum cuts needed in a String
    // such that each partition is a palindrome
    public static int minPalinPartition(String X, int i, int j)
    {
        // base case: if starting index i and ending index j are equal
        // or X[i..j] is already a palindrome.
 
        if (i == j || isPalindrome(X, i, j)) {
            return 0;
        }
 
        // stores minimum number cuts needed to partition X[i..j]
        int min = Integer.MAX_VALUE;
 
        for (int k = i; k <= j - 1; k++)
        {
            // recur to get minimum cuts required in X[i..k] and X[k+1..j]
            int count = 1 + minPalinPartition(X, i, k) +
                        minPalinPartition(X, k + 1, j);
 
            if (count < min)
                min = count;
        }
 
        // return the minimum cuts required
        return min;
    }
 
    public static void main(String[] args)
    {
        String X = "BABABCBADCD";
 
        System.out.print("The minimum cuts required are "
                + minPalinPartition(X, 0, X.length() - 1));
    }
}




class FindMinimumCutsNeededForPalindromicPartitionOfAStringA2
{
    // Bottom-up DP function to mark if String X[i..j] is a palindrome
    // or not for all possible values of i and j
    public static void findAllPalindromes(String X, boolean[][] isPalin)
    {
        for (int i = X.length() - 1; i >= 0; i--)
        {
            for (int j = i; j < X.length(); j++)
            {
                if (i == j) {
                    isPalin[i][j] = true;
                }
                else if (X.charAt(i) == X.charAt(j)) {
                    isPalin[i][j] = ((j-i == 1)? true: isPalin[i+1][j-1]);
                }
                else {
                    isPalin[i][j] = false;
                }
            }
        }
    }

    // Recursive function to find the minimum cuts needed in a String
    // such that each partition is a palindrome
    public static int minPalinPartition(int i, int j, boolean[][] isPalin,
                                        Map<String, Integer> lookup)
    {
        // base case: if starting index i and ending index j are equal
        // or X[i..j] is already a palindrome.

        if (i == j || isPalin[i][j])
            return 0;

        // construct an unique map key from dynamic elements of the input
        // lookup[key] stores minimum number cuts needed to partition X[i..j]

        String key = i + "|" + j;

        // if sub-problem is seen for the first time, solve it and
        // store its result in a map

        if (!lookup.containsKey(key))
        {
            // take the minimum over each possible position at which the
            // String can be cut

            /*
                (X[i]) | (X[i+1..j])
                (X[i..i+1]) | (X[i+2..j])
                (X[i..i+2]) | (X[i+3..j])
                ...
                ...
                (X[i..j-1]) | (X[j])
            */

            lookup.put(key, Integer.MAX_VALUE);
            for (int k = i; k <= j - 1; k++)
            {
                // recur to get minimum cuts required in X[i..k] and
                // X[k+1..j]

                int count = 1 + minPalinPartition(i, k, isPalin, lookup) +
                        minPalinPartition(k + 1, j, isPalin, lookup);

                if (count < lookup.get(key)) {
                    lookup.put(key, count);
                }
            }
        }

        // return the minimum cuts required
        return lookup.get(key);
    }

    public static void main(String[] args)
    {
        String X = "BABABCBADCD";

        // create a map to store solutions of subproblems
        Map<String, Integer> lookup = new HashMap<>();

        // isPalin[i][j] stores if substring X[i][j] is palindrome or not
        boolean[][] isPalin = new boolean[X.length() + 1][X.length() + 1];

        // find all substrings of X that are palindromes
        findAllPalindromes(X, isPalin);

        System.out.print("The minimum cuts required are "
                + minPalinPartition(0, X.length() - 1, isPalin, lookup));
    }
}




class FindMinimumCutsNeededForPalindromicPartitionOfAStringA3
{
    // Bottom-up DP function to mark if String X[i..j] is a palindrome
    // or not for all possible values of i and j
    public static void findAllPalindromes(String X, boolean[][] isPalin)
    {
        for (int i = X.length() - 1; i >= 0; i--)
        {
            for (int j = i; j < X.length(); j++)
            {
                if (i == j) {
                    isPalin[i][j] = true;
                }
                else if (X.charAt(i) == X.charAt(j)) {
                    isPalin[i][j] = ((j-i == 1) ? true : isPalin[i+1][j-1]);
                }
                else {
                    isPalin[i][j] = false;
                }
            }
        }
    }

    // Iterative function to find the minimum cuts needed in a String
    // such that each partition is a palindrome
    public static int minPalinPartition(String X, boolean[][] isPalin)
    {
        // create a lookup table to store solutions of sub-problems
        // lookup[i] stores the minimum cuts needed in substring X[i..n)

        int[] lookup = new int[X.length()];

        // start from String's end
        for (int i = X.length() - 1; i >= 0; i--)
        {
            lookup[i] = Integer.MAX_VALUE;

            // if X[i...n-1] is a palindrome, total cuts needed is 0
            if (isPalin[i][X.length()-1]) {
                lookup[i] = 0;
            }
            else {
                // else find lookup[i]
                for (int j = X.length() - 2; j >= i; j--) {
                    if (isPalin[i][j]) {
                        lookup[i] = Integer.min(lookup[i], 1 + lookup[j + 1]);
                    }
                }
            }
        }

        return lookup[0];
    }

    public static void main(String[] args)
    {
        String X = "BABABCBADCEDE";     // BAB|ABCBA|D|C|EDE

        // isPalin[i][j] stores if substring X[i][j] is palindrome or not
        boolean[][] isPalin = new boolean[X.length() + 1][X.length() + 1];

        // find all substrings of X that are palindromes
        findAllPalindromes(X, isPalin);

        System.out.println("The minimum cuts required are "
                + minPalinPartition(X, isPalin));
    }
}