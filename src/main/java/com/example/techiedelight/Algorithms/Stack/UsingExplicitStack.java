package com.example.techiedelight.Algorithms.Stack;

import java.util.Stack;

//Reverse a string using stack data structure
class UsingExplicitStack
{
    // Reverse a string using stack container in Java
    public static String reverse(String str)
    {
        // create an empty stack
        Stack<Character> stack = new Stack();
 
        // push each character in the string to the stack
        char[] chars = str.toCharArray();
        for (char c : chars) {
            stack.push(c);
        }
 
        // pop all characters from the stack and
        // put them back to the input string
        for (int i = 0; i < str.length(); i++) {
            chars[i] = stack.pop();
        }
 
        // convert the char array to String and return
        return new String(chars);
    }
 
    public static void main (String[] args)
    {
        String str = "Reverse me";
 
        str = reverse(str);
        System.out.println(str);
    }
}




class UsingExplicitStackA2
{
    // Utility function to swap two elements A[i] and A[j] in the array
    private static void swap(char[] A, int i, int j) {
        char ch = A[i];
        A[i] = A[j];
        A[j] = ch;
    }

    // Reverse a string using implicit stack (recursion) in Java
    public static void reverse(char[] chars, int i, int j)
    {
        if (i < j)
        {
            // swap characters at i'th and j'th index
            swap(chars, i, j);

            // recur with increasing i'th index by position and
            // decreasing j'th index by one position
            reverse(chars, i + 1, j - 1);
        }
    }

    // Wrapper function
    public static String reverse(String str)
    {
        char[] chars = str.toCharArray();
        reverse(chars, 0, str.length() - 1);

        return new String(chars);
    }

    public static void main (String[] args)
    {
        String str = "Reverse me";

        str = reverse(str);
        System.out.println(str);
    }
}