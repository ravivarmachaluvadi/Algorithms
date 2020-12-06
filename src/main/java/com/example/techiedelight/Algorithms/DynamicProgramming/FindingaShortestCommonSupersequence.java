package com.example.techiedelight.Algorithms.DynamicProgramming;

import java.util.*;
import java.util.stream.Collectors;

class FindingaShortestCommonSupersequence
{
    // Function to return a SCS of substrings X[0..m-1], Y[0..n-1]
    public static String SCS(String X, String Y, int m, int n, int[][] T)
    {
        // if we have reached the end of first string,
        // return second string
        if (m == 0) {
            return Y.substring(0, n);
        }
 
        // if we have reached the end of second string,
        // return first string
        if (n == 0) {
            return X.substring(0, m);
        }
 
        // if last character of X and Y matches, then include it in SSC
        // and recur to find SCS of substring X[0..m-2], Y[0..n-1]
        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            return SCS(X, Y, m - 1, n - 1, T) + X.charAt(m - 1);
        }
        else
        // if the last character of X and Y don't match
        {
            // if top cell of current cell has less value than the left
            // cell, then include current character of String X in SCS
            // and find SCS of substring X[0..m-2], Y[0..n-2]
 
            if (T[m - 1][n] < T[m][n - 1]) {
                return SCS(X, Y, m - 1, n, T) + X.charAt(m - 1);
            }
 
            // if left cell of current cell has less value than the top
            // cell, then include current character of String Y in SCS
            // and find SCS of substring X[0..m-1], Y[0..n-2]
            else {
                return SCS(X, Y, m, n - 1, T) + Y.charAt(n - 1);
            }
        }
    }
 
    // Function to fill lookup table by finding length of SCS of
    // sequences X[0..m-1] and Y[0..n-1]
    public static void SCSLength(String X, String Y, int m, int n, int[][] T)
    {
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
    }
 
    public static void main(String[] args)
    {
        String X = "ABCBDAB", Y = "BDCABA";
        int m = X.length(), n = Y.length();
 
        // lookup table stores solution to already computed sub-problems
        // T[i][j] stores the length of SCS of substring X[0..i-1], Y[0..j-1]
        int[][] T = new int[m + 1][n + 1];
 
        // fill lookup table in bottom-up manner
        SCSLength(X, Y, m, n, T);
 
        // find Shortest Common Supersequence by reading lookup
        // table in top-down manner
        System.out.print("The Shortest Common Supersequence of " + X +
                        " and " + Y + " is " + SCS(X, Y, m, n, T));
    }
}




class FindingAllShortestCommonSupersequence
{
    // define maximum possible length of X and Y
    private static int N;

    // lookup[i][j] stores the length of SCS of substring X[0..i-1], Y[0..j-1]
    private static int[][] lookup;

    // Function to return all SCS of substrings X[0..m-1], Y[0..n-1]
    public static List<String> SCS(String X, String Y, int m, int n)
    {
        // if we have reached the end of first string, create a list
        // containing second substring and return
        if (m == 0) {
            return Arrays.asList(Y.substring(0, n));
        }

        // if we have reached the end of second string, create a list
        // containing first substring and return
        else if (n == 0) {
            return Arrays.asList(X.substring(0, m));
        }

        // if last character of X and Y is same, it should occur
        // only one time in SSC
        if (X.charAt(m - 1) == Y.charAt(n - 1))
        {
            // find all SCS of substring X[0..m-2], Y[0..n-2]
            List<String> scs = SCS(X, Y, m - 1, n - 1);

            // append current character X[m - 1] or Y[n - 1] to all SCS of
            // substring X[0..m-2] and Y[0..n-2]

            return scs.stream()
                    .map(str -> str + X.charAt(m-1))
                    .collect(Collectors.toList());
        }

        // we reach here when the last character of X and Y don't match

        // if top cell of current cell has less value than the left cell,
        // then append current character of string X to all SCS of
        // substring X[0..m-2], Y[0..n-1]

        if (lookup[m - 1][n] < lookup[m][n - 1])
        {
            List<String> scs = SCS(X, Y, m - 1, n);

            return scs.stream()
                    .map(str -> str + X.charAt(m-1))
                    .collect(Collectors.toList());
        }

        // if left cell of current cell has less value than the top cell,
        // then append current character of string Y to all SCS of
        // substring X[0..m-1], Y[0..n-2]

        if (lookup[m][n - 1] < lookup[m - 1][n])
        {
            List<String> scs = SCS(X, Y, m, n - 1);

            return scs.stream()
                    .map(str -> str + Y.charAt(n - 1))
                    .collect(Collectors.toList());

        }

        List<String> result = new ArrayList<>();

        // if top cell value is same as left cell, then go in both
        // top and left directions

        // append current character of string X to all SCS of
        // substring X[0..m-2], Y[0..n-1]
        List<String> top = SCS(X, Y, m - 1, n);
        for (String str : top) {
            result.add(str + X.charAt(m-1));
        }

        // append current character of string Y to all SCS of
        // substring X[0..m-1], Y[0..n-2]
        List<String> left = SCS(X, Y, m, n - 1);
        for (String str : left) {
            result.add(str + Y.charAt(n - 1));
        }

        return result;
    }

    // Function to fill lookup table by finding length of SCS of
    // sequences X[0..m-1] and Y[0..n-1]
    public static void SCSLength(String X, String Y, int m, int n)
    {
        // first row and first column of the lookup table are already 0

        // initialize first column of the lookup table
        for (int i = 0; i <= m; i++) {
            lookup[i][0] = i;
        }

        // initialize first row of the lookup table
        for (int j = 0; j <= n; j++) {
            lookup[0][j] = j;
        }

        // fill the lookup table in bottom-up manner
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                // if current character of X and Y matches
                if (X.charAt(i-1) == Y.charAt(j-1)) {
                    lookup[i][j] = lookup[i - 1][j - 1] + 1;
                }
                // else if current character of X and Y don't match
                else {
                    lookup[i][j] = Integer.min(lookup[i - 1][j] + 1,
                            lookup[i][j - 1] + 1);
                }
            }
        }
    }

    // Function to find all Shortest Common Supersequence of string X and Y
    public static Set<String> SCS(String X, String Y)
    {
        int m = X.length(), n = Y.length();

        // fill lookup table
        SCSLength(X, Y, m, n);

        // find all Shortest Common Supersequence
        List<String> list = SCS(X, Y, m, n);

        // since list can contain duplicates, "copy" the list to set
        Set<String> scs = new HashSet<>(list);

        // return set containing all SCS
        return scs;
    }

    public static void main(String[] args)
    {
        String X = "ABCBDAB", Y = "BDCABA";

        // initialize lookup[][] table
        lookup = new int[X.length() + 1][Y.length() + 1];

        // Find all Shortest Common Supersequence of string X and Y
        Set<String> scs = SCS(X, Y);

        // print all SCS present in the set
        System.out.println("All Shortest Common Supersequence of " + X +
                " and " + Y + " are: " + scs);
    }
}




