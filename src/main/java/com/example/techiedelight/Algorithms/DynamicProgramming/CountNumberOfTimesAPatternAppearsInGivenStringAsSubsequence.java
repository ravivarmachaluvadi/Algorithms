package com.example.techiedelight.Algorithms.DynamicProgramming;

class CountNumberOfTimesAPatternAppearsInGivenStringAsSubsequence
{
    // Function to count number of times the pattern Y[0..n)
    // appears in given String X[0..m) as a subsequence
    public static int count(String X, String Y, int m, int n)
    {
        // Base case 1: if only one character is left
        if (m == 1 && n == 1)
            return (X.charAt(0) == Y.charAt(0)) ? 1: 0;
 
        // Base case 2: if input String X reaches its end,
        if (m == 0) {
            return 0;
        }
 
        // Base case 3: if pattern Y reaches its end, we have found
        // subsequence
        if (n == 0) {
            return 1;
        }
 
        // Optimization: Solution is not possible if number of characters
        // in the String is less than number of characters in the pattern
        if (n > m) {
            return 0;
        }
 
        // if last character of both String and pattern matches,
        // 1. exclude last character in both String and pattern
        // 2. exclude only last character in the String
 
        // else if last character of String and pattern do not match,
        // recur by excluding only last character in the String
 
        return ((X.charAt(m-1) == Y.charAt(n-1)) ?
                    count(X, Y, m - 1, n - 1) : 0)
                + count(X, Y, m - 1, n);
    }
 
    public static void main(String[] args)
    {
        String X = "subsequence";   // input String
        String Y = "sue";        // pattern
 
        System.out.print(count(X, Y, X.length(), Y.length()));
    }
}




class CountNumberOfTimesAPatternAppearsInGivenStringAsSubsequenceA2
{
    // Function to count number of times the pattern Y[0..n)
    // appears in given String X[0..m) as a subsequence
    public static int count(String X, String Y, int m, int n)
    {
        // T[i][j] stores number of of times the pattern Y[0..j)
        // appears in given String X[0..i) as a subsequence
        int[][] T = new int[m + 1][n + 1];

        // if pattern Y is empty, we have found subsequence
        for (int i = 0; i <= m; i++) {
            T[i][0] = 1;
        }

        // If current character of both String and pattern matches,
        // 1. exclude current character in both String and pattern
        // 2. exclude only current character in the String

        // else if current character of String and pattern do not match,
        // exclude current character in the String

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++){
                T[i][j] = ((X.charAt(i-1) == Y.charAt(j-1)) ? T[i-1][j-1] : 0)
                        + T[i-1][j];
            }
        }

        // return last entry in lookup table
        return T[m][n];
    }

    public static void main(String[] args)
    {
        String X = "subsequence";   // input String
        String Y = "sue";        // pattern

        System.out.print(count(X, Y, X.length(), Y.length()));

    }
}