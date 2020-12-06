package com.example.techiedelight.Algorithms.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

class CheckIfGivenStringIsInterleavingOfTwoOtherGivenStrings
{
    // Function to check if String X and Y are interleaving of
    // String S or not
    public static boolean interleaved(String X, String Y, String S)
    {
        // return true if we have reached end of all Strings
        if (X.length() == 0 && Y.length() == 0 && S.length() == 0) {
            return true;
        }
 
        // return false if we have reached the end of String S
        // but String X or Y are not empty
 
        if (S.length() == 0) {
            return false;
        }
 
        // if String X is not empty and its first character matches with
        // first character of S, recur for remaining substring
 
        if (X.length() != 0 && S.charAt(0) == X.charAt(0)) {
            return interleaved(X.substring(1), Y, S.substring(1));
        }
 
        // if String Y is not empty and its first character matches with
        // first character of S, recur for remaining substring
 
        if (Y.length() != 0 && S.charAt(0) == Y.charAt(0)) {
            return interleaved(X, Y.substring(1), S.substring(1));
        }
 
        return false;
    }
 
    public static void main(String[] args)
    {
        String X = "ABC";
        String Y = "DEF";
        String S = "ADEBFC";
 
        if (interleaved(X, Y, S)) {
            System.out.print("Given String is interleaving of X and Y");
        } else {
            System.out.print("Given String is not interleaving of X and Y");
        }
    }
}




class CheckIfGivenStringIsInterleavingOfTwoOtherGivenStringsA2
{
    // Function to check if String X and Y are interleaving of
    // String S or not
    public static boolean interleaved(String X, String Y, String S)
    {
        // return true if we have reached end of all Strings
        if (X.length() == 0 && Y.length() == 0 && S.length() == 0) {
            return true;
        }

        // return false if we have reached the end of String S
        // but String X or Y are not empty

        if (S.length() == 0) {
            return false;
        }

        // if String X is not empty and its first character matches with
        // first character of S, recur for remaining substring

        boolean x = (X.length() != 0 && S.charAt(0) == X.charAt(0)) &&
                interleaved(X.substring(1), Y, S.substring(1));

        // if String Y is not empty and its first character matches with
        // first character of S, recur for remaining substring

        boolean y = (Y.length() != 0 && S.charAt(0) == Y.charAt(0)) &&
                interleaved(X, Y.substring(1), S.substring(1));

        return x || y;
    }

    public static void main(String[] args)
    {
        String X = "ABC";
        String Y = "DEF";
        String S = "ADEBFC";

        if (interleaved(X, Y, S)) {
            System.out.print("Given String is interleaving of X and Y");
        } else {
            System.out.print("Given String is not interleaving of X and Y");
        }
    }
}





class CheckIfGivenStringIsInterleavingOfTwoOtherGivenStringsA3
{
    // Function to check if String X and Y are interleaving of
    // String S or not
    public static boolean interleaved(String X, String Y, String S,
                                      Map<String, Boolean> dp)
    {
        // return true if we have reached end of all Strings
        if (X.length() == 0 && Y.length() == 0 && S.length() == 0) {
            return true;
        }

        // return false if we have reached the end of String S
        // but String X or Y are not empty

        if (S.length() == 0) {
            return false;
        }

        // calculate unique map key by using delimiter "|"
        String key = (X + "|" + Y + "|" + S);

        // if sub-problem is seen for the first time
        if (!dp.containsKey(key))
        {
            // if String X is not empty and its first character matches with
            // first character of S, recur for remaining substring

            boolean x = (X.length() != 0 && S.charAt(0) == X.charAt(0)) &&
                    interleaved(X.substring(1), Y, S.substring(1), dp);

            // if String Y is not empty and its first character matches with
            // first character of S, recur for remaining substring

            boolean y = (Y.length() != 0 && S.charAt(0) == Y.charAt(0)) &&
                    interleaved(X, Y.substring(1), S.substring(1), dp);

            dp.put(key, x || y);
        }

        return dp.get(key);
    }

    public static void main(String[] args)
    {
        String X = "ABC";
        String Y = "ACD";
        String S = "ACDABC";

        // map to store solution to already computed sub-problems
        Map<String, Boolean> dp = new HashMap<>();

        if (interleaved(X, Y, S, dp))
            System.out.print("Given String is interleaving of X and Y");
        else
            System.out.print("Given String is not interleaving of X and Y");

    }
}





class CheckIfGivenStringIsInterleavingOfTwoOtherGivenStringsA4
{
    // Function to check if X and Y are interleaving of S or not
    public static boolean interleaved(String X, String Y, String S)
    {
        int M = X.length();
        int N = Y.length();

        // base case: length of given strings doesn't match
        if (M + N != S.length())
            return false;

        // Create a lookup table T[][] to store solutions to already computed
        // sub-problems. T[i][j] will be true when S[0..i+j-1] is an
        // interleaving of X[0..i-1] and Y[0..j-1]
        boolean[][] T = new boolean[M + 1][N + 1];

        // fill the lookup table in bottom-up manner
        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= N; j++) {

                if (i == 0 && j == 0) {            // both strings are empty
                    T[i][j] = true;
                }

                // if current char of S matches with the current char of both A and B
                else if (i != 0 && j != 0 && X.charAt(i - 1) == S.charAt(i + j - 1)
                        && Y.charAt(j - 1) == S.charAt(i + j - 1)) {
                    T[i][j] = T[i - 1][j] || T[i][j - 1];
                }

                // if current char of X matches with the current char of S
                else if (i != 0 && X.charAt(i - 1) == S.charAt(i + j - 1)) {
                    T[i][j] = T[i - 1][j];
                }

                // if current char of Y matches with the current char of S
                else if (j !=0 && Y.charAt(j - 1) == S.charAt(i + j - 1)) {
                    T[i][j] = T[i][j - 1];
                }
            }
        }

        // T[M][N] stores the result
        return T[M][N];
    }

    public static void main(String[] args)
    {
        String X = "ABC";
        String Y = "ACD";
        String S = "ACDABC";

        if (interleaved(X, Y, S)) {
            System.out.println("Given String is interleaving of X and Y");
        }
        else {
            System.out.println("Given String is a not interleaving of X and Y");
        }
    }
}