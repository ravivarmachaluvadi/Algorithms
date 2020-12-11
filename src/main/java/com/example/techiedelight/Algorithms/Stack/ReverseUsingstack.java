package com.example.techiedelight.Algorithms.Stack;

import java.util.Stack;
 
class ReverseUsingstack
{
    // Iterative function to reverse a given String
    // Note String is passed as reference parameter
    public static void reverse(char[] c)
    {
        // create an empty stack of characters
        Stack<Character> stack = new Stack<>();
 
        // push every character of the given String into the stack
        for (int i = 0; i < c.length; i++) {
            stack.push(c[i]);
        }
 
        // start from index 0
        int k = 0;
 
        // pop characters from the stack until it is empty
        while (!stack.empty()) {
            // assign each popped character back to the input String
            c[k++] = stack.pop();
        }
    }
 
        public static void main(String[] args)
    {
        String str = "Techie Delight";
 
        char[] c = str.toCharArray();
        reverse(c);
        str = new String(c);
 
        System.out.print("ReverseUsingstack of given String is : " + str);
    }
}





class  InPlaceConversionReverse
{
    // Iterative function to reverse a given String
    // Note String is passed as reference parameter
    public static void reverse(char[] c)
    {
        // start with two end points of the given String
        int begin = 0;
        int end = c.length - 1;

        // do till two end-points intersect
        while (begin < end) {
            swap(c, begin++, end--);
        }
    }

    private static void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    public static void main(String[] args)
    {
        String str = "Techie Delight";

        char[] c = str.toCharArray();
        reverse(c);
        str = new String(c);

        System.out.print("" + str);
    }
}