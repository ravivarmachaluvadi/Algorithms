package com.example.techiedelight.Algorithms.DynamicProgramming;

class WildcardPatternMatching
{
    // Function that matches input String with given wildcard pattern
    public static boolean isMatching(char[] chars, char[] pattern, int n, int m,
                                     boolean[][] lookup)
    {
        // If both input string and pattern reaches their end,
        // return true
        if (m < 0 && n < 0) {
            return true;
        }
 
        // If only pattern reaches its end, return false
        else if (m < 0) {
            return false;
        }
 
        // If only input string reaches its end, return true
        // if remaining characters in the pattern are all '*'
        else if (n < 0)
        {
            for (int i = 0; i <= m; i++) {
                if (pattern[i] != '*') {
                    return false;
                }
            }
 
            return true;
        }
 
        // If the sub-problem is encountered for the first time
        if (!lookup[n][m])
        {
            if (pattern[m] == '*')
            {
                // 1. * matches with current characters in input string.
                // Here we will move to next character in the string
 
                // 2. Ignore * and move to next character in the pattern
                lookup[n][m] = isMatching(chars, pattern, n - 1, m, lookup) ||
                        isMatching(chars, pattern, n, m - 1, lookup);
            }
            else {
                // If the current character is not a wildcard character, it
                // should match with current character in the input string
                if (pattern[m] != '?' && pattern[m] != chars[n]) {
                    lookup[n][m] = false;
                }
                // check if pattern[0..m-1] matches str[0..n-1]
                else {
                    lookup[n][m] = isMatching(chars, pattern, n - 1, m - 1, lookup);
                }
            }
        }
 
        return lookup[n][m];
    }
 
    public static void main(String[] args)
    {
        char[] str = "xyxzzxy".toCharArray();
        char[] pattern = "x***x?".toCharArray();
 
        // create a DP lookup table
        boolean[][] lookup = new boolean[str.length + 1][pattern.length + 1];
 
        if (isMatching(str, pattern, str.length - 1, pattern.length - 1, lookup)) {
            System.out.print("Match");
        } else {
            System.out.print("No Match");
        }
    }
}




class FindTotalWaysToAchieveGivenSumWithNThrowsOfDiceHavingKFacesA3
{
    // Function that matches input String with given wildcard pattern
    public static boolean isMatching(String str, String pattern)
    {
        // get length of String and wildcard pattern
        int n = str.length();
        int m = pattern.length();

        // create a DP lookup table
        boolean[][] T = new boolean[n+1][m+1];

        // if both pattern and String is empty : match
        T[0][0] = true;

        // handle empty String case (i == 0)
        for (int j = 1; j <= m; j++) {
            if (pattern.charAt(j - 1) == '*') {
                T[0][j] = T[0][j - 1];
            }
        }

        // build matrix in bottom-up manner
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if (pattern.charAt(j-1) == '*') {
                    T[i][j] = T[i - 1][j] || T[i][j - 1];
                }
                else if (pattern.charAt(j-1) == '?' ||
                        str.charAt(i-1) == pattern.charAt(j-1)) {
                    T[i][j] = T[i - 1][j - 1];
                }
            }
        }

        // last cell stores the answer
        return T[n][m];
    }

    // Wildcard Pattern Matching
    public static void main(String[] args)
    {
        String str = "xyxzzxy";
        String pattern = "x***x?";

        if (isMatching(str, pattern)) {
            System.out.print("Match");
        }
        else {
            System.out.print("No Match");
        }
    }
}