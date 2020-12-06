    package com.example.techiedelight.Algorithms.DynamicProgramming;

class ImplementDiffUtility
{
    // Function to display the differences between two Strings
    public static void diff(String X, String Y, int m, int n, int[][] lookup)
    {
        // if last character of X and Y matches
        if (m > 0 && n > 0 && X.charAt(m - 1) == Y.charAt(n - 1))
        {
            diff(X, Y, m - 1, n - 1, lookup);
            System.out.print("  " + X.charAt(m - 1));
        }
 
        // current character of Y is not present in X
        else if (n > 0 && (m == 0 || lookup[m][n - 1] >= lookup[m - 1][n]))
        {
            diff(X, Y, m, n - 1, lookup);
            System.out.print(" +" + Y.charAt(n - 1));
        }
 
        // current character of X is not present in Y
        else if (m > 0 && (n == 0 || lookup[m][n - 1] < lookup[m - 1][n]))
        {
            diff(X, Y, m - 1, n, lookup);
            System.out.print(" -" + X.charAt(m - 1));
        }
    }
 
    // Function to fill lookup table by finding the length of LCS
    // of substring X[0..m-1] and Y[0..n-1]
    public static void LCSLength(String X, String Y, int m, int n,
                                int[][] lookup)
    {
        // first column of the lookup table will be all 0
        for (int i = 0; i <= m; i++) {
            lookup[i][0] = 0;
        }
 
        // first row of the lookup table will be all 0
        for (int j = 0; j <= n; j++) {
            lookup[0][j] = 0;
        }
 
        // fill the lookup table in bottom-up manner
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                // if current character of X and Y matches
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    lookup[i][j] = lookup[i - 1][j - 1] + 1;
                }
                    // else if current character of X and Y don't match
                else {
                    lookup[i][j] = Integer.max(lookup[i - 1][j],
                                            lookup[i][j - 1]);
                }
            }
        }
    }
 
    public static void main(String[] args)
    {
        String X = "ABCDFGHJQZ";
        String Y = "ABCDEFGIJKRXYZ";
 
        // lookup[i][j] stores the length of LCS of substring
        // X[0..i-1], Y[0..j-1]
        int[][] lookup = new int[X.length() + 1][Y.length() + 1];
 
        // fill lookup table
        LCSLength(X, Y, X.length(), Y.length(), lookup);
 
        // find difference
        diff(X, Y, X.length(), Y.length(), lookup);
    }
}