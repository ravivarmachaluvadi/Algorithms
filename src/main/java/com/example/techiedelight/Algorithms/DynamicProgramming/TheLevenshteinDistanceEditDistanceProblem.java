package com.example.techiedelight.Algorithms.DynamicProgramming;


//The Levenshtein Distance (Edit Distance) Problem
class TheLevenshteinDistanceEditDistanceProblem
{
    // Utility function to find minimum of three numbers
    public static int minimum(int a, int b, int c)
    {
        return Integer.min(a, Integer.min(b, c));
    }
 
    // Function to find Levenshtein Distance between String X and Y
    // m and n are the number of characters in X and Y respectively
    public static int dist(String X, int m, String Y, int n)
    {
        // base case: empty strings (case 1)
        if (m == 0) {
            return n;
        }
 
        if (n == 0) {
            return m;
        }
 
        // if last characters of the strings match (case 2)
        int cost = (X.charAt(m - 1) == Y.charAt(n - 1)) ? 0: 1;
 
        return minimum(dist(X, m - 1, Y, n) + 1,  // deletion (case 3a))
                dist(X, m, Y, n - 1) + 1,         // insertion (case 3b))
                dist(X, m - 1, Y, n - 1) + cost); // substitution (case 2 & 3c)
    }
 
    public static void main(String[] args)
    {
        String X = "kitten", Y = "sitting";
 
        System.out.print("The Levenshtein Distance is " +
                dist(X, X.length(), Y, Y.length()));
    }
}





class TheLevenshteinDistanceEditDistanceProblemA2
{
    // Utility function to find minimum of three numbers
    public static int minimum(int a, int b, int c)
    {
        return Integer.min(a, Integer.min(b, c));
    }

    // Function to find Levenshtein Distance between String X and Y
    // m and n are the number of characters in X and Y respectively
    public static int dist(String X, int m, String Y, int n)
    {
        // for all i and j, T[i,j] will hold the Levenshtein distance between
        // the first i characters of X and the first j characters of Y
        // note that T has (m+1)*(n+1) values

        int[][] T = new int[m + 1][n + 1];

        // source prefixes can be transformed into empty String by
        // dropping all characters

        for (int i = 1; i <= m; i++)
            T[i][0] = i;                // (case 1)

        // target prefixes can be reached from empty source prefix
        // by inserting every character

        for (int j = 1; j <= n; j++)
            T[0][j] = j;                // (case 1)

        int cost;

        // fill the lookup table in bottom-up manner
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (X.charAt(i-1) == Y.charAt(j-1))     // (case 2)
                    cost = 0;                           // (case 2)
                else
                    cost = 1;                           // (case 3c)

                T[i][j] = minimum(T[i - 1][j] + 1,  // deletion (case 3b)
                        T[i][j - 1] + 1,            // insertion (case 3a)
                        T[i - 1][j - 1] + cost);    // replace (case 2 + 3c)
            }
        }

        return T[m][n];
    }

    public static void main(String[] args)
    {
        String X = "kitten", Y = "sitting";

        System.out.print("The Levenshtein Distance is " +
                dist(X, X.length(), Y, Y.length()));
    }
}