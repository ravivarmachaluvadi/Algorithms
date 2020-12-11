package com.example.techiedelight.Algorithms.Stack;

import java.util.Stack;
 
class FindLengthOfTheLongestBalancedParenthesisInAString
{
    // Function to find length of the longest balanced parenthesis in a String
    public static int findMaxLen(String str)
    {
        // create a stack of integers for storing index of parenthesis in the String
        Stack<Integer> stack = new Stack<>();
 
        // initialize the stack by -1
        stack.push(-1);
 
        // stores the length of the longest balanced parenthesis
        int len = 0;
 
        // iterate over characters of the String
        for (int i = 0; i < str.length(); i++)
        {
            // if current character is an opening parenthesis,
            // push its index in the stack
            if (str.charAt(i) == '(') {
                stack.push(i);
            }
 
            // if current character is a closing parenthesis
            else
            {
                // pop top index from the stack
                stack.pop();
 
                // if the stack becomes empty, push current index into the stack
                if (stack.empty()) {
                    stack.push(i);
                    continue;
                }
 
                // get length of the longest balanced parenthesis ending at the
                // current character
                int curr_len = i - stack.peek();
 
                // update length of longest balanced parenthesis if required
                if (len < curr_len) {
                    len = curr_len;
                }
            }
        }
 
        return len;
    }
 
    public static void main(String[] args)
    {
        System.out.println(findMaxLen("((()()"));       // prints 4
        System.out.println(findMaxLen("(((()"));        // prints 2
        System.out.println(findMaxLen("(((("));         // prints 0
        System.out.println(findMaxLen("()()"));         // prints 4
        System.out.println(findMaxLen("(()())(()"));    // prints 6
    }
}