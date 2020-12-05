package com.example.techiedelight.Algorithms.arrays;

import java.util.Stack;
 
class FindAllElementsInAnArrayThatAreGreaterThanAllElementsPresentToTheirRight
{
    // Function to print all elements which are greater than all
    // elements present to its right
    public static void find(int[] arr)
    {
        // create an empty stack
        Stack<Integer> stack = new Stack<>();
 
        // do for each element
        for (int value : arr) {
            // pop all the elements that are less than the current element
            while (!stack.isEmpty() && stack.peek() < value) {
                stack.pop();
            }
 
            // push current element into the stack
            stack.push(value);
        }
 
        // print all elements in stack
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 10, 4, 6, 3, 5 };
        find(arr);
    }
}


class FindAllElementsInAnArrayThatAreGreaterThanAllElementsPresentToTheirRightOpti
{
    // Function to print all elements which are greater than all
    // elements present to its right
    public static void find(int[] arr)
    {
        int max_so_far = Integer.MIN_VALUE;

        // traverse the array from right to left
        for (int i = arr.length - 1; i >= 0; i--)
        {
            // if current element is greater than maximum so far,
            // print it and update max_so_far
            if (arr[i] > max_so_far)
            {
                max_so_far = arr[i];
                System.out.printf("%d ", arr[i]);
            }
        }
    }

    public static void main(String[] args)
    {
        int[] arr = { 10, 4, 6, 3, 5 };
        find(arr);
    }
}