package com.example.techiedelight.Algorithms.Stack;

import java.util.Stack;

//
class StackC
{
    public static void main(String[] args)
    {
        Stack<String> stack = new Stack<String>();

        stack.push("A");    // Insert "A" in the stack
        stack.push("B");    // Insert "B" in the stack
        stack.push("C");    // Insert "C" in the stack
        stack.push("D");    // Insert "D" in the stack

        // Prints the top of the stack ("D")
        System.out.println("Top element is: " + stack.peek());

        stack.pop();    // removing the top ("D")
        stack.pop();    // removing the next top ("C")

        // Returns the number of elements present in the stack
        System.out.println("Stack size is " + stack.size());

        // check if stack is empty
        if (stack.empty())
            System.out.println("Stack is Empty");
        else
            System.out.println("Stack is not Empty");
    }
}