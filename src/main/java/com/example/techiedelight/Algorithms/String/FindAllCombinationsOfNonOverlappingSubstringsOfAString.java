package com.example.techiedelight.Algorithms.String;

import java.util.ArrayDeque;
import java.util.Deque;
 
class FindAllCombinationsOfNonOverlappingSubstringsOfAString
{
    // Find all combinations of non-overlapping substrings of given String
    public static void recur(String str, Deque<String> output)
    {
        // if all characters of the input String are processed,
        // print the output String
        if (str.length() == 0)
        {
            System.out.println(output);
            return;
        }
 
        // add each substring [0, i] in the output string and recur for
        // remaining substring [i+1, n-1]
        for (int i = 0; i < str.length(); i++)
        {
            // push substring [0, i] into output string
            output.addLast(str.substring(0, i + 1));
 
            // recur for remaining String [i+1, n-1]
            recur(str.substring(i + 1), output);
 
            // backtrack (remove current substring from string)
            output.pollLast();
        }
    }
 
    public static void main(String[] args)
    {
        // input String
        String str = "ABCD";
 
        // output string to store non-overlapping substrings
        Deque<String> output = new ArrayDeque<>();
 
        // Print all non-overlapping substrings
        recur(str, output);
    }
}