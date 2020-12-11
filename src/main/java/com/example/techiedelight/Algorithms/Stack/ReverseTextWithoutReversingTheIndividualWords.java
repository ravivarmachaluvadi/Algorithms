package com.example.techiedelight.Algorithms.Stack;

import java.util.Stack;
 
class ReverseTextWithoutReversingTheIndividualWords
{
    // Function to reverse a text without reversing the individual words
    public static String reverse(String s)
    {
        // s[low..high] forms a word
        int low = 0, high = 0;
 
        // create an empty stack
        Stack<String> stack = new Stack();
 
        // scan the text
        for (int i = 0; i < s.length(); i++)
        {
            // if space is found, we found a word
            if (s.charAt(i) == ' ')
            {
                // push each word into the stack
                stack.push(s.substring(low, high + 1));
 
                // reset low and high for next word
                low = high = i + 1;
            }
            else
            {
                high = i;
            }
        }
 
        // push last word into the stack
        stack.push(s.substring(low));
 
        // construct the string by following LIFO order
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop()).append(' ');
        }
 
        return sb.substring(0, sb.length() - 1);    // remove last space
    }
 
 
    public static void main(String[] args)
    {
        String s = "preparation Interview Technical IT for material "
                    + "good provide We";
 
        s = reverse(s);
        System.out.println(s);
    }
}






class ReverseTextWithoutReversingTheIndividualWordsA2
{
    // Utility function to swap two elements at positions i and j
    // in the array
    private static void swap(char[] chars, int i, int j)
    {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    // Utility function to reverse the sub-array chars[begin..end]
    public static void reverse(char[] chars, int begin, int end)
    {
        while (begin < end) {
            swap(chars, begin++, end--);
        }
    }

    // Function to reverse a text without reversing the individual words
    public static void reverse(char[] chars)
    {
        // chars[low..high] forms a word
        int low = 0, high = 0;

        // scan the text
        for (int i = 0; i < chars.length; i++)
        {
            // if space is found, we found a word
            if (chars[i] == ' ')
            {
                // reverse the found word
                reverse(chars, low, high);

                // reset low and high for next word
                low = high = i + 1;
            }
            else {
                high = i;
            }
        }

        // reverse last word
        reverse(chars, low, high);

        // reverse the whole text
        reverse(chars, 0, chars.length - 1);
    }

    public static void main(String[] args)
    {
        String string = "preparation Interview Technical IT for material "
                + "good provide We";

        // Since String is immutable in Java, convert it into a char array
        char[] chars = string.toCharArray();
        reverse(chars);

        System.out.println(chars);
    }
}