package com.example.techiedelight.Algorithms.DynamicProgramming;

class CheckIfAStringIsKPalindromeOrNot
{
    // Function to check if the given string is K-Palindrome or not
    public static int isKPalindrome(String X, int m, String Y, int n)
    {
        // if either string is empty, remove all characters from other string
        if (m == 0 || n == 0) {
            return n + m;
        }
 
        // ignore last characters of both strings if they are same
        // and recur for remaining characters
        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            return isKPalindrome(X, m - 1, Y, n - 1);
        }
 
        // if last character of both strings is different
 
        // remove last character from the first string and recur
        int x = isKPalindrome(X, m - 1, Y, n);
 
        // remove last character from the second string and recur
        int y = isKPalindrome(X, m, Y, n - 1);
 
        // consider minimum of above two operations plus one
        return 1 + Integer.min(x, y);
    }
 
    public static void main(String[] args)
    {
        String str = "CABCBC";
        int K = 2;
 
        // get reverse of str
        String rev = new StringBuilder(str).reverse().toString();
 
        if (isKPalindrome(str, str.length(), rev, str.length()) <= 2 * K) {
            System.out.print("String is K-Palindrome");
        } else {
            System.out.print("String is not a K-Palindrome");
        }
    }
}




class CheckIfAStringIsKPalindromeOrNotA2
{
    // Function to check if the given string is K-Palindrome or not
    public static boolean isKPalindrome(String X, int K)
    {
        // Y is reverse of X
        String Y = new StringBuilder(X).reverse().toString();

        int n = X.length();

        // lookup table to store solution of already computed sub-problems
        int[][] T = new int[n + 1][n + 1];

        // fill the lookup table T[][] in bottom-up manner
        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= n; j++)
            {
                // if either string is empty, remove all characters from
                // other string
                if (i == 0 || j == 0) {
                    T[i][j] = i + j;
                }

                // ignore last characters of both strings if they are same
                // and process remaining characters
                else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    T[i][j] = T[i - 1][j - 1];
                }

                // if last character of both strings is different, consider
                // minimum by removing last character from the X and Y
                else {
                    T[i][j] = 1 + Integer.min(T[i - 1][j], T[i][j - 1]);
                }
            }
        }

        return (T[n][n] <= 2 * K);
    }

    public static void main(String[] args)
    {
        String str = "CABCBC";
        int K = 2;

        if (isKPalindrome(str, K)) {
            System.out.print("String is K-Palindrome");
        } else {
            System.out.print("String is not a K-Palindrome");
        }
    }
}





class CheckIfAStringIsKPalindromeOrNotA3
{
    // Function to check if the given string is K-Palindrome or not
    public static boolean isKPalindrome(String X, int k)
    {
        // Y is reverse of X
        String Y = new StringBuilder().append(X).reverse().toString();
        int len = Y.length();

        // lookup table to store solution of already computed sub-problems
        // T[i][j] stores the length of LCS of X[0..i-1] and Y[0..j-1]
        int[][] T = new int[len + 1][len + 1];

        // fill the lookup table in bottom-up manner
        for (int i = 1; i <= len; i++)
        {
            for (int j = 1; j <= len; j++)
            {
                // if the current character of X and Y matches
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    T[i][j] = T[i - 1][j - 1] + 1;
                }
                // if the current character of X and Y don't match
                else {
                    T[i][j] = Integer.max(T[i - 1][j], T[i][j - 1]);
                }
            }
        }

        // T[m][n] contains length of LCS for X and Y
        // (or Longest Palindromic Subsequence)

        // for the string to be K-palindrome, the difference between length
        // of Longest Palindromic Subsequence and the string should be <= K
        return (len - T[len][len] <= k);
    }

    public static void main(String[] args)
    {
        String str = "CABCBC";
        int k = 2;

        if (isKPalindrome(str, k)) {
            System.out.print("String is K-Palindrome");
        }
        else {
            System.out.print("String is not a K-Palindrome");
        }
    }
}