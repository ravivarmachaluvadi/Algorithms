package com.example.techiedelight.Algorithms.DynamicProgramming;

class LongestCommonSubsequenceApproach
{
    // Space optimized function to find length of Longest Common Subsequence
    // of substring X[0..m-1] and Y[0..n-1]
    public static int LCSLength(String X, String Y)
    {
        int m = X.length(), n = Y.length();
 
        // allocate storage for one-dimensional arrays curr and prev
        int[] curr = new int[n + 1];
        int[] prev = new int[n + 1];
 
        // fill the lookup table in bottom-up manner
        for (int i = 0; i <= m; i++)
        {
            for (int j = 0; j <= n; j++)
            {
                if (i > 0 && j > 0)
                {
                    // if current character of X and Y matches
                    if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                        curr[j] = prev[j - 1] + 1;
                    }
                    // else if current character of X and Y don't match
                    else {
                        curr[j] = Integer.max(prev[j], curr[j - 1]);
                    }
                }
            }
 
            // replace contents of previous array with current array
            System.arraycopy(curr, 0, prev, 0, n + 1);
        }
 
        // LCS will be last entry in the lookup table
        return curr[n];
    }
 
    public static void main(String[] args)
    {
        String X = "XMJYAUZ", Y = "MZJAWXU";
 
        System.out.print("The length of LCS is "
                + LCSLength(X, Y));
 
    }
}





class LongestCommonSubsequenceApproachA2
{
    // Space optimized function to find length of Longest Common Subsequence
    // of substring X[0..m-1] and Y[0..n-1]
    public static int LCSLength(String X, String Y)
    {
        int m = X.length(), n = Y.length();

        // allocate storage for one-dimensional array curr
        int[] curr = new int[n + 1];
        int prev;

        // fill the lookup table in bottom-up manner
        for (int i = 0; i <= m; i++)
        {
            prev = curr[0];
            for (int j = 0; j <= n; j++)
            {
                int backup = curr[j];
                if (i == 0 || j == 0) {
                    curr[j] = 0;
                }
                else
                {
                    // if current character of X and Y matches
                    if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                        curr[j] = prev + 1;
                    }
                    // else if current character of X and Y don't match
                    else {
                        curr[j] = Integer.max(curr[j], curr[j - 1]);
                    }
                }
                prev = backup;
            }
        }

        // LCS will be last entry in the lookup table
        return curr[n];
    }

    public static void main(String[] args)
    {
        String X = "XMJYAUZ", Y = "MZJAWXU";

        if (X.length() > Y.length()) {
            System.out.print("The length of LCS is " + LCSLength(X, Y));
        } else {
            System.out.print("The length of LCS is " + LCSLength(Y, X));
        }
    }
}