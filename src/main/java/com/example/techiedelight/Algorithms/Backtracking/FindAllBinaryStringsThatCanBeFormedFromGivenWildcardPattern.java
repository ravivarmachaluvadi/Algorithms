package com.example.techiedelight.Algorithms.Backtracking;

import java.util.Stack;

//Recursive solution
class FindAllBinaryStringsThatCanBeFormedFromGivenWildcardPattern
{
    // Find all binary strings that can be formed from given
    // wildcard pattern
    private static void printAllCombinations(char pattern[], int i)
    {
        if (i == pattern.length)
        {
            System.out.println(pattern);
            return;
        }
 
        // if the current character is '?'
        if (pattern[i] == '?')
        {
            for (char ch = '0'; ch <= '1'; ch++)
            {
                // replace '?' with 0 and 1
                pattern[i] = ch;
 
                // recur for the remaining pattern
                printAllCombinations(pattern, i + 1);
 
                // backtrack as array is passed by reference to the function
                pattern[i] = '?';
            }
            return;
        }
 
        // if the current character is 0 or 1, ignore it and
        // recur for the remaining pattern
        printAllCombinations(pattern, i + 1);
    }
 
    public static void main(String[] args)
    {
        char[] pattern = "1?11?00?1?".toCharArray();
        printAllCombinations(pattern, 0);
    }
}


//Iterative solution
class FindAllBinaryStringsThatCanBeFormedFromGivenWildcardPatternA1
{
    // Find all binary strings that can be formed from given
    // wildcard pattern
    public static void printAllCombinations(String pattern)
    {
        // create an empty stack (we can also use set, queue, vector
        // or any other container)
        Stack<String> stack = new Stack();
        stack.push(pattern);        // push the pattern into the stack

        int index;

        // loop till stack is empty
        while (!stack.empty())
        {
            // pop string from stack and process it
            String curr = stack.pop();

            // index stores position of first occurrence of wildcard
            // pattern in curr
            if ((index = curr.indexOf('?')) != -1)
            {
                // replace '?' with 0 and 1 and push it to the stack
                for (char ch = '0'; ch <= '1'; ch++)
                {
                    curr = curr.substring(0, index) + ch +
                            curr.substring(index + 1);
                    stack.push(curr);
                }
            }

            // If no wildcard pattern is found, print the string
            else
                System.out.println(curr);
        }
    }

    public static void main(String[] args)
    {
        String str = "1?11?00?1?";

        printAllCombinations(str);
    }
}