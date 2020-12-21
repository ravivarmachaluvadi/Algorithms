package com.example.techiedelight.Algorithms.String;

class LexicographicRank
{
    // Recursive function to calculate factorial of a number
    public static int factorial(int n)
    {
        return (n <= 2) ? n : n * factorial(n - 1);
    }
 
    // Function to find Lexicographic rank of a string
    public static int findLexicographicRank(String str, int n)
    {
        // rank starts from 1
        int rank = 1;
 
        for (int i = 0; i < n; i++)
        {
            // count all smaller characters than str[i] to the right of i
            int count = 0;
            for (int j = i + 1; j <= n; j++)
            {
                if (str.charAt(i) > str.charAt(j))
                    count++;
            }
            // add current count to the rank
            rank += count * factorial(n - i);
        }
 
        return rank;
    }
 
    // main function
    public static void main(String[] args)
    {
        String str = "DCBA";
        int n = str.length();
 
        System.out.print("Lexicographic Rank of " +str +" is "
                + findLexicographicRank(str, n - 1));
 
    }
}