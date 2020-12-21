package com.example.techiedelight.Algorithms.String;

class PatternMatching
{
    // Function to find all occurrences of a pattern of length m
    // in given text of length n
    public static void find(String text, String pattern)
    {
        int n = text.length();
        int m = pattern.length();
 
        int i = 0;
        while (i <= n - m)
        {
            for (int j = 0; j < m; j++)
            {
                if (text.charAt(i + j) != pattern.charAt(j))
                    break;
 
                if (j == m - 1)
                    System.out.println("Pattern occurs with shift " + i);
            }
            i++;
        }
    }
 
    // Program to demonstrate Naive Pattern Matching Algorithm in Java
    public static void main(String[] args)
    {
        String text = "ABCABAABCABAC";
        String pattern = "CAB";
 
        find(text, pattern);
    }
}