package com.example.techiedelight.Algorithms.String;

class FindAllStringsOfGivenLengthContainingBalancedParentheses
{
    // Function to find all Strings of length n containing
    // balanced parentheses
    public static void balParenthesis(String str, int n, int open)
    {
        // if n is odd with no open parentheses, balanced parentheses
        // cannot be formed
        if ((n & 1) == 1 && open == 0) {
            return;
        }
 
        // base case: length n is reached
        if (n == 0)
        {
            // if output String contains all balanced parenthesis, print it
            if (open == 0) {
                System.out.println(str);
            }
            return;
        }
 
        // Optimization: return if we cannot close all open parentheses
        // with left characters
        if (open > n) {
            return;
        }
 
        // recur with open parentheses
        balParenthesis(str + "(", n - 1, open + 1);
 
        // recur with closed parentheses only if output string has
        // at-least one unclosed parentheses
        if (open > 0) {
            balParenthesis(str + ")", n - 1, open - 1);
        }
    }
 
    public static void main(String[] args)
    {
        int n = 6;
        String str = "";
 
        balParenthesis(str, n, 0);
    }
}